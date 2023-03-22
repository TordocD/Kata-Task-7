package hiber.service;

import hiber.dao.CarDaoImp;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDaoImp carDaoImp;

    @Transactional
    @Override
    public void add(Car car) {
        carDaoImp.add(car);
    }
}
