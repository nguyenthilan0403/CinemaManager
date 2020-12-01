package net.codejava.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Hangghe implements Serializable{
	
    @Id private String mahang;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "maphong", nullable = false)
	private Phong phong;
	
	@OneToMany(mappedBy="hangghe")
	List<Ghe> Ghe;
	
	public Hangghe(String mahang, Phong phong, List<net.codejava.model.Ghe> ghe, String ten) {
		super();
		this.mahang = mahang;
		this.phong = phong;
		Ghe = ghe;
		this.ten = ten;
	}

	@Override
	public String toString() {
		return "Hangghe [mahang=" + mahang + ", phong=" + phong + ", Ghe=" + Ghe + ", ten=" + ten + "]";
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public void setGhe(List<Ghe> ghe) {
		Ghe = ghe;
	}

	String ten;
	
	public String getMahang() {
		return mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public List<Ghe> getGhe() {
		return Ghe;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ghe == null) ? 0 : Ghe.hashCode());
		result = prime * result + ((mahang == null) ? 0 : mahang.hashCode());
		result = prime * result + ((phong == null) ? 0 : phong.hashCode());
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
		Hangghe other = (Hangghe) obj;
		if (Ghe == null) {
			if (other.Ghe != null)
				return false;
		} else if (!Ghe.equals(other.Ghe))
			return false;
		if (mahang == null) {
			if (other.mahang != null)
				return false;
		} else if (!mahang.equals(other.mahang))
			return false;
		if (phong == null) {
			if (other.phong != null)
				return false;
		} else if (!phong.equals(other.phong))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		return true;
	}

	public Hangghe() {
		
	}
	

}

