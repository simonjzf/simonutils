
public class SAP_MO {
	private String AUFNR;//工单号
	private String PLNFL;//序列
	private String VORNR;//工序号码
	private String KTSCH;//标准文本码
	private String LTXA1;//工序短文本
	private String MGVRG;//SAP工序预算数量
	private String MEINH;//单位
	private String uid;
	private String MATNR;//工单母件的物料号码
	private String MAKTX;//物料说明
	private String CASEID;//项目代码
	private String CASENAME;//项目说明
	private String WORKCENTER;//工作中心
	private String VENDORID;//供应商编号
	private String VENDORNAME;//供应商名称
	private String PO;//采购订单编号
	private String PVD01;//PVD+AFP
	private String PVD02;//产品规格
	private String PVD03;//颜色
	private String PVD04;//不锈钢
	private String PVD05;//电镀方式
	private String PVD06;//打磨方式
	private String PVD07;//级别
	private String PVD08;//大件
	private String PVD09;//项目说明 
	private String PVD10;//客户产品料号
	private String PVD11;//SAP素材编号
	private String PVD12;//客供素材编号
	private String ISLAST;//最后一道工序 PP03
	private String RETURNVORNR;//返回工序
	private String BASEQTY;//基本数量
	private String SEQTXT;//序列描述
	private String OLDMATERIALID;//旧物料号码
	private String BRANCH_VORNR;
	private String RETURN_VORNR;
	private String APLZL;
	private String AUART;     //工单类型
	private String S_LineType;     //线别
	private String ASVRG;		//报废数量

	public SAP_MO() {
		super();
	}


	public SAP_MO(String aufnr, String caseid, String casename, String islast,
			String ktsch, String ltxa1, String maktx, String matnr,
			String meinh, String mgvrg, String plnfl, String po, String pvd01,
			String pvd02, String pvd03, String pvd04, String pvd05,
			String pvd06, String pvd07, String pvd08, String pvd09,
			String pvd10, String pvd11, String pvd12, String vendorid,
			String vendorname, String vornr, String workcenter, String uid,String returnvornr,
			String baseqty,String seqtxt,String oldMaterialID,String branch_vornr,String return_vornr,String aplzl,String auart,String sLineType,String aSVRG ) {
		super();
		AUFNR = aufnr;
		CASEID = caseid;
		CASENAME = casename;
		ISLAST = islast;
		KTSCH = ktsch;
		LTXA1 = ltxa1;
		MAKTX = maktx;
		MATNR = matnr;
		MEINH = meinh;
		MGVRG = mgvrg;
		PLNFL = plnfl;
		PO = po;
		PVD01 = pvd01;
		PVD02 = pvd02;
		PVD03 = pvd03;
		PVD04 = pvd04;
		PVD05 = pvd05;
		PVD06 = pvd06;
		PVD07 = pvd07;
		PVD08 = pvd08;
		PVD09 = pvd09;
		PVD10 = pvd10;
		PVD11 = pvd11;
		PVD12 = pvd12;
		VENDORID = vendorid;
		VENDORNAME = vendorname;
		VORNR = vornr;
		WORKCENTER = workcenter;
		RETURNVORNR=returnvornr;
		BASEQTY=baseqty;
		SEQTXT=seqtxt;
		this.uid = uid;
		OLDMATERIALID = oldMaterialID;
		BRANCH_VORNR=branch_vornr;
		RETURN_VORNR=return_vornr;
		APLZL=aplzl;
		AUART=auart;
		S_LineType=sLineType;
		ASVRG=aSVRG;
	}

	
	public String getS_LineType() {
		return S_LineType;
	}


	public void setS_LineType(String lineType) {
		S_LineType = lineType;
	}


	public String getAUART() {
		return AUART;
	}


	public void setAUART(String auart) {
		AUART = auart;
	}


	public String getBASEQTY() {
		return BASEQTY;
	}


	public void setBASEQTY(String baseqty) {
		BASEQTY = baseqty;
	}


	public String getAUFNR() {
		return AUFNR;
	}


	public void setAUFNR(String aufnr) {
		AUFNR = aufnr;
	}


	public String getPLNFL() {
		return PLNFL;
	}


	public void setPLNFL(String plnfl) {
		PLNFL = plnfl;
	}


	public String getVORNR() {
		return VORNR==null?"":VORNR;
	}


	public void setVORNR(String vornr) {
		VORNR = vornr;
	}


	public String getKTSCH() {
		return KTSCH==null?"":KTSCH;
	}


	public void setKTSCH(String ktsch) {
		KTSCH = ktsch;
	}


	public String getLTXA1() {
		return LTXA1==null?"":LTXA1;
	}

	public void setLTXA1(String ltxa1) {
		LTXA1 = ltxa1;
	}


	public String getMGVRG() {
		return MGVRG==null?"0":MGVRG;
	}


	public void setMGVRG(String mgvrg) {
		MGVRG = mgvrg;
	}


	public String getMEINH() {
		return MEINH==null?"":MEINH;
	}


