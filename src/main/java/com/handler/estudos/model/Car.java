package com.handler.estudos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_carro")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "License plate cannot be null")
    @NotBlank(message = "License plate cannot be blank")
    @Size(max = 7, message = "License plate cannot be greater than 7")
    private String LicensePlate;

    @Positive(message = "Year must be positive")
    @NotNull(message = "Year cannot be null")
    private int CarYear;




}
