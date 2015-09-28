package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkout_records")
public class CheckoutRecord {
	private int id;
	private String checkinnum;
	private String roomnum;
	private String checkindt;
	private String checkoutdt;
	private double roomrate;
	private double goodsdisc;
	private double consumption;
	private double mealrate;
	private double telrate;
	private double ar;
	private int paymeth; 
	private double actualpay;
	private double changes;
	private String staffid;
	private String remarks;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheckinnum() {
		return checkinnum;
	}
	public void setCheckinnum(String checkinnum) {
		this.checkinnum = checkinnum;
	}
	public String getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public String getCheckindt() {
		return checkindt;
	}
	public void setCheckindt(String checkindt) {
		this.checkindt = checkindt;
	}
	public String getCheckoutdt() {
		return checkoutdt;
	}
	public void setCheckoutdt(String checkoutdt) {
		this.checkoutdt = checkoutdt;
	}
	public double getRoomrate() {
		return roomrate;
	}
	public void setRoomrate(double roomrate) {
		this.roomrate = roomrate;
	}
	public double getGoodsdisc() {
		return goodsdisc;
	}
	public void setGoodsdisc(double gooddisc) {
		this.goodsdisc = gooddisc;
	}
	public double getConsumption() {
		return consumption;
	}
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	public double getMealrate() {
		return mealrate;
	}
	public void setMealrate(double mealrate) {
		this.mealrate = mealrate;
	}
	public double getTelrate() {
		return telrate;
	}
	public void setTelrate(double telrate) {
		this.telrate = telrate;
	}
	public double getAr() {
		return ar;
	}
	public void setAr(double ar) {
		this.ar = ar;
	}
	public int getPaymeth() {
		return paymeth;
	}
	public void setPaymeth(int paymeth) {
		this.paymeth = paymeth;
	}
	public double getActualpay() {
		return actualpay;
	}
	public void setActualpay(double actualpay) {
		this.actualpay = actualpay;
	}
	public double getChanges() {
		return changes;
	}
	public void setChanges(double changes) {
		this.changes = changes;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
