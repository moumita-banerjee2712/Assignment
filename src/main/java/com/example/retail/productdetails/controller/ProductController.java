package com.example.retail.productdetails.controller;


import com.example.retail.productdetails.DocumetVO.DocumentVo;
import com.example.retail.productdetails.document.Product;
import com.example.retail.productdetails.repository.ProductRepository;
import com.example.retail.productdetails.service.RetailLogics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/product")
public class ProductController {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    RetailLogics retailLogics;
    @Autowired
    DocumentVo  documentVo;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Product product){
        productRepository.save(product);
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DocumentVo read(@PathVariable Long id) throws org.json.simple.parser.ParseException {
       return retailLogics.getDetail(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody() Product product, @PathVariable Long id){
        productRepository.save(product);
    }

}
