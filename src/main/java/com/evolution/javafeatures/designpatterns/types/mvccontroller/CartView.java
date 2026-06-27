package com.evolution.javafeatures.designpatterns.types.mvccontroller;

public class CartView {
    
    public String displayCart(CartModel cartModel){
        return "The cart info: "+cartModel.toString();
    }
}
