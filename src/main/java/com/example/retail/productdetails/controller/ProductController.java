package com.example.retail.productdetails.controller;


import com.example.retail.productdetails.DocumetVO.DocumentVo;
import com.example.retail.productdetails.repository.ProductRepository;
import com.example.retail.productdetails.service.RetailLogics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    RetailLogics retailLogics;
    @Autowired
    DocumentVo  documentVo;



    @RequestMapping(value="/save" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody DocumentVo documentVo){

        retailLogics.save(documentVo);
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DocumentVo read(@PathVariable Long id) throws org.json.simple.parser.ParseException {
       return retailLogics.getDetail(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody() DocumentVo documentVo, @PathVariable Long id){

        retailLogics.save(documentVo);
    }

}
