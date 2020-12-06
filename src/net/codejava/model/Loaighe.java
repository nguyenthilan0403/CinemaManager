package net.codejava.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Loaighe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ma;
	private String ten;
	private Long phuthu;

    @OneToMany(mappedBy = "loaighe", cascade = CascadeType.ALL)
    private Set<Ghe> ghe;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ghe == null) ? 0 : ghe.hashCode());
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
		result = prime * result + ((phuthu == null) ? 0 : phuthu.hashCode());
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
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
		Loaighe other = (Loaighe) obj;
		if (ghe == null) {
			if (other.ghe != null)
				return false;
		} else if (!ghe.equals(other.ghe))
			return false;
		if (ma == null) {
			if (other.ma != null)
				return false;
		} else if (!ma.equals(other.ma))
			return false;
		if (phuthu == null) {
			if (other.phuthu != null)
				return false;
		} else if (!phuthu.equals(other.phuthu))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		return true;
	}

	public Loaighe() {	}
	
	public Loaighe(Long ma, String ten, Long phuthu, Set<Ghe> ghe) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.phuthu = phuthu;
		this.ghe = ghe;
	}

	public Long getMa() {
		return ma;
	}

	public void setMa(Long ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Long getPhuthu() {
		return phuthu;
	}

	public void setPhuthu(Long phuthu) {
		this.phuthu = phuthu;
	}

	public Set<Ghe> getGhe() {
		return ghe;
	}

	public void setGhe(Set<Ghe> ghe) {
		this.ghe = ghe;
	}
}
