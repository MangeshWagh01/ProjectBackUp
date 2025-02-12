package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.MarketRate;
import com.app.service.MarketRateService;



@RestController
@RequestMapping("/rate")
@CrossOrigin(origins = "http://localhost:3000")

public class MarketRateController 
{

	@Autowired
	MarketRateService marketRateService;
	
	
	@GetMapping("/list")
	public ResponseEntity<?>getAllRate()
	{
		List<MarketRate>rates = marketRateService.getAllRates();
		
		if(rates.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
			
		return ResponseEntity.ok(marketRateService.getAllRates());
	}

	@PostMapping("/add")
	public ResponseEntity<?> addRate(@RequestBody MarketRate obj)
	{
		return ResponseEntity.ok(marketRateService.addRate(obj));
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteRate(@PathVariable Long id)
	{
		return ResponseEntity.ok(marketRateService.deleteRate(id));
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?>updateRate(@PathVariable Long id , @RequestBody MarketRate obj)
	{
		
		return ResponseEntity.ok(marketRateService.updateRate(id, obj));
	}
	
	
	
	


}

