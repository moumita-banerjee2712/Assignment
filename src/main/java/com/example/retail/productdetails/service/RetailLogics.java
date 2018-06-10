package com.example.retail.productdetails.service;


import com.example.retail.productdetails.DocumetVO.DocumentVo;
import com.example.retail.productdetails.document.Product;
import com.example.retail.productdetails.repository.ProductRepository;
import com.oracle.javafx.jmx.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.NotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class RetailLogics {

    @Value("${URI}")
    private String Uri;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DocumentVo  documentVo;

    public DocumentVo getDetail(Long id) throws ParseException{

        Product p= productRepository.findById(id).orElseThrow(() -> new NotFoundException());
        System.out.println(p);
        String Name = covertJSON(id);
        documentVo.setProductId(p.getId());
        System.out.println("Name "+Name);
        documentVo.setProductName(Name);
        documentVo.setProductPrice(p.getPrice());

        return documentVo;
    }

    public  String covertJSON(Long id) throws org.json.simple.parser.ParseException {

        System.out.println("Uri from app......");
        RestTemplate restTemplate = new RestTemplate();
        String URI=  Uri+ id.toString();
        System.out.println("Uri from app "+Uri);
        System.out.println("Id val "+id.toString());
        System.out.println("value "+URI);
        String output = restTemplate.getForObject(URI, String.class);
        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        JSONObject jsonObject= (JSONObject) jsonParser.parse(output);
        String val = recurseKeys(jsonObject,"title");
        //System.out.println("value "+val);
        return val;
    }

    public static String recurseKeys(JSONObject jObj, String findKey) throws JSONException {
        String finalValue = "";
        if (jObj == null) {
            return "";
        }
        Iterator<String> keyItr =  jObj.keySet().iterator();
        Map<String, String> map = new HashMap<>();
        while (keyItr.hasNext()) {
            String key = keyItr.next();
            map.put(key, jObj.get(key).toString());
        }
        for (Map.Entry<String, String> e : (map).entrySet()) {
            String key = e.getKey();
            if (key.equalsIgnoreCase(findKey)) {
                return jObj.get(key).toString();
            }
            // read value
            Object value = jObj.get(key);
            if (value instanceof JSONObject) {
                finalValue = recurseKeys((JSONObject) value, findKey);
                if (finalValue!=null && finalValue!="")
                    return finalValue;

            }
        }
        // key is not found
        return finalValue;
    }
}
