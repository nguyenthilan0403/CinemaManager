package net.codejava.controller;

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
import net.codejava.service.LichchieuService;
import net.codejava.service.PhimService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired LichchieuService lichchieuService;
	@Autowired PhimService phimService;
//	@Autowired PhimService phongService;

	@Autowired GheRepository gheRepository;
	@Autowired HoadonRepository hoadonRepository;
	@Autowired VeRepository veRepository;

	@RequestMapping("/")
	public ModelAndView home() {

		System.out.println("Vao home customer nhe");
		
		Lichchieu c = lichchieuService.get(1L);
		System.out.println("Da lay xong lich chieu: c.ma = " + c.getMa());
				
		System.out.println("Phong cua lich: ma = " + c.getPhong().getMa());

		List<Ghe> g = gheRepository.findByLichchieu(c.getPhong());
		System.out.println("ghe ne: ");
		for (Ghe ghe : g) {
			System.out.println(ghe.getMa());
		}
//		
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
