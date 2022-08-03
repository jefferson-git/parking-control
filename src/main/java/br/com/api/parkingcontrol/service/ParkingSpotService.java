package br.com.api.parkingcontrol.service;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api.parkingcontrol.dto.ParkingSpotDto;
import br.com.api.parkingcontrol.model.ParkingSpotModel;
import br.com.api.parkingcontrol.repository.ParkingSportRepository;
import br.com.api.parkingcontrol.service.contract.ParkingSpotContract;
import br.com.api.parkingcontrol.service.exception.DataIntegrityViolationException;
import br.com.api.parkingcontrol.service.exception.ObjectNotFoundException;

@Service 
@SuppressWarnings("serial")
public class ParkingSpotService implements ParkingSpotContract, Serializable {

	@Autowired ParkingSportRepository repository;
	ModelMapper mapper = new ModelMapper();

	@Override
	public ParkingSpotModel findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Job with,"+ id + " not found"));
	}

	@Override
	public Page<ParkingSpotModel> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public Object create(@Valid ParkingSpotDto dto) {
		dto.setRegistrationDate(LocalDateTime.now());  
		
		if(repository.existsByLicensePlateCar(dto.getLicensePlateCar()))
			throw new DataIntegrityViolationException("Conflito: Placa do Carro já está cadastrada!");
        
        if(repository.existsByParkingSpotNumber(dto.getParkingSpotNumber()))
        	throw new DataIntegrityViolationException("Conflito: A vaga de estacionamento já está em uso!");
        
        if(repository.existsByApartmentAndBlock(dto.getApartment(), dto.getBlock()))
        	throw new DataIntegrityViolationException("Conflito: Vaga de Estacionamento já registrada para outro apartamento/bloco!");
        
		return repository.save(mapper.map(dto, ParkingSpotModel.class));
	}

	@Override
	@Transactional
	public ParkingSpotModel uptade(Integer id, ParkingSpotDto dto) {		 
		var objExists = findById(id);	
		dto.setId(id);
		dto.setRegistrationDate(objExists.getRegistrationDate());

		if(repository.validateLicensePlateCar(dto.getLicensePlateCar()).getId() != id) 
			throw new DataIntegrityViolationException("Essa placa pertence a outro cadastro");
		
		if(repository.validateParkingSpotNumber(dto.getParkingSpotNumber()).getId() != id)
			throw new DataIntegrityViolationException("Número de vaga de garagem pertence a outro cadastro");        

	    if(repository.validateByApartmentAndBlock(dto.getApartment(), dto.getBlock()) == null) 
	    	return repository.save(mapper.map(dto, objExists.getClass()));		    
	    
	    if(repository.validateByApartmentAndBlock(dto.getApartment(), dto.getBlock()).getId() != id)
			throw new DataIntegrityViolationException("Esse apartamento e block pertence a outro cadastro");
	    
		return repository.save(mapper.map(dto, objExists.getClass()));	    
	}
 
	@Override
	@Transactional
	public void delete(Integer id) { 
		repository.delete(findById(id));
	}
}
