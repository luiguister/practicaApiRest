package com.tercero.usarapi.api.header;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;

@Component
public class Headers {
    public HttpHeaders Consult(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "*/*");
        headers.add("Connection", "keep-alive");
        headers.add("User-Agent", "*/*");

        return headers;
    }
    public HttpHeaders ConsultPost(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "*/*");
        headers.add("Connection", "keep-alive");
        headers.add("User-Agent", "*/*");

        return headers;
    }

}
