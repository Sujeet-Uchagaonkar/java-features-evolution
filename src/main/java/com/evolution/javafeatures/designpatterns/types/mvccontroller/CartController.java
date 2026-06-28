package com.evolution.javafeatures.designpatterns.types.mvccontroller;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CartController {

    private CartModel cartModel;
    private CartView cartView;


    public int getCartId(){
        return cartModel.cartOrderId;
    }

    public void setCartId(int cartOrderId){
        this.cartModel.setCartOrderId(cartOrderId);
    }

    public float getTotalPrice(){
        return cartModel.totalPrice;
    }

    public void setCartTotal(float cartTotal){
        this.cartModel.setTotalPrice(cartTotal);
    }

    public void updateCartView(){
        this.cartView.displayCart(this.cartModel);
    }

}
