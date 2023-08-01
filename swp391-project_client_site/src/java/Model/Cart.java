/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
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

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    
    private Item getItemById(String id){
        for(Item i:items){
            if( i.getCourse().getCourse_id().equals(id)){
                return i;
            }
        }
        return null;
    }
    //them vao gio hang
    public void addItem(Item t){
        //co o cart roi
        if(getItemById(t.getCourse().getCourse_id())==null)           
        {
            //chua co
            items.add(t);
        }
    }
    
    public void removeItem(String id){
        if(getItemById(id)!= null){
           items.remove(getItemById(id));
        }
    }
    public double getTotalMoney(){
        double t=0;
        for(Item i: items){
            t+=i.getPrice();
            
        }
        return t;
    } 
    
    
}
