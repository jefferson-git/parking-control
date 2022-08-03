package br.com.api.parkingcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.parkingcontrol.model.PermissionModel;

public interface PermissionRepository extends JpaRepository<PermissionModel, Integer>{

}
