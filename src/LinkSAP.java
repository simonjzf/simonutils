import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;

public class LinkSAP {

	/**
	 * @param args
	 */
	static final String POOL_NAME = "Pool";

	public static void main(String[] args)
	{
		
	 	Date now = new Date();
	    SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    String s = outFormat.format(now);
	    System.out.println(s);
		    


        JCO.Client mConnection=null;
        	
		try {
			JCO.Pool pool = JCO.getClientPoolManager().getPool(POOL_NAME);
			if (pool == null) 
			{	
				//ZOL PVD CNPC 	802	workflow	SUPERwl2011	ZH	192.168.108.94	11	10	10
				//GLASS TP TP2	812	workflow	Cni123456	ZH	192.168.108.94	11	10	10
				
				//OLD UAT ALL	782 JAVATEAM	Chow2011	ZH	192.168.101.19	00	10	10
				
				//ZOL PVD CNPC 	782	workflow	Cni123456	ZH	192.168.110.96	11	10	10
				//GLASS TP TP2	783	workflow	Cni123456	ZH	192.168.110.96	11	10	10
				
				
				JCO.addClientPool(
						POOL_NAME, 			// pool name 
						 10, 				// maximum number of connections
						 "812", 			// SAP client
						 "workflow",    	// userid
						 "Cni123456",   		// password
						 "ZH",   			// language
						 "192.168.108.94",  // server host name
//						 "/H/218.103.18.225/H/192.168.110.96",  // server host name
						 "11"); 			// properties

				pool=JCO.getClientPoolManager().getPool(POOL_NAME);
			}
			mConnection=JCO.getClient(POOL_NAME);
			
//			getData(mConnection);
			
			getValuableData(mConnection);	
			
//			getDataFor2222(mConnection);
			
//			getDataForEVT(mConnection);
			
		} 
		catch (Exception e) 
		{	e.printStackTrace();
			System.out.println(e.toString());
		}
		
	}
	
	public static int getData(JCO.Client mConnection)
	{
		try
		{
	        JCO.Repository mRepository;
	        mConnection.isAlive();
	        mRepository = new JCO.Repository("sap", POOL_NAME); 
	
	        IFunctionTemplate ft = mRepository.getFunctionTemplate("Z_MO_INFOR");

	        JCO.Function function = ft.getFunction();
	        JCO.ParameterList input = function.getImportParameterList();
	        
	        input.setValue("391000047959","P_AUFNR");
	        input.setValue("000001","P_APLFL");
	        input.setValue("0032","P_VORNR");
	        input.setValue("","P_ASSIGN");
	        input.setValue("X","P_SEQFLAG");		//X
	        input.setValue("","P_CLASS");
	        input.setValue("X","P_ALL");			//X
	        input.setValue("","P_PREVIOUS");
	        input.setValue("X","P_SEQ_OPT_FLAG");	//X
	        
	        
	        mConnection.execute(function);

	        JCO.Table flights = function.getTableParameterList().getTable("T_MO");
	        
//	        flights.writeHTML("C:\\sapReturn3.html");
	        
//	        GLASS 获取并行序列
	        System.out.print("NO"+"\t "+"APLZL"+"\t\t "+"VORNR"+"\t "+"APLFL"+"\t "+"BRANCH_VORNR"+"\t "+"RETURN_VORNR"+"\t\t "+"LTXA1"+"\n");	        
	        for (int i = 0; i < flights.getNumRows(); i++) {
		       flights.setRow(i);
		       if(!flights.getString("VORNR").equals("0010"))
		       System.out.print(i+1+"\t "+flights.getString("APLZL")+"\t "+flights.getString("VORNR")+"\t "+flights.getString("APLFL")
		    		   +"\t "+flights.getString("BRANCH_VORNR")+"\t\t "+flights.getString("RETURN_VORNR")+"\t\t\t "+flights.getString("LTXA1")+"\n");
	        }
	        
	        
	        System.out.println("============Activity ===========");
			for (int j = 1; j <= 6; j++)// Activity对象6个
			{
				System.out.println("j = "+j);
				
				if (!flights.getString("PAR0" + j).trim().equals(""))
				{					
					System.out.print("VORNR = "+flights.getString("VORNR")+"\t");
					System.out.print("PAR0 = " +flights.getString("PAR0" + j).trim()+"\t");
					System.out.print("UNT0 = " +flights.getString("UNT0" + j)+"\t");
					System.out.println("TXT0 = " +flights.getString("TXT0" + j));
				
				}
			}
			
			
			JCO.releaseClient(mConnection);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			JCO.releaseClient(mConnection);
		}
        
        return 1;

	}
	
	
	
