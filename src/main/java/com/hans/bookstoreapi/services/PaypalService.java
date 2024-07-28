package com.hans.bookstoreapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PaypalService {

    //Serve per prendere una propietà dall'application.properties
    @Value("${paypal.client-id}")
    private String clientId;
    @Value("${paypal.client-secret")
    private String clientSecret;
    @Value("${paypal.api-base}")
    private String apiBase;

    private final RestClient paypalClient = RestClient
            .builder()
            .baseUrl(apiBase)
            .build();

    private String getAccessToken(){
        return null;
    }

    public void createOrder(){}

    public void captureOrder(){}
}
