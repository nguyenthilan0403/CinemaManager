package net.codejava.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Lichchieu implements Serializable {
	@Override
	public String toString() {
		return "Lichchieu [ma=" + ma + ", thoigian=" + thoigian + ", phim=" + phim + ", phong=" + phong + ", hoadon="
				+ hoadon + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ma;
	
	private String thoigian;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "maphim", nullable = false)
	private Phim phim;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "maphong", nullable = false)
	private Phong phong;
	
	@OneToMany(mappedBy = "lichchieu", cascade = CascadeType.ALL)
	private List<Hoadon> hoadon;
	
	@OneToMany(mappedBy="lichchieu", cascade = CascadeType.ALL)
	List<Ve> ve;

	public Lichchieu(Long ma, String thoigian, Phim phim, Phong phong, List<Hoadon> hoadon) {
		super();
		this.ma = ma;
		this.thoigian = thoigian;
		this.phim = phim;
		this.phong = phong;
		this.hoadon = hoadon;
	}

	public Lichchieu() {
	}

	public Long getMa() {
		return ma;
	}

	public void setMa(Long ma) {
		this.ma = ma;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public List<Hoadon> getHoadon() {
		return hoadon;
	}

	public void setHoadon(List<Hoadon> hoadon) {
		this.hoadon = hoadon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoadon == null) ? 0 : hoadon.hashCode());
		result = prime * result + ((ma == null) ? 0 : ma.hashCode());
		result = prime * result + ((phim == null) ? 0 : phim.hashCode());
		result = prime * result + ((phong == null) ? 0 : phong.hashCode());
		result = prime * result + ((thoigian == null) ? 0 : thoigian.hashCode());
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
		Lichchieu other = (Lichchieu) obj;
		if (hoadon == null) {
			if (other.hoadon != null)
				return false;
		} else if (!hoadon.equals(other.hoadon))
			return false;
		if (ma == null) {
			if (other.ma != null)
				return false;
		} else if (!ma.equals(other.ma))
			return false;
		if (phim == null) {
			if (other.phim != null)
				return false;
		} else if (!phim.equals(other.phim))
			return false;
		if (phong == null) {
			if (other.phong != null)
				return false;
		} else if (!phong.equals(other.phong))
			return false;
		if (thoigian == null) {
			if (other.thoigian != null)
				return false;
		} else if (!thoigian.equals(other.thoigian))
			return false;
		return true;
	}


	
}
