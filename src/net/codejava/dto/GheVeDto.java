package net.codejava.dto;

import net.codejava.model.Hangghe;
import net.codejava.model.Hoadon;

public class GheVeDto {
	Long ma;
	Hangghe hangghe;
	Long giatien;
	Hoadon hoadon;
	
	public Long getMa() {
		return ma;
	}
	public void setMa(Long maghe) {
		this.ma = maghe;
	}
	public Hangghe getMahangghe() {
		return hangghe;
	}
	public GheVeDto(Long ma, Hangghe hangghe, Long giatien, Hoadon hoadon) {
		super();
		this.ma = ma;
		this.hangghe = hangghe;
		this.giatien = giatien;
		this.hoadon = hoadon;
	}
	public Hangghe getHangghe() {
		return hangghe;
	}
	public void setHangghe(Hangghe hangghe) {
		this.hangghe = hangghe;
	}
	public Hoadon getHoadon() {
		return hoadon;
	}
	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}
	public void setMahangghe(Hangghe mahangghe) {
		this.hangghe = mahangghe;
	}
	public Long getGiatien() {
		return giatien;
	}
	public void setGiatien(Long giatien) {
		this.giatien = giatien;
	}
	public GheVeDto(Long maghe, Hangghe mahangghe, Long giatien) {
		super();
		this.ma = maghe;
		this.hangghe = mahangghe;
		this.giatien = giatien;
	}
	public GheVeDto() {
	}
	
}
