package week_5.problem_1.Part_c;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashSet<Car> cars = new HashSet<>();

        Car car1 = new Car("Changan", 2020, "Camry");
        Car car2 = new Car("Toyota", 2020, "Camry");
        Car car3 = new Car("BMW", 2022, "X5");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        System.out.println("Size of set: " + cars.size());
        System.out.println(cars);
    }
}