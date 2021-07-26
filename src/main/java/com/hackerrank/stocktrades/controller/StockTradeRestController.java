package com.hackerrank.stocktrades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;

@RestController
public class StockTradeRestController {
	@Autowired
	private StockTradeRepository repository;
	@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED,reason="Application Doesnot Support Put Operation")
	@RequestMapping(method=RequestMethod.PUT,value="/trades/")
	public void putTradeInRepo(@RequestBody StockTrade trade) {
		return;//repository.save(trade);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/trades/")
	public void postTradeInRepo(@RequestBody StockTrade trade) {
		repository.save(trade);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/trades/")
	public List<StockTrade> getTradesInRepo(){
		return repository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/trades/{id}")
	public StockTrade getTradesInRepoById(@PathVariable int id){
		return repository.findById(id).get();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/trade/")
	public List<StockTrade> getTradesInRepoByQueryParam(
			@RequestParam(required = false, value = "userId", defaultValue = "0") int userId,
			@RequestParam(required = false, value = "type", defaultValue = "null") String type) {
		if(userId==0)
			return repository.findByType(type);
		else if(type==null)
			return repository.findByUserId(userId);
		return repository.findByUserIdAndType(userId, type);
	}
	
	@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED,reason="Application Doesnot Support Delete Operation")
	@RequestMapping(method=RequestMethod.DELETE,value="/trades/{id}")
	public void deleteTradesInRepo(@PathVariable int id){
		return;//repository.delete(repository.getOne(id));
	}
}