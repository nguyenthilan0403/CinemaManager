package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Lichchieu;
import net.codejava.model.Phim;
import net.codejava.service.LichchieuService;
import net.codejava.service.PhimService;

@Controller
public class DatVeController {
	@Autowired PhimService phimService;
	@Autowired LichchieuService lichchieuService;
	
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
		
		System.out.println("vao controller datve phim");
		List<Lichchieu> lichchieu = lichchieuService.findByPhim(phimService.get(maphim));
		System.out.println("da lay xong lich chieu");
		Phim phim = phimService.get(maphim);
		model.addObject("phim", phim);
		model.addObject("danhsachlichchieu", lichchieu);
		return model;
	}
}
