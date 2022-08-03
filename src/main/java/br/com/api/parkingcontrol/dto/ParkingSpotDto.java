package br.com.api.parkingcontrol.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpotDto {
	
	private Integer id;
	@NotBlank(message = "O Número da vaga de estacionamento é requerido.")
    private String parkingSpotNumber;
	@NotBlank(message = "A placa do carro é requerido.")
    private String licensePlateCar;
	@NotBlank(message = "A marca do carro é requerido.")
    private String brandCar;
    @NotBlank(message = "O modelo do carro é requerido.")
    private String modelCar;
    @NotBlank(message = "A cor do carro é requerido.")
    private String colorCar;
    private LocalDateTime registrationDate;
    @NotBlank(message = "Nome do responsável é requerido.")
    private String responsibleName;
    @NotBlank(message = "Necessário informar um apartamento.")
    private String apartment;
    @NotBlank(message = "Necessário informar o bloco ou terre.")
    private String block;
} 
