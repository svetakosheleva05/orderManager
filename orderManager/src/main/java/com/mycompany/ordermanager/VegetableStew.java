/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordermanager;

/**
 *
 * @author svetl
 */
public class VegetableStew implements Dish{
    private String name;
    private int price;
    
    public VegetableStew() {
        name = "Овощное рагу";
        price = 50;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
}
