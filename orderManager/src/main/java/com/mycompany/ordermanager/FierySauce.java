/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordermanager;

/**
 *
 * @author svetl
 */
public class FierySauce extends Topping{
    
    private String name;
    private int price;
    
    public FierySauce(Dish dish) {
        super(dish);
        name = "Огненный соус";
        price = 10;
    }
    
    @Override
    public String getName() {
        return super.getName() + " +" + name;
    }
   
    @Override
    public int getPrice() {
        return super.getPrice() + price;
    }
}
