/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOANG
 */
public class Cart {
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
    
    private Item getItemById(int id){
        for (Item i : items) {
            if(i.getProduct().getP_id() == id){
                return i;
            }
        }
        return null;
    }
    public int getSize(){
        return items.size();
    }
    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }
    // them vao cart
    public void addItem(Item t){
        // da co trong cart
        if(getItemById(t.getProduct().getP_id()) != null){
            Item i = getItemById(t.getProduct().getP_id());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        }
        else{
            // chua co
            items.add(t);
        }
    }
    // xoa khoir cart
    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }
    public double getTotalMoney(){
        double tong =0;
        for (Item i : items) {
            tong += i.getTotalMoney();
        }
        return tong;
    }
    public String getTotalMoneyFomat(){
        return String.format("%.3f", this.getTotalMoney())+ "VNĐ";
    }
    public String getThue(){
        return String.format("%.3f", this.getTotalMoney()*4/100)+ "VNĐ";
    }
    public String getTong(){
        return String.format("%.3f", this.getTotalMoney()*104/100)+ "VNĐ";
    }
}
