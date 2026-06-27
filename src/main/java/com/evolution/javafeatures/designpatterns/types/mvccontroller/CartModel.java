package com.evolution.javafeatures.designpatterns.types.mvccontroller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CartModel {
    int cartOrderId;
    float totalPrice;
}
