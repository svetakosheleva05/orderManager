/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordermanager;

/**
 *
 * @author svetl
 */
public abstract class Topping implements Dish {
    private Dish dish;
    
    public Topping(Dish dish) {
        this.dish = dish;
    }
    
    @Override
    public String getName() {
        return dish.getName();
    }
    
    @Override
    public int getPrice() {
        return dish.getPrice();
    }
}
