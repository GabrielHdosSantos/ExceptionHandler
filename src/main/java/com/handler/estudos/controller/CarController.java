package com.handler.estudos.controller;

import com.handler.estudos.model.Car;
import com.handler.estudos.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping
    public ResponseEntity createCar(@RequestBody Car car){
        carService.createCar(car);
            return ResponseEntity.status(HttpStatus.CREATED).body("car created");
    }

    @GetMapping
    public ResponseEntity<Page<Car>> findAllCars(@Param("page") int page){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAllCar(page));

    }


}
