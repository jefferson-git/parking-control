package br.com.api.parkingcontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.parkingcontrol.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	 Optional<UserModel> findByUsername(String username);
}
