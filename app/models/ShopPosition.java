package models;

import java.math.BigDecimal;

public class ShopPosition {
    long id;
    long markId;
    long modelId;
    int yearOfProduction;
    double mileage;
    BigDecimal price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMark() {
        return markId;
    }

    public void setMark(long markId) {
        this.markId = markId;
    }

    public long getModel() {
        return modelId;
    }

    public void setModel(long modelId) {
        this.modelId = modelId;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
