

public class SAP_ACTIVITY {

	private String ProductID;//MES工单号
	private String SAPVORNR;//SAP工序编号
	private String PAR;//编码
	private String UNT;//单位
	private String TXT;//标准文本码
	private String Index;//参数顺序
	private String TransCode;//交收单号
	private String ISMNG;//值

	public SAP_ACTIVITY() {
		super();
	}

	public SAP_ACTIVITY(String ismng, String index, String par,
			String productID, String sapvornr, String txt, String transCode,
			String unt) {
		super();
		ISMNG = ismng;
		Index = index;
		PAR = par;
		ProductID = productID;
		SAPVORNR = sapvornr;
		TXT = txt;
		TransCode = transCode;
		UNT = unt;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getSAPVORNR() {
		return SAPVORNR;
	}

	public void setSAPVORNR(String sapvornr) {
		SAPVORNR = sapvornr;
	}

	public String getPAR() {
		return PAR;
	}

	public void setPAR(String par) {
		PAR = par;
	}

	public String getUNT() {
		return UNT;
	}

	public void setUNT(String unt) {
		UNT = unt;
	}

	public String getTXT() {
		return TXT;
	}

	public void setTXT(String txt) {
		TXT = txt;
	}

	public String getIndex() {
		return Index;
	}

	public void setIndex(String index) {
		Index = index;
	}

	public String getTransCode() {
		return TransCode;
	}

	public void setTransCode(String transCode) {
		TransCode = transCode;
	}

	public String getISMNG() {
		return ISMNG;
	}

	public void setISMNG(String ismng) {
		ISMNG = ismng;
	}

	
}
