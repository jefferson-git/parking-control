package br.com.api.parkingcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.parkingcontrol.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Integer>{
	
}
