package org.example;

import java.io.BufferedReader;
import org.example.Dish;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.io.FileReader;
import org.example.Restro;
class Parse{

    Dish[] dishes = new Dish[10];
    Restro [] restaurants = new Restro[10];
    void parse_dishes(){
        try {
            FileReader fr = new FileReader("\"C:\\Users\\Sushant\\IdeaProjects\\SwiggySharda\\Data\\Dish.csv\"");
            BufferedReader br = new BufferedReader(fr);
            String newline;
            String[] arr;
            int i = 0;
            while ((newline = br.readLine()) != null) {
                arr = newline.split(",");
                Dish d = new Dish(arr[0],arr[1],arr[2],arr[3]);
                dishes[i] = d;
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void parse_restaurant(){
        try{
            FileReader f = new FileReader("\"C:\\Users\\Sushant\\IdeaProjects\\SwiggySharda\\Data\\Kitchen.csv\"");
            BufferedReader br = new BufferedReader(f);
            String newline;
            String[] arr;
            int i = 0;
            while ((newline = br.readLine()) != null) {
                arr = newline.split(",");
                Restro d = new Restro(arr[0],arr[1],arr[2]);
                restaurants[i] = d;
                i++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Sharda Swiggy");
        Parse p = new Parse();
        p.parse_dishes();
        p.parse_restaurant();
        System.out.println("Restraunt" + "\t" + "Type");
        for (Restro j : p.restaurants) {
            if(j!=null){
                System.out.println(j.restro_name + "\t" + j.type);
                System.out.println("Dish Name" + "\t" + "Type of Dish" + "\t" + "Price");
                for (Dish i : p.dishes) {
                    if (i != null) {
                        if (j.id.equals(i.id)) {
                            System.out.println(i.dish_name + "\t" + i.type + "\t" + i.price+"\t");
                        }
                    }
                }
                System.out.println("_________________________________________________________");
            }
  }
}

}