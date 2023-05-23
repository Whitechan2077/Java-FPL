package poly.model;

import java.io.Serializable;

public class Employee implements Serializable{
	private String manv;
	private String hoten;
	private int tuoi;
	private String email;
	private double luong;
	private String hinh;

	public Employee() {
		super();
	}

	public Employee(String manv, String hoten, int tuoi, String email, double luong, String hinh) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.email = email;
		this.luong = luong;
		this.hinh = hinh;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
}
