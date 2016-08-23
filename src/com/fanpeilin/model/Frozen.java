package com.fanpeilin.model;

public class Frozen {
	private int id;
	private int userid;
	private String ftime;
	private String uftime;//½â¶³
	private String reason;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	public String getUftime() {
		return uftime;
	}
	public void setUftime(String uftime) {
		this.uftime = uftime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Frozen [id=" + id + ", userid=" + userid + ", ftime=" + ftime
				+ ", uftime=" + uftime + ", reason=" + reason + "]";
	}
	
	
}
