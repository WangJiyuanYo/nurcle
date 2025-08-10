package icu.iseenu.chainOfResponsibility;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private boolean isInfoComplete = true;

    private Integer stock = 10;

    private Integer quantity = 9;

    private Integer amount = 100;

    private Integer balance = 900;

    public void confirm(){

    }
}
