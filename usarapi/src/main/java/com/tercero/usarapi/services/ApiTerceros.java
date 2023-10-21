package com.tercero.usarapi.services;

import com.tercero.usarapi.api.ProductApi;
import com.tercero.usarapi.api.header.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiTerceros {

    public static Logger logger = LoggerFactory.getLogger(ApiTerceros.class);

    @Autowired
    private Headers headers;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0/16 * * * * *")
    public List<ProductApi> getListar(){
        System.out.println("*** iniciando job-consulta ***");
        String url = "http://localhost:8080/products/all";
        HttpEntity<String> entity = new HttpEntity<>(headers.Consult());
        ResponseEntity<List<ProductApi>> response = restTemplate.exchange(url, HttpMethod.GET,
                entity, new ParameterizedTypeReference<List<ProductApi>>() {});
        System.out.println(response.getBody());
        System.out.println("*** finalizando job-consulta ***");
        return response.getBody();
    }

    @Scheduled(cron = "0/16 * * * * *")
    public void insertar(){
        System.out.println("///inicianto job insertar///");
        String urlPost = "http://localhost:8080/products/save";
        Map<String, String> requestApi = new HashMap<>();
        requestApi.put("name","nuevoProducto");
        requestApi.put("categoryId","1");
        requestApi.put("price","58000");
        requestApi.put("stock","5");
        requestApi.put("active","false");

        HttpEntity entity = new HttpEntity<>(requestApi, headers.Consult());

        ResponseEntity<ProductApi> response = restTemplate.exchange(urlPost, HttpMethod.POST, entity, ProductApi.class);

        logger.info("response con body"+response.getBody());
        System.out.println(response.getBody());
        System.out.println("///finalizando job insertar///");
    }
}
