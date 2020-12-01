package net.codejava.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Phim implements Serializable {
	
	@Override
	public String toString() {
		return "Phim [ma=" + ma + ", ten=" + ten + ", noidung=" + noidung + ", anh=" + anh + ", theloai=" + theloai
				+ ", lichchieu=" + lichchieu + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ma;
	
	private String ten;
	private String noidung;
	private String anh;
	private String theloai;

//	@OneToMany(mappedBy = "phim", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "phim", cascade = CascadeType.ALL)
	private List<Lichchieu> lichchieu;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anh == null) ? 0 : anh.hashCode());
		result = prime * result + ((lichchieu == null) ? 0 : lichchieu.hashCode());
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
		result = prime * result + ((noidung == null) ? 0 : noidung.hashCode());
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
		result = prime * result + ((theloai == null) ? 0 : theloai.hashCode());
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
		Phim other = (Phim) obj;
		if (anh == null) {
			if (other.anh != null)
				return false;
		} else if (!anh.equals(other.anh))
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
		if (noidung == null) {
			if (other.noidung != null)
				return false;
		} else if (!noidung.equals(other.noidung))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		if (theloai == null) {
			if (other.theloai != null)
				return false;
		} else if (!theloai.equals(other.theloai))
			return false;
		return true;
	}

	public Phim(Long ma, String ten, String noidung, String anh, String theloai, List<Lichchieu> lichchieu) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.noidung = noidung;
		this.anh = anh;
		this.theloai = theloai;
		this.lichchieu = lichchieu;
	}

	public Phim() {
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

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

	public List<Lichchieu> getLichchieu() {
		return lichchieu;
	}

	public void setLichchieu(List<Lichchieu> lichchieu) {
		this.lichchieu = lichchieu;
	}
	
	
}
