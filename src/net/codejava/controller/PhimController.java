package net.codejava.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Lichchieu;
import net.codejava.model.Phim;
import net.codejava.model.Ve;
import net.codejava.service.CustomerService;
import net.codejava.service.GheService;
import net.codejava.service.HanggheService;
import net.codejava.service.LichchieuService;
import net.codejava.service.PhimService;
import net.codejava.service.VeService;
import net.codejava.util.Uti;

@Controller
public class PhimController {

	@Autowired LichchieuService lichchieuService;
	@Autowired PhimService phimService;
	@Autowired PhimService phongService;
	@Autowired HanggheService hanggheService;
	@Autowired GheService gheService;
	@Autowired VeService veService;
	
	@RequestMapping("/phim")
	public ModelAndView home(ModelMap model)
	{
		// ============= LIST VE =============
//		List<Ve> listVe = veService.findByLichchieu(lichchieuService.get(18L));
//		Collections.sort(listVe);

//		System.out.println("Thu viet ti18");
		// ============= LAY VE VA DUA RA VIEW =============00---
		List<Phim> result = phimService.listAll();
		
		ModelAndView mav = new ModelAndView("phim/index");
		mav.addObject("listPhim", result);
		
		return mav;
	}
	
	@RequestMapping("/phim/new")
	public String newPhimForm(Map<String, Object> model) {
		
		Phim phim = new Phim();
		model.put("phim", phim);
//		System.out.println("Vao new phim roi");
//		List<String> test = Uti.getTheloai();
//		
//		for(String s : test) {
//			System.out.println("list the loai = " + s);
//		}
		
		model.put("listTheloai", Uti.getTheloai());
		return "phim/new_phim";
	}
	
	@RequestMapping(value="/phim/save", method=RequestMethod.POST)
	public String savePhimForm(@ModelAttribute("model/phim") Phim phim)
	{
		System.out.println("Vao save phim");
		System.out.println("The loai = " + phim.getTheloai() + " Ten = " + phim.getTen());
		
		phimService.save(phim);
		return "redirect:/phim";
	}
	
	@RequestMapping(value="/phim/edit")
	public ModelAndView editPhimForm(@RequestParam Long id, ModelMap model) {

		ModelAndView mav = new ModelAndView("phim/edit_phim");
		Phim phim = phimService.get(id);
		mav.addObject("phim", phim);
		mav.addObject("listTheloai", Uti.getTheloai());

		model.addAttribute("selectedTheloai", phim.getTheloai());
		
		return mav;
	}
	
	@RequestMapping("/phim/delete")
	public String deletePhimForm(@RequestParam Long id) {
		phimService.delete(id);
		
		return "redirect:/phim";
	}
}
