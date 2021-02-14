package org.example;

import java.io.Serializable;

public class CarEx implements Serializable {
    private String regNum;
    private String brand;
    private String model;
    private int power;

    public CarEx() {
    }

    public CarEx(String regNum, String brand, String model, int power) {
        this.regNum = regNum;
        this.brand = brand;
        this.model = model;
        this.power = power;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNum='" + regNum + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                '}';
    }
}