	public static int getValuableData(JCO.Client mConnection)
	{
		try
		{
	        JCO.Repository mRepository;
	        mConnection.isAlive();
	        mRepository = new JCO.Repository("sap", POOL_NAME); 
	
	        IFunctionTemplate ft = mRepository.getFunctionTemplate("Z_MO_INFOR");

	        JCO.Function function = ft.getFunction();
	        JCO.ParameterList input = function.getImportParameterList();
	        
	        input.setValue("391000048387","P_AUFNR");
//	        input.setValue("391000017058","P_AUFNR");
	        
	        
	        input.setValue("000001","P_APLFL");
	        input.setValue("0050","P_VORNR");
	        input.setValue("","P_ASSIGN");
	        input.setValue("X","P_SEQFLAG");
	        input.setValue("X","P_SEQ_OPT_FLAG");
	        mConnection.execute(function);

	        JCO.Table flights = function.getTableParameterList().getTable("T_MO");
	        
	        Map map=new HashMap();
	        List list_mo = new ArrayList();
	        
	       
	        
	        for (int i = 0; i < flights.getNumRows(); i++) {
	        	flights.setRow(i);	
	        	SAP_MO sapmo=new SAP_MO();
		        sapmo.setLTXA1(flights.getString("LTXA1"));
			    sapmo.setPLNFL(flights.getString("APLFL"));
			    sapmo.setVORNR(flights.getString("VORNR"));
			    sapmo.setBRANCH_VORNR(flights.getString("BRANCH_VORNR"));
			    sapmo.setRETURN_VORNR(flights.getString("RETURN_VORNR"));
//			    sapmo.setASVRG(flights.getString("ASVRG"));
			   
		        list_mo.add(sapmo);
	        }
	        map.put("list_mo", list_mo);
	        List<SAP_MO> list=(List)map.get("list_mo");
//	        for (int i = 0; i < list.size(); i++) {
//				if(((SAP_MO)list.get(i)).getPLNFL().equals("000001"))
//					list.remove(i);
//					
//			}
//	        
			Sort(list, "getPLNFL", "asc");
	        
	        for (int i = 0; i < list.size(); i++) {
	        	SAP_MO mo = (SAP_MO) list.get(i);
//	        	System.out.println(mo.getPLNFL() + "\t" + mo.getVORNR() + "\t"+ mo.getBRANCH_VORNR() + "\t"+mo.getRETURN_VORNR()+"\t"+mo.getLTXA1()+"\t"+mo.getASVRG());
	        	System.out.println(mo.getPLNFL() + "\t" + mo.getVORNR() + "\t"+ mo.getBRANCH_VORNR() + "\t"+mo.getRETURN_VORNR()+"\t"+mo.getLTXA1()+"\t");
			}
	        
	        String S_PLNFL="000001";
	        String S_VORNR="0060";
	        
	        List<SAP_MO> listvaluable = getValuableProcessNew(S_PLNFL,S_VORNR,list);
	        
	        System.out.println("*******************有效工序如下*************************");
	        for (int i = 0; i < listvaluable.size(); i++) {
	        	SAP_MO mo = (SAP_MO) listvaluable.get(i);
	    		System.out.println(mo.getPLNFL() + "\t" + mo.getVORNR() + "\t"+ mo.getLTXA1() + "\t"+mo.getS_LineType());	
	        }
			JCO.releaseClient(mConnection);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			JCO.releaseClient(mConnection);
		}
        
        return 1;

	}
	
	
	public static List<SAP_MO> getValuableProcess(String S_PLNFLCurrent,String processCurrent,List<SAP_MO> list){
		
		List<SAP_MO> listvaluable = new ArrayList<SAP_MO>();
		
		for (int i = 0; i < list.size(); i++) {
			SAP_MO mo = (SAP_MO) list.get(i);
			if (S_PLNFLCurrent.equals("000000")) {
				//如果为标准序列的工序，且为最后一道工序,则不获取任何工序信息
				//判断最后一道工序条件：i+1<列表大小；当前工序等于获取工序；获取工序的入口值等于"0";当前工序的下工序的入口值不等于"0"
				if(i+1<list.size()&&processCurrent.equals(mo.getVORNR())&&mo.getBRANCH_VORNR().equals("0")&&!((SAP_MO) list.get(i+1)).getBRANCH_VORNR().equals("0")){
					System.out.println("标准序列最后一道工序: "+processCurrent);
					return listvaluable;					
				}					
				
				//如果为标准序列的工序，且不为最后一道工序，则获取标准序列的下一工序
				//获取条件：a:i+1<列表大小；b:当前工序等于获取工序；c:当前序列为标准序列；满足abc的工序的下一道工序
				if (i+1<list.size()&&processCurrent.equals(mo.getVORNR())&&mo.getPLNFL().equals("000000")) {
					listvaluable.add((SAP_MO) list.get(i + 1));
					System.out.println("标准序列下一道标准序列工序: "+((SAP_MO) list.get(i + 1)).getLTXA1());
				}
				//如果为标准序列的工序，获取等于当前工序的非标准序列入口的工序的第一道工序
				//获取条件：当前工序等于获取工序的入口值；排除同序列的第二道工序
				if (processCurrent.equals(mo.getBRANCH_VORNR())) {				
					
					for (int j = 0; j < listvaluable.size(); j++) {
						SAP_MO moj = (SAP_MO) listvaluable.get(listvaluable.size()-1);
						if(!mo.getPLNFL().equals(moj.getPLNFL())){
							listvaluable.add(mo);							
							break;
							
						}
					}
										
					System.out.println("标准序列下一道非标准序列工序: "+mo.getLTXA1());
				}
			} else {
//				System.out.println(processCurrent+" - "+mo.getRETURN_VORNR());
//				System.out.println(Integer.parseInt(processCurrent));
//				System.out.println(Integer.parseInt(mo.getRETURN_VORNR()));
							
				

//				String tmp="";
//				for (int j = 0; j < list.size(); j++) {
//					SAP_MO moj = (SAP_MO) list.get(j);
//					if(S_PLNFLCurrent.equals(moj.getPLNFL())&&processCurrent.equals(moj.getVORNR()))
//						tmp = moj.getRETURN_VORNR();
//					System.out.println("tmp:"+tmp);
//				}
//				if(S_PLNFLCurrent.equals("000003")&&processCurrent.equals("0050")){
//					System.out.println("---------------------------");
//					System.out.println(i+1);
//					System.out.println(list.size());
//					System.out.println("S_PLNFLCurrent.equals(mo.getPLNFL()): "+S_PLNFLCurrent.equals(mo.getPLNFL()));
//					System.out.println("processCurrent.equals(mo.getVORNR()): "+processCurrent.equals(mo.getVORNR()));
//					System.out.println("Integer.parseInt(processCurrent)<Integer.parseInt(tmp)1: "+Integer.parseInt(processCurrent));
//					System.out.println("Integer.parseInt(processCurrent)<Integer.parseInt(tmp)2:"+Integer.parseInt(tmp));
//					System.out.println("S_PLNFLCurrent.equals((String)(((SAP_MO)list.get(i + 1)).getPLNFL())):"+S_PLNFLCurrent.equals((String)(((SAP_MO)list.get(i + 1)).getPLNFL())));
//
//					System.out.println("=====================");
//				}
//				System.out.println(i+1);
//				System.out.println(list.size());
//				System.out.println(S_PLNFLCurrent.equals(mo.getPLNFL()));
//				System.out.println(processCurrent.equals(mo.getVORNR()));
//				System.out.println(Integer.parseInt(processCurrent)<Integer.parseInt(mo.getRETURN_VORNR()));
				//System.out.println(S_PLNFLCurrent.equals((String)(((SAP_MO)list.get(i + 1)).getPLNFL())));
			
				//如果为非标准序列的工序，且存在当前序列的下一工序，则获取该序列的下一工序
				//获取条件为：a:i+1<列表大小；b:与当前序列相同；c:与当前工序相同；d:当前工序整型值 < 出口工序整型值；e:当前序列与获取工序的序列相同；满足abcde的工序的第一个下工序；
				if(i+1<list.size()&&S_PLNFLCurrent.equals(mo.getPLNFL())&&processCurrent.equals(mo.getVORNR())&&Integer.parseInt(processCurrent)<Integer.parseInt(mo.getRETURN_VORNR())&&S_PLNFLCurrent.equals((String)(((SAP_MO)list.get(i + 1)).getPLNFL()))){
					System.out.println("非标准序列的下一道非标准工序: "+((SAP_MO) list.get(i + 1)).getLTXA1());
					listvaluable.add((SAP_MO) list.get(i + 1));
					return listvaluable;
					
				}else{
//					if(!S_PLNFLCurrent.equals(mo.getPLNFL()))
//						break;
					//如果为非标准序列的工序，且不存在当前序列的下一工序，则获取标准序列的下一工序
					//获取条件为：为标准序列；与当前序列当前工序的出口工序相等的标准序列工序；
					String temp="";
					for (int j = 0; j < list.size(); j++) {
						SAP_MO moj = (SAP_MO) list.get(j);
//						if(S_PLNFLCurrent.equals(moj.getPLNFL())&&processCurrent.equals(moj.getVORNR())&&j+1==list.size())
						if(S_PLNFLCurrent.equals(moj.getPLNFL())&&processCurrent.equals(moj.getVORNR())&&(j+1<list.size()&&!((SAP_MO) list.get(j+1)).getPLNFL().equals(S_PLNFLCurrent)||j+1==list.size()))
							temp = moj.getRETURN_VORNR();
//						System.out.println("temp:"+j+" - "+temp);
					}
					
					for (int k = 0; k < list.size(); k++) {
						SAP_MO mok = (SAP_MO) list.get(k);
						if(mok.getPLNFL().equals("000000")&&mok.getVORNR().equals(mo.getRETURN_VORNR())&&temp.equals(mok.getVORNR())){							
							System.out.println("非标准序列的下一道标准序列工序： "+mok.getLTXA1());
							System.out.println(i);
							listvaluable.add(mok);
							return listvaluable;							
						}
					}
				}
				
			}
		}

		return listvaluable;		
	}

	

