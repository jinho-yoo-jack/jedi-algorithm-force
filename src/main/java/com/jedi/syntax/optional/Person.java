package com.jedi.syntax.optional;

import java.util.Optional;

public class Person {
    private final Optional<Car> car;

    public Person(Optional<Car> car) {
        this.car = car;
    }

    public Optional<Car> getCar() {
        return car;
    }
    public String getInsuranceName() {
        return this.car.map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
