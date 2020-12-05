package net.codejava.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import net.codejava.model.Ghe;
import net.codejava.model.Hangghe;
import net.codejava.model.Lichchieu;
import net.codejava.model.Phim;
import net.codejava.model.Phong;
import net.codejava.model.Ve;
import net.codejava.service.CustomerService;
import net.codejava.service.GheService;
import net.codejava.service.HanggheService;
import net.codejava.service.LichchieuService;
import net.codejava.service.PhimService;
import net.codejava.service.PhongService;
import net.codejava.service.VeService;

@Controller
public class LichchieuController {
	@Autowired
	LichchieuService lichchieuService;
	@Autowired
	CustomerService customerService;
	@Autowired
	PhimService phimService;
	@Autowired
	PhongService phongService;
	@Autowired
	HanggheService hanggheService;
	@Autowired
	GheService gheService;
	@Autowired
	VeService veService;
	
	@RequestMapping("/lichchieu")
	public ModelAndView home()
	{
		System.out.println("Vao home lichchieu");
		
		List<Lichchieu> listLichchieu = lichchieuService.listAll();
		
		ModelAndView mav = new ModelAndView("lichchieu/index");
		mav.addObject("listLichchieu", listLichchieu);
		
		return mav;
	}
	
	@RequestMapping(value="/lichchieu/new", method=RequestMethod.GET)
	public ModelAndView newLichchieuForm(ModelMap model) {
		Lichchieu lichchieu = new Lichchieu();
		model.addAttribute("lichchieu", lichchieu);
		
		ModelAndView mav = new ModelAndView("lichchieu/new_lichchieu");
		List<Phim> listPhim = phimService.listAll();
		List<Phong> listPhong = phongService.listAll();
		mav.addObject("listPhim", listPhim);
		mav.addObject("listPhong", listPhong);
		
		return mav;
	}

	@RequestMapping(value="/lichchieu/save", method=RequestMethod.POST)
	public String saveLichchieuForm(@ModelAttribute("model/lichchieu") Lichchieu lichchieu, 
			@RequestParam("maphim") Long maphim, @RequestParam("maphong") Long maphong,
			@RequestParam("ngaychieu") String ngaychieu, @RequestParam("giochieu") String giochieu)
	{
		// ========= LUU LICH CHIEU VAO CSDL
		lichchieu.setPhim(phimService.get(maphim));
		lichchieu.setPhong(phongService.get(maphong));
		lichchieuService.save(lichchieu);
		
		// ========= LAY GIA VE =============
//		String sDate1 = lichchieu.getThoigian(); 
//	    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
//	    Date date1;
//	    try {
//	    	date1=formatter1.parse(sDate1);  
//	    }
//	    catch (Exception e) {
//	    	System.out.println("Unable to convert date of lich chieu table");
//	    	date1 = new Date(1,1,1);
//	    }
	    
//		List<Ghe> listGhe = gheService.findByLichchieu(lichchieu);
//		for(Ghe ghe : listGhe) {
//			System.out.println("Ghe cua lich la: " + ghe.getTen());
//			veService.save(new Ve(9L, ghe, lichchieu));
//		}
		
		System.out.println("Gio chieu = " + giochieu);
		System.out.println("Ngay chieu = " + ngaychieu);
		System.out.println("Them lich chieu xong roi nhe2");
		return "redirect:/lichchieu";
	}

	@RequestMapping(value="/lichchieu/detail")
	public String detailLichchieuForm(@RequestParam Long id)
	{
		Lichchieu lichchieu = lichchieuService.get(id);
		ModelAndView mav = new ModelAndView("lichchieu/detail");

		Phong phong = phongService.get(lichchieu.getPhong().getMa());
		System.out.println("PHong = " + phong.getTen());

////		List<Hangghe> listHangghe = phong.getHangghe();
//		List<Hangghe> listHangghe = lichchieuService.getHangghe(lichchieu);
//		System.out.println("Lay xong list hang ghe roi");
//		for (Hangghe hg : listHangghe) {
//			System.out.println("Hang ghe = " + hg.getTen());
//		}

		return "redirect:/lichchieu";
	}
	
	@RequestMapping(value="lichchieu/delete")
	public String deleteLichchieuForm(@RequestParam Long id) {
		System.out.println("Vao delete lich chieu");
		lichchieuService.delete(id);
		
		return "redirect:/lichchieu";
	}
	
	@RequestMapping("lichchieu/edit")
	public ModelAndView editLichchieuForm(@RequestParam Long id, ModelMap model) {
		ModelAndView mav = new ModelAndView("lichchieu/edit");
		
		Lichchieu lichchieu = lichchieuService.get(id);
		model.addAttribute("selectedPhimId", lichchieu.getPhim().getMa());
		model.addAttribute("selectedPhongId", lichchieu.getPhong().getMa());
		List<Phim> listPhim = phimService.listAll();
		List<Phong> listPhong = phongService.listAll();
		mav.addObject("listPhim", listPhim);
		mav.addObject("listPhong", listPhong);
		mav.addObject("lc", lichchieu);
		
		
		
		return mav;
	}
}
