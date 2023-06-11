package com.tech.center.order.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/order/create")
	public String createOrder(Model model) {
		model.addAttribute("order", new Order());
		return "projectCreation";
	}
	
	
	@PostMapping("/process_order_creation")
	public String processCreateOrder(Order order) {
		service.saveOrder(order);
		
		return "index";
	}
	
	@GetMapping("/order/list/all")
	public String listOrderAll(Model model) {
		model.addAttribute("orders", service.findAllOrders());
		return "projectList";
	}
	
	@GetMapping("/order/list/sort/{type}/{field}")
	public String listOrderSorted(Model model, @PathVariable String field, @PathVariable String type) {
		model.addAttribute("orders", service.findOrderWithSorting(field, type));
		return "projectList";
	}
	
	@GetMapping("/order/list/pagination/{offset}/{pageSize}")
	public String listOrderPaginated(Model model, @PathVariable int offset, @PathVariable int pageSize) {
		Page<Order> ordersWithPagination = service.findOrderWithPagination(offset, pageSize);
		model.addAttribute("orders", ordersWithPagination);
		return "projectList";
	}
	
	@GetMapping("/order/list/pagination/{offset}/{pageSize}/sort/{type}/{field}")
	public String listOrderPaginatedandSorted(Model model, @PathVariable int offset, @PathVariable int pageSize, @PathVariable String field, @PathVariable String type) {
		Page<Order> ordersWithPagination = service.findOrderWithPaginatiobAndSorting(offset, pageSize, field, type);
		model.addAttribute("orders", ordersWithPagination);
		return "projectList";
	}
	
	@GetMapping("/order/list/{keyword}")
	public String listOrderByKeyword(Model model, @PathVariable String keyword) {
		model.addAttribute("orders", service.findOrderByKeyword(keyword));
		return "projectList";
	}
	
	@RequestMapping(path = {"/", "/search"})
	public String listOrderBySearchBar(Model model, String keyword) {
		if(keyword == null) {
			model.addAttribute("orders", service.findAllOrders());
		}

		model.addAttribute("orders", service.findOrderByKeyword(keyword));
		return "projectList";
	}

}