	public static List<SAP_MO> getValuableProcessNew(String S_PLNFLCurrent,String processCurrent,List<SAP_MO> list){
		Sort(list, "getPLNFL", "asc");
		
		List<SAP_MO> listvaluable = new ArrayList<SAP_MO>();
		
		for (int i = 0; i < list.size(); i++) {
			SAP_MO mo = (SAP_MO) list.get(i);
			if (S_PLNFLCurrent.equals("000000")) {
				//如果为标准序列的工序，且为最后一道工序,则不获取任何工序信息
				//判断最后一道工序条件：i+1<列表大小；当前工序等于获取工序；获取工序的入口值等于"0";当前工序的下工序的入口值不等于"0"
				if(i+1<list.size()&&processCurrent.equals(mo.getVORNR())&&mo.getBRANCH_VORNR().equals("0")&&!((SAP_MO) list.get(i+1)).getBRANCH_VORNR().equals("0")){
//					System.out.println("标准序列最后一道工序: "+processCurrent);
					return listvaluable;					
				}					
				
				//如果为标准序列的工序，且不为最后一道工序，则获取标准序列的下一工序
				//获取条件：a:i+1<列表大小；b:当前工序等于获取工序；c:当前序列为标准序列；满足abc的工序的下一道工序
				if (i+1<list.size()&&processCurrent.equals(mo.getVORNR())&&mo.getPLNFL().equals("000000")) {
					listvaluable.add((SAP_MO) list.get(i + 1));
//					System.out.println("标准序列下一道标准序列工序: "+((SAP_MO) list.get(i + 1)).getLTXA1());
				}
				//如果为标准序列的工序，获取等于当前工序的非标准序列入口的工序的第一道工序
				//获取条件：当前工序等于获取工序的入口值；排除同序列的第二道工序
				if (processCurrent.equals(mo.getBRANCH_VORNR())) {				
					
					for (int j = 0; j < listvaluable.size(); j++) {
						SAP_MO moj = (SAP_MO) listvaluable.get(listvaluable.size()-1);
						if(!mo.getPLNFL().equals(moj.getPLNFL())){
							listvaluable.add(mo);							
							break;							
						}
					}										
//					System.out.println("标准序列下一道非标准序列工序: "+mo.getLTXA1());
				}
			} else {

				//如果为非标准序列的工序，且存在当前序列的下一工序，则获取该序列的下一工序
				//获取条件为：a:i+1<列表大小；b:与当前序列相同；c:与当前工序相同；d:当前工序整型值 < 出口工序整型值；e:当前序列与获取工序的序列相同；满足abcde的工序的第一个下工序；
				if(i+1<list.size()&&S_PLNFLCurrent.equals(mo.getPLNFL())&&processCurrent.equals(mo.getVORNR())&&Integer.parseInt(processCurrent)<Integer.parseInt(mo.getRETURN_VORNR())&&S_PLNFLCurrent.equals((String)(((SAP_MO)list.get(i + 1)).getPLNFL()))){
//					System.out.println("非标准序列的下一道非标准工序: "+((SAP_MO) list.get(i + 1)).getLTXA1());
					listvaluable.add((SAP_MO) list.get(i + 1));
					return listvaluable;
					
				}else if(S_PLNFLCurrent.equals(mo.getPLNFL())){
					//如果为非标准序列的工序，且不存在当前序列的下一工序，则获取标准序列的下一工序
					//获取条件为：为标准序列；与当前序列当前工序的出口工序相等的标准序列工序；
					String temp="";
					for (int j = 0; j < list.size(); j++) {
						SAP_MO moj = (SAP_MO) list.get(j);
						if(S_PLNFLCurrent.equals(moj.getPLNFL())&&processCurrent.equals(moj.getVORNR())&&(j+1<list.size()&&!((SAP_MO) list.get(j+1)).getPLNFL().equals(S_PLNFLCurrent)||j+1==list.size()))
							temp = moj.getRETURN_VORNR();
						System.out.println("temp:"+temp);
					}
					
					for (int k = 0; k < list.size(); k++) {
						SAP_MO mok = (SAP_MO) list.get(k);
						if(mok.getPLNFL().equals("000000")&&mok.getVORNR().equals(mo.getRETURN_VORNR())&&temp.equals(mok.getVORNR())){							
							System.out.println("非标准序列的下一道标准序列工序： "+mok.getLTXA1());
							listvaluable.add(mok);
							return listvaluable;							
						}
					}
				}
				
			}
		}

		return listvaluable;	
	}
	
	
	
