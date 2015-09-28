package model;

public class RoomTypeInfo {
	private int id;
	private String typename;
	private int numofadult;
	private int numofkid;
	private int bedtype;
	private double stdprice;
	private double discprice;
	private double rmprice;
	private double vmprice;
	private String remarks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getNumofadult() {
		return numofadult;
	}
	public void setNumofadult(int numofadult) {
		this.numofadult = numofadult;
	}
	public int getNumofkid() {
		return numofkid;
	}
	public void setNumofkid(int numofkid) {
		this.numofkid = numofkid;
	}
	public int getBedtype() {
		return bedtype;
	}
	public void setBedtype(int bedtype) {
		this.bedtype = bedtype;
	}
	public double getStdprice() {
		return stdprice;
	}
	public void setStdprice(double stdprice) {
		this.stdprice = stdprice;
	}
	public double getDiscprice() {
		return discprice;
	}
	public void setDiscprice(double discprice) {
		this.discprice = discprice;
	}
	public double getRmprice() {
		return rmprice;
	}
	public void setRmprice(double rmprice) {
		this.rmprice = rmprice;
	}
	public double getVmprice() {
		return vmprice;
	}
	public void setVmprice(double vmprice) {
		this.vmprice = vmprice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
