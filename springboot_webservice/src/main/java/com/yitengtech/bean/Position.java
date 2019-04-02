package com.yitengtech.bean;

public class Position {
	private double lng;		//¾­¶È
	private double lat;		//Î³¶È
	
	public Position() {
		lng = 116.403847;
		lat = 39.915526;
	}
	public Position(double lng, double lat) {
		this.lat = lat;
		this.lng = lng;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Position (" + lng + ", " + lat + ")";
	}
	
	
	
}
