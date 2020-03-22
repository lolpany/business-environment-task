package models;

public class AutoModel {
    long id;
    String name;
    int productionStartYear;
    int productionEndYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductionStartYear() {
        return productionStartYear;
    }

    public void setProductionStartYear(int productionStartYear) {
        this.productionStartYear = productionStartYear;
    }

    public int getProductionEndYear() {
        return productionEndYear;
    }

    public void setProductionEndYear(int productionEndYear) {
        this.productionEndYear = productionEndYear;
    }
}
