package builder.youtube;

public class BuilderApp {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new FordMondeoBuilder());
        Car build = director.build();
        System.out.println(build);

//        Car audi = new CarBuilder()
//                .builMake("Audi")
//                .builMaxSpeed(100)
//                .builTransmission(Transmission.AUTO)
//                .build();
//        System.out.println(audi);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarBuilder {
    Car car = new Car();

    abstract void buildMale();

    abstract void buildTransmission();

    abstract void buildmaxSpeed();

    Car getCar() {
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder {
    @Override
    void buildMale() {
        car.setMake("Ford Monde");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildmaxSpeed() {
        car.setMaxSpeed(160);
    }
}

class Director{
    CarBuilder builder;

    public CarBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    Car build(){
        builder.buildMale();
        builder.buildTransmission();
        builder.buildmaxSpeed();
        return builder.getCar();
    }
}

//
//class CarBuilder {
//    private String make;
//    private Transmission transmission;
//    private int maxSpeed;
//
//    CarBuilder builMake(String make) {
//        this.make = make;
//        return this;
//    }
//
//    CarBuilder builTransmission(Transmission transmission) {
//        this.transmission = transmission;
//        return this;
//    }
//
//    CarBuilder builMaxSpeed(int maxSpeed) {
//        this.maxSpeed = maxSpeed;
//        return this;
//    }
//
//    Car build() {
//        Car car = new Car();
//        car.setMake(make);
//        car.setTransmission(transmission);
//        car.setMaxSpeed(maxSpeed);
//        return car;
//    }
//}