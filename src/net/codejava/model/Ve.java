package net.codejava.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@IdClass(VeId.class)
public class Ve implements Serializable {

	@ManyToOne
	@JoinColumn(name="maghe")
	@Id Ghe ghe;
	
	@ManyToOne
	@JoinColumn(name="mahoadon")
	@Id Hoadon hoadon;
	
	public Ghe getGhe() {
		return ghe;
	}

	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}

	public Hoadon getHoadon() {
		return hoadon;
	}

	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}

	public Long getGiatien() {
		return giatien;
	}

	public void setGiatien(Long giatien) {
		this.giatien = giatien;
	}

	public Ve(Ghe ghe, Hoadon hoadon, Long giatien) {
		super();
		this.ghe = ghe;
		this.hoadon = hoadon;
		this.giatien = giatien;
	}
	Long giatien;
	
	@Override
	public String toString() {
		return "Ve [ghe=" + ghe + ", hoadon=" + hoadon + ", giatien=" + giatien + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ghe == null) ? 0 : ghe.hashCode());
		result = prime * result + ((giatien == null) ? 0 : giatien.hashCode());
		result = prime * result + ((hoadon == null) ? 0 : hoadon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ve other = (Ve) obj;
		if (ghe == null) {
			if (other.ghe != null)
				return false;
		} else if (!ghe.equals(other.ghe))
			return false;
		if (giatien == null) {
			if (other.giatien != null)
				return false;
		} else if (!giatien.equals(other.giatien))
			return false;
		if (hoadon == null) {
			if (other.hoadon != null)
				return false;
		} else if (!hoadon.equals(other.hoadon))
			return false;
		return true;
	}

	public Ve() {
	}

	
	
}
