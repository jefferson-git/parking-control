package br.com.api.parkingcontrol.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.api.parkingcontrol.enums.RoleName;
import br.com.api.parkingcontrol.model.ParkingSpotModel;
import br.com.api.parkingcontrol.model.PermissionModel;
import br.com.api.parkingcontrol.model.RoleModel;
import br.com.api.parkingcontrol.model.UserModel;
import br.com.api.parkingcontrol.repository.ParkingSportRepository;
import br.com.api.parkingcontrol.repository.PermissionRepository;
import br.com.api.parkingcontrol.repository.RoleRepository;
import br.com.api.parkingcontrol.repository.UserRepository;

@Configuration
@Profile("dev")
public class DevConfig {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	@Autowired ParkingSportRepository parkingSportRepository;	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PermissionRepository permissionRepository;
	
	@Bean
	void createDados() {	 
				
		if (ddl.equals("create")) {
			
		var p1 = new ParkingSpotModel(null, "3071", "TRL98U7", "Fiat", "Stylo", "Prata", LocalDateTime.now(), "jefferson", "6520", "Torre norte");
		var p2 = new ParkingSpotModel(null, "1083", "PLI87G0", "BMW", "acod", "Preto", LocalDateTime.now(), "Maria", "8765", "Torre sul");
		parkingSportRepository.saveAll(List.of(p1, p2));
		
		var role1 = new RoleModel(null, RoleName.ROLE_ADMIN);
		var role2 = new RoleModel(null, RoleName.ROLE_USER);
		roleRepository.saveAll(List.of(role1, role2));
		
		var user1 = new UserModel(null, "jefferson", "$2a$12$urWsVtbI2.tSNyVK3s.Fpe6xz/joXDs26B/mri849Max9/7S0HgsK");                                                                                                            
		var user2 = new UserModel(null, "Maria", "$2a$12$GxTDLJ3T.scG0du1.fr0IOtE7lSpRAguq8AZ9fyLhGyvDJwt6fPuO\r\n");                                                                                                            
		userRepository.saveAll(List.of(user1, user2));	
		
		var permission = new PermissionModel(null, LocalDateTime.now(), user1.getUserId(), role1.getRoleId());
		permissionRepository.save(permission);
		}		
	}	
}
