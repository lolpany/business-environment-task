package controllers;

import java.math.BigDecimal;

public class ShopPositionSearchCriteria {
    String markName;
    String modelName;
    Integer yearOfProductionFrom;
    Integer yearOfProductionTo;
    Double mileageFrom;
    Double mileageTo;
    BigDecimal priceFrom;
    BigDecimal priceTo;
    Paging paging;
}
