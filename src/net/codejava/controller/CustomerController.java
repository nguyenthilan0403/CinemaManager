package net.codejava.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.*;
import net.codejava.repository.*;
import net.codejava.service.CustomerService;
import net.codejava.service.GheService;
import net.codejava.service.HanggheService;
import net.codejava.service.HoadonService;
import net.codejava.service.LichchieuService;
import net.codejava.service.PhimService;
import net.codejava.service.VeService;

@Controller
public class CustomerController {

	@Autowired CustomerService customerService;
	@Autowired LichchieuService lichchieuService;
	@Autowired PhimService phimService;
	@Autowired PhimService phongService;
	@Autowired HanggheService hanggheService;
	@Autowired GheService gheService;
	@Autowired VeService veService;
	@Autowired HoadonService hoadonService;

	@RequestMapping("/")
	public ModelAndView home() {

		System.out.println("Vao home customer nhe");
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(2021, 12,14));
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("Day of weekk 2021 14 = " + dayOfWeek);
		
//		Hoadon hd = new Hoadon();
//		Lichchieu lc = lichchieuService.get(18L);
//		hd.setLichchieu(lc);
//		hd.setTongtien(100L);
//		hoadonService.save(hd);
//		
//		System.out.println("In xong hoa don roi");
//		Ve v1 = veService.get(12L);
//		Ve v2 = new Ve();
//		v2.setLichchieu(v1.getLichchieu());
//		v2.setHoadon(hd);
//		v2.setGiatien(v1.getGiatien());
//		v2.setGhe(v1.getGhe());
//		veService.delete(v1.getMa());
//		veService.save(v2);
		
//		System.out.println("In xong hoa don roi");
////		Ve v1 = new Ve();
//		Ve v1 = veService.get(12L);
//		Ve v2 = new Ve();
//		Ghe g1 = gheService.get(v1.getGhe().getMa());
//		System.out.println("Lay xong ghe");
//		System.out.println("Set ghe");
//		v2.setLichchieu(lc);
//		v2.setHoadon(hd);
//		v2.setMa(v1.getMa());
//		v2.setGiatien(v1.getGiatien());
//		v2.setGhe(g1);
//		veService.delete(v1.getMa());
//		veService.save(v2);
		
//		List<Ghe> listGhe = gheService.findByLichchieu(lichchieuService.get(1L));
//		System.out.println("Lay listghe thanh cong");
//		
//		List<Ve> listVe = veService.findByLichchieu(lichchieuService.get(1L));
//		System.out.println("Lay ve by lich chieu thanh cong");
//		for (Ve ve : listVe) {
//			System.out.println("Ve ghe = " + ve.getGhe().getMa() + " hoadon = " + ve.getHoadon().getMa());
//		}
		
//		for (Ghe ghe : listGhe) {
//			System.out.println("Ghe = " + ghe.getMa() + " Loai: " + ghe.getLoaighe().getTen());
//		}
//		
//		List<GheVeDto> listGheve = gheService.findGheVeDto(lichchieuService.get(1L));
//		System.out.println("List gheve thanh cong6");

//		for (GheVeDto ghe : listGheve) {
////			System.out.println("Gheve = " + ghe.getMa() + " Giatien: " + ghe.getGiatien() + " Hoadon: " + ghe.getHoadon().getMa());
//			System.out.println("Gheve = " + ghe.getMa() + " Giatien: " + ghe.getGiatien());
//		}
//		
//		Lichchieu c = lichchieuService.get(1L);
//		System.out.println("Da lay xong lich chieu: c.ma = " + c.getMa());
//				
//		System.out.println("Phong cua lich: ma = " + c.getPhong().getMa());
//
//		List<Ghe> g = gheRepository.findByLichchieu(c.getPhong());
//		System.out.println("ghe ne: ");
//		for (Ghe ghe : g) {
//			System.out.println(ghe.getMa());
//		}

		List<Customer> listCustomer = customerService.listAll();
		ModelAndView mav = new ModelAndView("customer/index");
		mav.addObject("listCustomer", listCustomer);
		return mav;
	}
	
	@RequestMapping("/customer/new")
	public String newCustomerForm(Map<String, Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		return "customer/new_customer";
	}
	
	@RequestMapping(value = "/customer/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer/customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/";
	}
	
	@RequestMapping("/customer/edit")
	public ModelAndView editCustomerForm(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView("customer/edit_customer");
		Customer customer = customerService.get(id);
		mav.addObject("customer", customer);
		
		return mav;
	}
	
	@RequestMapping("/customer/delete")
	public String deleteCustomerForm(@RequestParam Integer id) {
		customerService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/customer/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Customer> result = customerService.search(keyword);
		ModelAndView mav = new ModelAndView("customer/search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}
