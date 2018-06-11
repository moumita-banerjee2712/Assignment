package com.example.retail.productdetails.DocumetVO;

import org.springframework.stereotype.Component;


@Component
public class Price {

    Float value;
    String currency_cd;


    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getCurrency_cd() {
        return currency_cd;
    }

    public void setCurrency_cd(String currency_cd) {
        this.currency_cd = currency_cd;
    }


}
