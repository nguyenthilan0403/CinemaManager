package net.codejava.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Phim;
import net.codejava.service.PhimService;

@Controller
public class PhimController {

	@Autowired
	PhimService phimService;
	
	@RequestMapping("/phim")
	public ModelAndView home()
	{
		List<Phim> result = phimService.listAll();
		
		ModelAndView mav = new ModelAndView("phim/index");
		mav.addObject("listPhim", result);
		return mav;
	}
	
	@RequestMapping("/phim/new")
	public String newPhimForm(Map<String, Object> model) {
		Phim phim = new Phim();
		model.put("phim", phim);
		
		return "phim/new_phim";
	}
	
	@RequestMapping(value="/phim/save", method=RequestMethod.POST)
	public String savePhimForm(@ModelAttribute("model/phim") Phim phim)
	{
		phimService.save(phim);
		return "redirect:/phim";
	}
	
	@RequestMapping(value="/phim/edit")
	public ModelAndView editPhimForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("phim/edit_phim");
		Phim phim = phimService.get(id);
		mav.addObject("phim", phim);
		
		return mav;
	}
	
	@RequestMapping("/phim/delete")
	public String deletePhimForm(@RequestParam Long id) {
		phimService.delete(id);
		
		return "redirect:/phim";
	}
}
