package com.yitengtech.bean;

public class WIFIHot {
	private String mac;		//�ȵ��MAC��ַ
	private int rssi;		//�ȵ��rssiֵ
	
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
		return "�ȵ� [mac=" + mac + ", rssi=" + rssi + "]";
	}
	
	
}
