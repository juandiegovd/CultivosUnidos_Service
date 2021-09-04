package org.sistema.arroz.riceservice.hexagonal.errors;

public class ErrorMessages {
    //For Supplies
    public static final String SUP_01_MESSAGE = "Supply with the id: %d not found";
    public static final String SUP_02_MESSAGE = "Actual stock: %d is lower than the minimum stock: %d. Validate your data please!";

    //For Communities
    public static final String AGC_01_MESSAGE = "Agriculture community with %d id is not registered!";

    //For Products
    public static final String PROD_01_MESSAGE = "Product with the id: %d not found";

}