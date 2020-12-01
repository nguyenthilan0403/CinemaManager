package net.codejava.controller;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Customer;
import net.codejava.model.Lichchieu;
import net.codejava.model.Phim;
import net.codejava.model.Phong;
import net.codejava.service.CustomerService;
import net.codejava.service.LichchieuService;
import net.codejava.service.PhimService;
import net.codejava.service.PhongService;

@Controller
public class LichchieuController {
	@Autowired
	LichchieuService lichchieuService;
	@Autowired
	CustomerService customerService;
//	@Autowired
//	PhimService phimService;
//	@Autowired
//	PhongService phongService;
	
	@RequestMapping("/lichchieu")
	public ModelAndView home()
	{
		List<Lichchieu> listLichchieu = lichchieuService.listAll();
		
		ModelAndView mav = new ModelAndView("lichchieu/index");
		mav.addObject("listLichchieu", listLichchieu);
		
		return mav;
	}
	
	@RequestMapping(value="/lichchieu/new", method=RequestMethod.GET)
	public String newLichchieuForm(ModelMap model) {
//		Lichchieu lichchieu = new Lichchieu();
//		model.addAttribute("lichchieu", lichchieu);
		
//		ModelAndView mav = new ModelAndView("lichchieu/new_lichchieu");
//		List<Phim> listPhim = phimService.listAll();
//		List<Phong> listPhong = phongService.listAll();
//		mav.addObject("listPhim", listPhim);
//		mav.addObject("listPhong", listPhong);
		
//		model.put("listPhim", listPhim);
//		model.put("listPhong", listPhong);
		
//		return mav;
		return "lichchieu/new_lichchieu";
	}

//	@RequestMapping(value="/lichchieu/save", method=RequestMethod.POST)
//	public String saveLieuchieuForm(@ModelAttribute("model/lichchieu") Lichchieu lichchieu)
//	{
//		System.out.println("Save lich chieu");
//		System.out.println(lichchieu.getThoigian());
//		System.out.println(lichchieu.getPhim());
//		System.out.println(lichchieu.getPhong());
////		System.out.println(method.getParameter("maphim"));
////		System.out.println(request.getParameter("maphong"));
//		lichchieuService.save(lichchieu);
//		return "redirect:/lichchieu";
//	}

	@RequestMapping(value="/lichchieu/save2", method=RequestMethod.POST)
	public String saveLieuchieuForm(@ModelAttribute("model/lichchieu") Lichchieu lichchieu)
	{
		System.out.println("Save lich chieu2");
//		System.out.println("Ma pohng = " + maphong);
//		System.out.println(maphim);
//		System.out.println(maphong);
//		System.out.println(method.getParameter("maphim"));
//		System.out.println(request.getParameter("maphong"));
//		lichchieuService.save(lichchieu);
		return "redirect:/lichchieu";
	}
}
