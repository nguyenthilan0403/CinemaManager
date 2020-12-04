package net.codejava.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ghe implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ma;

	@ManyToOne(optional=false)
	@JoinColumn(name="mahangghe", nullable=false)
	Hangghe hangghe;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="maloaighe", nullable=false)
	Loaighe loaighe;
	
	@OneToMany(mappedBy="ghe",fetch = FetchType.LAZY)
	Set<Ve> ve;
		
	String ten;
	
	public Ghe(Long ma, Hangghe hangghe, Loaighe loaighe, Set<Ve> ve, String ten) {
		super();
		this.ma = ma;
		this.hangghe = hangghe;
		this.loaighe = loaighe;
		this.ve = ve;
		this.ten = ten;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Ghe(Long ma, Hangghe hangghe, Loaighe loaighe, Set<Ve> ve) {
		super();
		this.ma = ma;
		this.hangghe = hangghe;
		this.loaighe = loaighe;
		this.ve = ve;
	}

	public Hangghe getHangghe() {
		return hangghe;
	}

	public void setHangghe(Hangghe hangghe) {
		this.hangghe = hangghe;
	}

	public Loaighe getLoaighe() {
		return loaighe;
	}

	public void setLoaighe(Loaighe loaighe) {
		this.loaighe = loaighe;
	}

	public Set<Ve> getVe() {
		return ve;
	}

	public void setVe(Set<Ve> ve) {
		this.ve = ve;
	}

	public Ghe() {
		super();
	}

	public Long getMa() {
		return ma;
	}

	public void setMa(Long ma) {
		this.ma = ma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hangghe == null) ? 0 : hangghe.hashCode());
		result = prime * result + ((loaighe == null) ? 0 : loaighe.hashCode());
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
		result = prime * result + ((ve == null) ? 0 : ve.hashCode());
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
		Ghe other = (Ghe) obj;
		if (hangghe == null) {
			if (other.hangghe != null)
				return false;
		} else if (!hangghe.equals(other.hangghe))
			return false;
		if (loaighe == null) {
			if (other.loaighe != null)
				return false;
		} else if (!loaighe.equals(other.loaighe))
			return false;
		if (ma == null) {
			if (other.ma != null)
				return false;
		} else if (!ma.equals(other.ma))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		if (ve == null) {
			if (other.ve != null)
				return false;
		} else if (!ve.equals(other.ve))
			return false;
		return true;
	}
	
}
