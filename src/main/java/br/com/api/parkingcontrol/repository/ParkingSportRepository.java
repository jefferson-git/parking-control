package br.com.api.parkingcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.parkingcontrol.model.ParkingSpotModel;

public interface ParkingSportRepository extends JpaRepository<ParkingSpotModel, Integer>{

	boolean existsByLicensePlateCar(String licensePlateCar);

	boolean existsByParkingSpotNumber(String parkingSpotNumber);

	boolean existsByApartmentAndBlock(String apartment, String block);
	
	@Query("SELECT obj FROM ParkingSpotModel obj WHERE obj.licensePlateCar=:licensePlateCar")
	ParkingSpotModel validateLicensePlateCar(String licensePlateCar);
	
	@Query("SELECT obj FROM ParkingSpotModel obj WHERE obj.parkingSpotNumber=:parkingSpotNumber")
	ParkingSpotModel validateParkingSpotNumber(String parkingSpotNumber);
	
	@Query("SELECT obj FROM ParkingSpotModel obj WHERE obj.apartment=:apartment and obj.block=:block")
	ParkingSpotModel validateByApartmentAndBlock(String apartment, String block);

}
