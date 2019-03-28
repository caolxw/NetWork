package com.yitengtech.bean;

public class WIFIHot {
	private String mac;		//热点的MAC地址
	private int rssi;		//热点的rssi值
	
	public WIFIHot() {}
	public WIFIHot(String mac, int rssi) {
		this.mac = mac;
		this.rssi = rssi;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getRssi() {
		return rssi;
	}
	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	@Override
	public String toString() {
		return "热点 [mac=" + mac + ", rssi=" + rssi + "]";
	}
	
	
}
