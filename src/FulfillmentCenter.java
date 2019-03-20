import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FulfillmentCenter {
    String storageName;
    ArrayList<Item> productsList = new ArrayList<Item>();
    double maxStorageCapacity;


    public FulfillmentCenter(String storageName, double maxStorageCapacity) {
        this.storageName = storageName;
        this.maxStorageCapacity = maxStorageCapacity;
    }

    public void addProduct(Item product){
        if(maxStorageCapacity>product.mass) {
            if((maxStorageCapacity - currentWeight()) > product.mass){
            for (int i = 0; i < productsList.size(); i++) {
                if (productsList.get(i).compareTo(product) == 0) {
                    productsList.get(i).quantity += product.quantity;
                    productsList.get(i).mass += product.mass;
                    System.out.println("Existing product added to storage!");
                    break;
                }
            }//dodawanie produktu gdy produkt istnieje
            productsList.add(product);
            System.out.println("New product added to storage!");
        }
            else{
                System.err.print("Error, storage capacity is smaller than product mass!\n");
            }
        }
        else{
            System.err.print("Error, storage capacity is smaller than product mass!");
        }
    }
    public void getProduct(Item product){
        for(int i=0;i<productsList.size();i++) {
            if(productsList.get(i).compareTo(product) == 0){
                if(productsList.get(i).quantity > 0){
                    productsList.get(i).quantity -= product.quantity;
                    productsList.get(i).mass -= product.mass;
                    if(productsList.get(i).quantity == 0){
                        removeProduct(product);
                    }
                }
            }
        }
    }
    public void removeProduct(Item product){
        for(int i=0;i<productsList.size();i++) {
            if(productsList.get(i).compareTo(product) == 0){
                productsList.remove(productsList.get(i));
            }
        }
    }
    public Item search(String name){
        for(int i=0;i<productsList.size();i++) {
            if(productsList.get(i).name.equals(name)){
                return productsList.get(i);
            }
        }
        return null;
    }
    public List<Item> searchPartial(String name){
        List<Item> list = new ArrayList<>();
        for(int i=0;i<productsList.size();i++) {
            if(productsList.get(i).name.contains(name)){
                list.add(productsList.get(i));
            }
        }
        return list;
    }
    public int countByCondition(ItemCondition productCondition){
        int conditionSum = 0;
        for(int i=0;i<productsList.size();i++){
            if(productsList.get(i).condition == productCondition){
                conditionSum++;
            }
        }
        return conditionSum;
    }
    public void summary(){
        for(int i = 0; i < productsList.size(); i++){
            productsList.get(i).print();
        }
    }
    public void sortByName(){
        Collections.sort(productsList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    public void sortByAmount(){//sortowanie malejąco
        Collections.sort(productsList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o2.getQuantity(), o1.getQuantity());
            }
        });
    }
    public Item max(){
       return Collections.max(productsList, new Comparator<Item>() {
           @Override
           public int compare(Item o1, Item o2) {
               return Integer.compare(o1.getQuantity(), o2.getQuantity());
           }
       });
    }
    public boolean isEmpty(){
        return productsList.isEmpty();
    }
    public double currentWeight(){
        double currentWeight = 0;
        for(int i=0;i<productsList.size();i++){
            currentWeight+=productsList.get(i).mass;
        }
        return currentWeight;
    }
}
