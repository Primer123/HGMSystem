package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkin_records")
public class CheckinRecord {
	private int id;
	private String checkinnum;
	private String roomnum;
	private int paymeth; 
	private double deposit;
	private String arrivingdt;
	private String departuredt;
	private String staffid;
	private String memberid;
	private int breakfast;
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
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getArrivingdt() {
		return arrivingdt;
	}
	public void setArrivingdt(String arrivingdt) {
		this.arrivingdt = arrivingdt;
	}
	public String getDeparturedt() {
		return departuredt;
	}
	public void setDeparturedt(String departuredt) {
		this.departuredt = departuredt;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public int getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getPaymeth() {
		return paymeth;
	}
	public void setPaymeth(int paymeth) {
		this.paymeth = paymeth;
	}
}
