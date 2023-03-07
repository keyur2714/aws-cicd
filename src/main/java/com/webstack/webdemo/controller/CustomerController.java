package com.webstack.webdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webstack.webdemo.dto.CustomerDTO;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	List<CustomerDTO> customers = new ArrayList<>();

	@GetMapping("/list")
	public List<CustomerDTO> list() {
		customers.clear();
		CustomerDTO customerDTO1 = new CustomerDTO(11l, "Keyur", "Pune", "7387029671", "keyurjava27@gmail.com");
		CustomerDTO customerDTO2 = new CustomerDTO(12l, "Denish", "Surat", "7387029661", "denishjava26@gmail.com");
		customers.add(customerDTO1);
		customers.add(customerDTO2);
		return customers;
	}

	@GetMapping("/list/{id}/{name}")
	public CustomerDTO get(@PathVariable Long id, @PathVariable("name") String cname) {
		System.out.println(id + " " + cname);
		return customers.stream().filter(c -> c.getId() == id && c.getName().equals(cname)).collect(Collectors.toList())
				.get(0);
	}

	@GetMapping("/listByAddress")
	public CustomerDTO getByCity(@RequestParam("caddress") String address) {
		System.out.println(address);
		return customers.stream().filter(c -> c.getAddress().equals(address)).collect(Collectors.toList()).get(0);
	}

	@PostMapping("/save")
	public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
		customers.add(customerDTO);
		return customerDTO;
	}
}
