package net.codejava.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class VeId implements Serializable{
	Long ghe;
	Long hoadon;
	
	public VeId(Long ghe, Long hoadon) {
		super();
		this.ghe = ghe;
		this.hoadon = hoadon;
	}
	public VeId() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ghe == null) ? 0 : ghe.hashCode());
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
		VeId other = (VeId) obj;
		if (ghe == null) {
			if (other.ghe != null)
				return false;
		} else if (!ghe.equals(other.ghe))
			return false;
		if (hoadon == null) {
			if (other.hoadon != null)
				return false;
		} else if (!hoadon.equals(other.hoadon))
			return false;
		return true;
	}
	
	
}
