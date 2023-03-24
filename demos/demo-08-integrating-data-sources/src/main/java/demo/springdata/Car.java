package demo.springdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Define an entity class named Car with these fields:
// • carId (primary key)
// • registrationNumber
// • make
// • model
// • Add some code in SeedDb to insert some cars
// • Run the application and view the H2 console UI, 
// to confirm the car data exists in the database

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId = -1;

    private String registrationNumber;
    private String make;
    private String model;

    public Car() {
        // Empty no-arg constructor.
    }

    public Car(long carId, String registrationNumber, String make, String model) {
        this.carId = carId;
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
