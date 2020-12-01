package net.codejava.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

@Entity
public class Phong implements Serializable {
	
    @Override
	public String toString() {
		return "Phong [ma=" + ma + ", ten=" + ten + ", hangghe=" + hangghe + ", lichchieu=" + lichchieu + "]";
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long ma;
	
	private String ten;
	
	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
	private List<Hangghe> hangghe;

	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
	List<Lichchieu> lichchieu;

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

	public List<Hangghe> getHangghe() {
		return hangghe;
	}

	public void setHangghe(List<Hangghe> hangghe) {
		this.hangghe = hangghe;
	}

	public List<Lichchieu> getLichchieu() {
		return lichchieu;
	}

	public void setLichchieu(List<Lichchieu> lichchieu) {
		this.lichchieu = lichchieu;
	}

	public Phong(Long ma, String ten, List<Hangghe> hangghe, List<Lichchieu> lichchieu) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.hangghe = hangghe;
		this.lichchieu = lichchieu;
	}
	

	public Phong() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hangghe == null) ? 0 : hangghe.hashCode());
		result = prime * result + ((lichchieu == null) ? 0 : lichchieu.hashCode());
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
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
		Phong other = (Phong) obj;
		if (hangghe == null) {
			if (other.hangghe != null)
				return false;
		} else if (!hangghe.equals(other.hangghe))
			return false;
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
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		return true;
	}
	
}
