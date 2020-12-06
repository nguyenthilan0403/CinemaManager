package net.codejava.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Hoadon;
import net.codejava.model.Lichchieu;
import net.codejava.model.Phim;
import net.codejava.model.Ve;
import net.codejava.service.GheService;
import net.codejava.service.HoadonService;
import net.codejava.service.LichchieuService;
import net.codejava.service.PhimService;
import net.codejava.service.VeService;

@Controller
public class DatVeController {
<<<<<<< HEAD
	@Autowired PhimService phimService;
	@Autowired LichchieuService lichchieuService;
	@Autowired GheService gheService;
	@Autowired VeService veService;
	@Autowired HoadonService hoadonService;
	
=======
	@Autowired
	PhimService phimService;
	@Autowired
	LichchieuService lichchieuService;

>>>>>>> main
	@RequestMapping("/datve")
	public ModelAndView DanhSachPhim() {
		ModelAndView model = new ModelAndView("datve/chonphim");
		List<Phim> danhsachphim = phimService.listAll();
		model.addObject("danhsachphim", danhsachphim);
		return model;
	}

	@RequestMapping("/datve/phim")
	public ModelAndView ChonPhim(@RequestParam("id") Long maphim) {
		ModelAndView model = new ModelAndView("datve/phim");

		List<Lichchieu> lichchieu = lichchieuService.getLichChieuTuongLai(phimService.get(maphim));
		Phim phim = phimService.get(maphim);
		model.addObject("phim", phim);
		model.addObject("danhsachlichchieu", lichchieu);
		return model;
	}
	
	
	
//	@RequestMapping("/datve/hoadon")
//	public ModelAndView formHoaDon(@RequestParam Long id)
//	{
//		ModelAndView mav = new ModelAndView("datve/hoadon");
//			
//		Hoadon hoadon = hoadonService.get(id);
//		mav.addObject(hoadon);
//		
//		mav.addObject("listVe", veService.findByHoadon(hoadon));
//		
//		return mav;
//	}
	
	@RequestMapping("/datve/hoadon")
	public ModelAndView formHoaDonWithoutId()
	{
		ModelAndView mav = new ModelAndView("datve/hoadon");
		Hoadon hoadon;
		if (!hoadonganday.isEmpty()) {
			hoadon = hoadonService.get(Long.parseLong(hoadonganday));
		}
		else {
			hoadon = hoadonService.get(8L);
		}
			
		mav.addObject(hoadon);
		mav.addObject("listVe", veService.findByHoadon(hoadon));
		
		return mav;
	}
	
	private String hoadonganday;
	
	@RequestMapping(value="/datve/thanhtoan", method=RequestMethod.POST)
	public String ThanhToan(@RequestBody String selectedVe,@RequestParam("giatien") Long giatien,
			@RequestParam("lichchieu") Long malichchieu) {
		
		String[] arrOfStr = selectedVe.split("&selectedVe%5B%5D=");
		Hoadon hd = new Hoadon();
		Lichchieu lc = lichchieuService.get(malichchieu);
		hd.setLichchieu(lc);
		hd.setTongtien(giatien);
		hoadonService.save(hd);
		for (String s : arrOfStr)
		{
			try {
				Long v = Long.parseLong(s);
				Ve ve = veService.get(v);
				Ve veNew = new Ve();
				veNew.setGhe(ve.getGhe());
				veNew.setGiatien(ve.getGiatien());
				veNew.setLichchieu(lc);
				veNew.setHoadon(hd);
				
				veService.delete(ve.getMa());
				veService.save(veNew);
			}
			catch (Exception e) {
				System.out.println("Unable to convert: " + s);
			}
		}
		
		System.out.println("Save hoa don roi nha6");

		hoadonganday = hd.getMa().toString();
//		return "datve/hoadon?id=" + hd.getMa();
		
		return "datve/hoadon";
//		return "redirect:/";
	}
	
	@RequestMapping("/datve/seat")
	public ModelAndView formChonghe()
	{
		System.out.println("Vao dat ve roi nhe 515");
		Lichchieu lichchieu = lichchieuService.get(18L);
		
		// LAY DANH SACH VE THEO LICH CHIEU
		List<Ve> listVe = veService.findByLichchieu(lichchieu);
		Collections.sort(listVe);

		ModelAndView mav = new ModelAndView("datve/seat");
		mav.addObject("listVe", listVe);
		mav.addObject("lichchieu", lichchieu);
		
		return mav;
	}
	
//	@RequestMapping(value="/datve/thanhtoan", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//	public String ThanhToan(@RequestBody String selectedVe,@RequestParam("giatien") Long giatien,
//			@RequestParam("lichchieu") Long malichchieu) {
//		
//		String[] arrOfStr = selectedVe.split("&selectedVe%5B%5D=");
//		Hoadon hd = new Hoadon();
//		Lichchieu lc = lichchieuService.get(malichchieu);
//		hd.setLichchieu(lc);
//		hd.setTongtien(giatien);
//		hoadonService.save(hd);
//		for (String s : arrOfStr)
//		{
//			try {
//				Long v = Long.parseLong(s);
//				Ve ve = veService.get(v);
//				Ve veNew = new Ve();
//				veNew.setGhe(ve.getGhe());
//				veNew.setGiatien(ve.getGiatien());
//				veNew.setLichchieu(lc);
//				veNew.setHoadon(hd);
//				
//				veService.delete(ve.getMa());
//				veService.save(veNew);
//			}
//			catch (Exception e) {
//				System.out.println("Unable to convert: " + s);
//			}
//		}
//		
//		System.out.println("Save hoa don roi nha223");
//		
//		return "redirect:/datve/hoadon?id=" + hd.getMa();
//	}
}