	public static void Sort(List<SAP_MO> list, final String method, final String sort){
		Collections.sort(list, new Comparator() {			
		    public int compare(Object a, Object b) {
		    	int ret = 0;
		    	try{
			    	Method m1 = ((SAP_MO)a).getClass().getMethod(method, null);
			    	Method m2 = ((SAP_MO)b).getClass().getMethod(method, null);
			    	if(sort != null && "desc".equals(sort))//倒序
			    		ret = m2.invoke(((SAP_MO)b), null).toString().compareTo(m1.invoke(((SAP_MO)a), null).toString());	
			    	else//正序
			    		ret = m1.invoke(((SAP_MO)a), null).toString().compareTo(m2.invoke(((SAP_MO)b), null).toString());
		    	}catch(NoSuchMethodException ne){
		    		System.out.println(ne);
				}catch(IllegalAccessException ie){
					System.out.println(ie);
				}catch(InvocationTargetException it){
					System.out.println(it);
				}
		    	return ret;
		    }
		 });
	}
	
	public static int getDataFor2222(JCO.Client mConnection)
	{
		try
		{
	        JCO.Repository mRepository;
	        mConnection.isAlive();
	        mRepository = new JCO.Repository("sap", POOL_NAME); 
	
	        IFunctionTemplate ft = mRepository.getFunctionTemplate("ZMES_GET_STOCK");

	        JCO.Function function = ft.getFunction();
	        JCO.Table input = function.getTableParameterList().getTable("T_MES_STOCK");			

	        input.appendRow(); 
	        input.setValue("3611","WERKS");
	        input.setValue("ZLMF222010010001","MATNR");
	        input.setValue("3100","LGORT");
   

	        mConnection.execute(function);	      
	        JCO.Table flightm = function.getTableParameterList().getTable("T_MES_STOCK");
	        
	        String sql="";
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String D_Occur = sdf.format(new Date());
	        

	        for (int i = 0; i < flightm.getNumRows(); i++) {
		       flightm.setRow(i);
		       sql="INSERT INTO TT_LABST_SAP (D_Occur,WERKS,S_MaterialID,LGORT,N_LABSTQty) VALUES ('"+D_Occur+"','"+flightm.getString("WERKS")+"','"+flightm.getString("MATNR")+"','"+flightm.getString("LGORT")+"','"+flightm.getString("LABST")+"')";
		       System.out.println(sql);
		       
		       //System.out.print(i+1+"\t "+flightm.getString("WERKS")+"\t "+flightm.getString("MATNR")+"\t "+flightm.getString("LGORT")+"\t "+flightm.getString("LABST")+"\t \n");
		       
	        }

   
			JCO.releaseClient(mConnection);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			JCO.releaseClient(mConnection);
		}
        
        return 1;

	}
	
