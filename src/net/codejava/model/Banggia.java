package net.codejava.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banggia  implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ma;
	private String tuthu;
	private String denthu;
	private String thoigian;
	private Long gia;
	public Long getMa() {
		return ma;
	}
	public void setMa(Long ma) {
		this.ma = ma;
	}
	public String getTuthu() {
		return tuthu;
	}
	public void setTuthu(String tuthu) {
		this.tuthu = tuthu;
	}
	public String getDenthu() {
		return denthu;
	}
	public void setDenthu(String denthu) {
		this.denthu = denthu;
	}
	public String getThoigian() {
		return thoigian;
	}
	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denthu == null) ? 0 : denthu.hashCode());
		result = prime * result + ((gia == null) ? 0 : gia.hashCode());
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
		result = prime * result + ((thoigian == null) ? 0 : thoigian.hashCode());
		result = prime * result + ((tuthu == null) ? 0 : tuthu.hashCode());
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
		Banggia other = (Banggia) obj;
		if (denthu == null) {
			if (other.denthu != null)
				return false;
		} else if (!denthu.equals(other.denthu))
			return false;
		if (gia == null) {
			if (other.gia != null)
				return false;
		} else if (!gia.equals(other.gia))
			return false;
		if (ma == null) {
			if (other.ma != null)
				return false;
		} else if (!ma.equals(other.ma))
			return false;
		if (thoigian == null) {
			if (other.thoigian != null)
				return false;
		} else if (!thoigian.equals(other.thoigian))
			return false;
		if (tuthu == null) {
			if (other.tuthu != null)
				return false;
		} else if (!tuthu.equals(other.tuthu))
			return false;
		return true;
	}
	
	public Banggia(Long ma, String tuthu, String denthu, String thoigian, Long gia) {
		super();
		this.ma = ma;
		this.tuthu = tuthu;
		this.denthu = denthu;
		this.thoigian = thoigian;
		this.gia = gia;
	}

	public Banggia() {
	
	}
	
}
