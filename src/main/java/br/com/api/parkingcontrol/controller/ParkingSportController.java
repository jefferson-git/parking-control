package br.com.api.parkingcontrol.controller;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.parkingcontrol.dto.ParkingSpotDto;
import br.com.api.parkingcontrol.service.ParkingSpotService;

 
@RestController
@RequestMapping("/parking-sport")
public class ParkingSportController {
	
	@Autowired ParkingSpotService service;
	ModelMapper mapper = new ModelMapper();

	@GetMapping("/{id}")
	public ResponseEntity<ParkingSpotDto> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mapper.map(service.findById(id), ParkingSpotDto.class));
	} 
	   
	@GetMapping
	@SuppressWarnings("unchecked")
	public ResponseEntity <Page<ParkingSpotDto>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.ok().body(mapper.map(service.findAll(pageable), Page.class));
	}
	 
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody ParkingSpotDto dto){		
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(mapper.map(service.create(dto), ParkingSpotDto.class).getId()).toUri()).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody ParkingSpotDto dto, @PathVariable Integer id){		
		return ResponseEntity.ok().body(mapper.map(service.uptade(id, dto), ParkingSpotDto.class));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id){		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