	public static int getDataForEVT(JCO.Client mConnection)
	{
		try
		{
	        JCO.Repository mRepository;
	        mConnection.isAlive();
	        mRepository = new JCO.Repository("sap", POOL_NAME); 
	
	        IFunctionTemplate ft = mRepository.getFunctionTemplate("Z_MES_GET_ROUTING_601");

	        JCO.Function function = ft.getFunction();
	        JCO.Table input = function.getTableParameterList().getTable("ZMES_ROUT_601");			
//	        input.appendRow();
//	        input.setValue("ZLMF222010010002","MATNR");
//	        input.setValue("3611","WERKS");
//	        input.setValue(" ","LGORT");
	        input.appendRow();
	        input.setValue("ZLMF222010010001","MATNR");	   
	        input.setValue("3611","WERKS");
	        input.setValue(" ","LGORT");
   

	        mConnection.execute(function);
	      
	        JCO.Table flightm = function.getTableParameterList().getTable("T_MATNR");
	        JCO.Table flightr = function.getTableParameterList().getTable("T_ROUTING");
//	        JCO.Table flight6 = function.getTableParameterList().getTable("T_601");
	        
//	        flightm.writeHTML("C:\\Documents and Settings\\simon.jia\\Desktop\\sapReturn.html");
//	        System.out.print("NO"+"\t "+"APLZL"+"\t\t "+"VORNR"+"\t "+"APLFL"+"\t "+"BRANCH_VORNR"+"\t "+"RETURN_VORNR"+"\t\t "+"LTXA1"+"\n");
	      
	        for (int i = 0; i < flightm.getNumRows(); i++) {
		       flightm.setRow(i);
		       System.out.print(i+1+"\t "+flightm.getString("MATNR")+"\t "+flightm.getString("WERKS")+"\t "+flightm.getString("IDNRK")+"\t "+flightm.getString("MAKTX_I")+"\t "+flightm.getString("MAKTX")
		    		   +"\t "+flightm.getString("NTGEW")+"\t "+flightm.getString("MENGE")+"\t\t \n");
		       
	        }
	        System.out.println("=============="); 
	        for (int i = 0; i < flightr.getNumRows(); i++) {
	        	flightr.setRow(i);
//			       System.out.print(i+1+"\t "+flightr.getString("MATNR")+"\t "+flightr.getString("MAKTX")+"\t "+flightr.getString("WERKS")+"\t "+flightr.getString("PLNFL")+"\t "+flightr.getString("VORNR")
	    		   System.out.print(i+1+"\t "+flightr.getString("MATNR")+"\t "+flightr.getString("MAKTX")+"\t "+flightr.getString("WERKS")+"\t "+flightr.getString("PLNFL")+"\t "+flightr.getString("VORNR")+"\t "+flightr.getString("AUFAK")
			    		   +"\t "+flightr.getString("LTXA1")+"\t "+flightr.getString("ARBPL")+"\t\t \n");
			       
		        }
//	        System.out.println("==============");
//	        for (int i = 0; i < flight6.getNumRows(); i++) {
//	        	flight6.setRow(i);
//			       System.out.print(i+1+"\t "+flight6.getString("MATNR")+"\t "+flight6.getString("MENGE")+"\t \t \n");
//			       
//		        }	        
	        
	        System.out.println("===============================================================");
	              
			JCO.releaseClient(mConnection);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			JCO.releaseClient(mConnection);
		}
        
        return 1;

	}
}
