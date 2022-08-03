package br.com.api.parkingcontrol.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.api.parkingcontrol.dto.ParkingSpotDto;
import br.com.api.parkingcontrol.model.ParkingSpotModel;

public interface ParkingSpotContract {
	
	public ParkingSpotModel findById(Integer id);	
	public Page<ParkingSpotModel> findAll(Pageable pageable);
	public Object create(ParkingSpotDto dto);
	public ParkingSpotModel uptade(Integer id, ParkingSpotDto dto);
	public void delete(Integer id);
}
 