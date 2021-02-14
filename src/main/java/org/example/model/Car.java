package org.example.model;

import java.io.Serializable;
import java.util.UUID;

public class Car implements Serializable {
    private UUID carId;
    private String regNum;
    private String brand;
    private String model;
    private String owner;

    public Car() {
    }

    public Car(String regNum, String brand, String model, String owner) {
        this.carId = UUID.randomUUID();
        this.regNum = regNum;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", regNum='" + regNum + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
