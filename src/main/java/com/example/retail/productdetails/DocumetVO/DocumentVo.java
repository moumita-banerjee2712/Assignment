package com.example.retail.productdetails.DocumetVO;

import org.springframework.stereotype.Component;


@Component
public class DocumentVo  {



    Long productId;
    String productName;
    Float productPrice;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }




}
