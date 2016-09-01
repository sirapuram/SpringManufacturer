package com.example.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Order;
import com.example.OrderClient;
import com.example.repository.ManufacturerRepository;

@RestController
public class ManufacturerAPI {
	
	@Autowired
	private OrderClient orderClient;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;

 @RequestMapping(value="/api/manufacturer",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<Manufacturer> add(@RequestBody Manufacturer manufacturer){
	 manufacturerRepository.save(manufacturer);
	 return new ResponseEntity<Manufacturer>(manufacturer,HttpStatus.CREATED);
 }
 
 public ResponseEntity<List<Manufacturer>> findAll(){	 
	 return new ResponseEntity<List<Manufacturer>>(manufacturerRepository.findAll(),HttpStatus.OK);
	 
 }
 
 @RequestMapping(value="/api/manufacturer",method=RequestMethod.GET)
 public ResponseEntity<List<Manufacturer>> findAll(Manufacturer manufacturer){
	// manufacturerRepository.save(manufacturer);
	 return new ResponseEntity<List<Manufacturer>>(manufacturerRepository.findAll(),HttpStatus.OK);
 }
 
 @RequestMapping(value="/api/manufacture/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer,@PathVariable("id")Integer id){
	 Manufacturer manufacturerOne = manufacturerRepository.findOne(id);
	 if(manufacturerOne != null)
	 {
		 manufacturerOne.setActive(manufacturer.getActive());
		 manufacturerOne.setFoundedDate(manufacturer.getFoundedDate());
		 manufacturerOne.setName(manufacturer.getName());
		 manufacturerRepository.save(manufacturerOne);
	 }
   return new ResponseEntity<Manufacturer>(manufacturer,HttpStatus.ACCEPTED);
 }
 
    @RequestMapping("/")
	@ResponseBody
	public List<Order> findAllByOrders(){
		return orderClient.findAll();
	}

}
