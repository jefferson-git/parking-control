package br.com.api.parkingcontrol.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @AllArgsConstructor
@Data   @NoArgsConstructor
@Table(name = "TB_PERMISSION")
@SuppressWarnings("serial")
public class PermissionModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer permissionId;	
	private LocalDateTime datePermission;	
	private Integer userId;	
	private Integer roleId;

}
