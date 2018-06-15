package com.example.retail.productdetails.productDetailTest;


import com.example.retail.productdetails.DocumetVO.DocumentVo;
import com.example.retail.productdetails.DocumetVO.Price;
import com.example.retail.productdetails.controller.ProductController;
import com.example.retail.productdetails.repository.ProductRepository;
import com.example.retail.productdetails.service.RetailLogics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ProductController.class)

public class ProductControllerTest {

    @MockBean
    private RetailLogics retailLogics;

    @MockBean
    private ProductRepository productRepository;



    @MockBean
    private DocumentVo documentVo;

    @Autowired
    private MockMvc  mockMvc;

    private static final Long id =null;

    @Test
    public void read() throws Exception{
        Long id = 13860428L;
        DocumentVo documentVo =new DocumentVo();
        documentVo.setProductId(13860428L);
        documentVo.setProductName("he Big Lebowski (Blu-ray)");
        Price price=new Price();
        price.setValue(500f);
        price.setCurrency_cd("USD");
        documentVo.setPrice(price);

        given(retailLogics.getDetail(id)).willReturn( documentVo);
        this.mockMvc.perform(get("/product/13860428")).andExpect(status().isOk());


    }

}
