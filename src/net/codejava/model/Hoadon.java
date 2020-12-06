package net.codejava.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Hoadon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ma;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="malichchieu", nullable=false)
	Lichchieu lichchieu;
	
	Long tongtien;
	
	public Hoadon(Long ma, Lichchieu lichchieu, Long tongtien, Set<Ve> ve) {
		super();
		this.ma = ma;
		this.lichchieu = lichchieu;
		this.tongtien = tongtien;
		this.ve = ve;
	}

	public Long getTongtien() {
		return tongtien;
	}

	public void setTongtien(Long tongtien) {
		this.tongtien = tongtien;
	}

	@OneToMany(mappedBy="hoadon", cascade = CascadeType.ALL)
	Set<Ve> ve;

	public Lichchieu getLichchieu() {
		return lichchieu;
	}

	public void setLichchieu(Lichchieu lichchieu) {
		this.lichchieu = lichchieu;
	}

	public Set<Ve> getVe() {
		return ve;
	}

	public Hoadon(Long ma, Lichchieu lichchieu, Set<Ve> ve) {
		super();
		this.ma = ma;
		this.lichchieu = lichchieu;
		this.ve = ve;
	}

	public void setVe(Set<Ve> ve) {
		this.ve = ve;
	}

	public Hoadon() {
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
		result = prime * result + ((lichchieu == null) ? 0 : lichchieu.hashCode());
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
		result = prime * result + ((tongtien == null) ? 0 : tongtien.hashCode());
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
		Hoadon other = (Hoadon) obj;
		if (lichchieu == null) {
			if (other.lichchieu != null)
				return false;
		} else if (!lichchieu.equals(other.lichchieu))
			return false;
		if (ma == null) {
			if (other.ma != null)
				return false;
		} else if (!ma.equals(other.ma))
			return false;
		if (tongtien == null) {
			if (other.tongtien != null)
				return false;
		} else if (!tongtien.equals(other.tongtien))
			return false;
		if (ve == null) {
			if (other.ve != null)
				return false;
		} else if (!ve.equals(other.ve))
			return false;
		return true;
	}
	
	
}
