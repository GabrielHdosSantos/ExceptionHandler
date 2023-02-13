package com.handler.estudos.service;

import com.handler.estudos.model.Car;
import com.handler.estudos.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void createCar(Car car){
        carRepository.save(car);
    }

    public Page<Car> findAllCar(int page){

        PageRequest pageRequest = PageRequest.of(page, 10);

        return carRepository.findAll(pageRequest);
    }


}
