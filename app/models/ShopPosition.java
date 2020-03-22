package models;

public class ShopPosition {
    long id;
    AutoMark mark;
    AutoModel model;
    int yearOfProduction;
    double mileage;
    double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AutoMark getMark() {
        return mark;
    }

    public void setMark(AutoMark mark) {
        this.mark = mark;
    }

    public AutoModel getModel() {
        return model;
    }

    public void setModel(AutoModel model) {
        this.model = model;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
