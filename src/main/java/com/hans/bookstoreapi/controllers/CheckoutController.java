package com.hans.bookstoreapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @PostMapping("/paypal/create")
    public void createPaypalOrder(){}

    @PostMapping("/paypal/capture")
    public void capturePaypalOrder(){}
}