	public void setMEINH(String meinh) {
		MEINH = meinh;
	}


	public String getUid() {
		return uid==null?"":uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getMATNR() {
		return MATNR==null?"":MATNR;
	}


	public void setMATNR(String matnr) {
		MATNR = matnr;
	}


	public String getMAKTX() {
		return MAKTX==null?"":MAKTX;
	}


	public void setMAKTX(String maktx) {
		MAKTX = maktx;
	}


	public String getCASEID() {
		return CASEID==null?"":CASEID;
	}


	public void setCASEID(String caseid) {
		CASEID = caseid;
	}


	public String getCASENAME() {
		return CASENAME==null?"":CASENAME;
	}


	public void setCASENAME(String casename) {
		CASENAME = casename;
	}


	public String getWORKCENTER() {
		return WORKCENTER==null?"":WORKCENTER;
	}


	public void setWORKCENTER(String workcenter) {
		WORKCENTER = workcenter;
	}


	public String getVENDORID() {
		return VENDORID==null?"":VENDORID;
	}


	public void setVENDORID(String vendorid) {
		VENDORID = vendorid;
	}


	public String getVENDORNAME() {
		return VENDORNAME==null?"":VENDORNAME;
	}


	public void setVENDORNAME(String vendorname) {
		VENDORNAME = vendorname;
	}


	public String getPO() {
		return PO==null?"":PO;
	}


	public void setPO(String po) {
		PO = po;
	}


	public String getPVD01() {
		return PVD01==null?"":PVD01;
	}


	public void setPVD01(String pvd01) {
		PVD01 = pvd01;
	}


	public String getPVD02() {
		return PVD02==null?"":PVD02;
	}


	public void setPVD02(String pvd02) {
		PVD02 = pvd02;
	}


	public String getPVD03() {
		return PVD03==null?"":PVD03;
	}


	public void setPVD03(String pvd03) {
		PVD03 = pvd03;
	}


	public String getPVD04() {
		return PVD04==null?"":PVD04;
	}


	public void setPVD04(String pvd04) {
		PVD04 = pvd04;
	}


	public String getPVD05() {
		return PVD05==null?"":PVD05;
	}


	public void setPVD05(String pvd05) {
		PVD05 = pvd05;
	}


	public String getPVD06() {
		return PVD06==null?"":PVD06;
	}


	public void setPVD06(String pvd06) {
		PVD06 = pvd06;
	}


	public String getPVD07() {
		return PVD07==null?"":PVD07;
	}


	public void setPVD07(String pvd07) {
		PVD07 = pvd07;
	}


	public String getPVD08() {
		return PVD08==null?"":PVD08;
	}


	public void setPVD08(String pvd08) {
		PVD08 = pvd08;
	}


	public String getPVD09() {
		return PVD09==null?"":PVD09;
	}


	public void setPVD09(String pvd09) {
		PVD09 = pvd09;
	}


	public String getPVD10() {
		return PVD10==null?"":PVD10;
	}


	public void setPVD10(String pvd10) {
		PVD10 = pvd10;
	}


	public String getPVD11() {
		return PVD11==null?"":PVD11;
	}


	public void setPVD11(String pvd11) {
		PVD11 = pvd11;
	}


	public String getPVD12() {
		return PVD12==null?"":PVD12;
	}


	public void setPVD12(String pvd12) {
		PVD12 = pvd12;
	}


	public String getISLAST() {
		return ISLAST;
	}


	public void setISLAST(String islast) {
		ISLAST = islast;
	}

	
	public String getRETURNVORNR() {
		return RETURNVORNR==null?"":RETURNVORNR;
	}


	public void setRETURNVORNR(String returnvornr) {
		RETURNVORNR = returnvornr;
	}
	
	public String getSEQTXT() {
		return SEQTXT==null?"":SEQTXT;
	}


	public void setSEQTXT(String seqtxt) {
		SEQTXT = seqtxt;
	}


	public String getOLDMATERIALID() {
		return OLDMATERIALID;
	}


	public void setOLDMATERIALID(String oLDMATERIALID) {
		OLDMATERIALID = oLDMATERIALID;
	}


	public String getBRANCH_VORNR() {	
		if(BRANCH_VORNR.equals(""))
			return "0";
		else
			return BRANCH_VORNR;
	}


	public void setBRANCH_VORNR(String bRANCH_VORNR) {
		BRANCH_VORNR = bRANCH_VORNR;
	}


	public String getRETURN_VORNR() {
		if(RETURN_VORNR.equals(""))
			return "0";
		else
			return RETURN_VORNR;
	}


	public void setRETURN_VORNR(String rETURN_VORNR) {
		RETURN_VORNR = rETURN_VORNR;
	}


	public String getAPLZL() {
		return APLZL;
	}


	public void setAPLZL(String aPLZL) {
		APLZL = aPLZL;
	}

	public String getASVRG() {
		return ASVRG;
	}


	public void setASVRG(String aSVRG) {
		ASVRG = aSVRG;
	}
}
