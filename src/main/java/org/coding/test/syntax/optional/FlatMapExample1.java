package org.coding.test.syntax.optional;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlatMapExample1 {
    static Logger logger = Logger.getLogger(FlatMapExample1.class.getName());

    public static void main(String[] args) {
        Optional<Person> person = Optional.of(new Person(Optional.of(new Car(new Insurance("Black")))));
        String insuranceName = person.flatMap(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unKnown");

        logger.log(Level.INFO, "Insurance name is: {0}", insuranceName);
    }
}
