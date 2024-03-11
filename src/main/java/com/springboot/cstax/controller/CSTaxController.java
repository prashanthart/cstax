package com.springboot.cstax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cstax.dto.PIDummyCollection;
import com.springboot.cstax.dto.PIPojo;
import com.springboot.cstax.repository.CSTaxRepository;
import com.springboot.cstax.service.CSTaxServiceImpl;

@RestController
@RequestMapping("/api")
public class CSTaxController {
	
	@Autowired
	CSTaxRepository csTaxRepository;//response db
	
	@Autowired
	CSTaxServiceImpl csTaxServiceImpl;
	
	
	@GetMapping("/getResponse")
	public PIPojo getResponse() {
		List<PIDummyCollection> listpiDummyCollection = csTaxRepository.findAll();
				return csTaxServiceImpl.passedDataToProcess(listpiDummyCollection);
				 
		
	}

}
