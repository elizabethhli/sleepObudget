package com.example.shehacksapp;

//either the food, drink, entertainment or venue item
public class Item {
    private String name;
    private String type;
    private double price;

    public Item (String n, double p, String t){
        name = n;
        type = t;
        price = p;
    }


    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }

    public void setName(String n){name = n;}

    public void setType(String t){ type = t; }

    public void setPrice(double p){
         price = p;
    }
}

