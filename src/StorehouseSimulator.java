import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorehouseSimulator {
    public static void main(String[] args) {
            //TESTY
            //ADD NEW CONTAINER:
            FulfillmentCenterContainer storageMain = new FulfillmentCenterContainer();
            //ADD NEW STORAGES:
            FulfillmentCenter storage2 = new FulfillmentCenter("storage2",300);
            FulfillmentCenter storage = new FulfillmentCenter("storage1",100);
            //ADD ITEMS TO STORAGE:
            Item product1 = new Item("jajka",ItemCondition.NEW,1,50);
            storage.addProduct(product1);
            Item product2 = new Item("ananasy",ItemCondition.NEW,10,7);
            storage.addProduct(product2);
            Item product3 = new Item("jabłka",ItemCondition.NEW,2,10);
            storage.addProduct(product3);
            //ADD STORAGES TO CONTAINER:
            storageMain.addCenter(storage);
            storageMain.addCenter(storage2);
            //GET PRODUCT FROM STORAGE:
            //storage.getProduct(product2);
            //storage.getProduct(product1);
            //REMOVE PRODUCT FROM STORAGE
            //storage.removeProduct(product1);
            //SUMMARY STORAGE:
            //storage.summary();
            //PARTIAL SEARCH:

            List<Item> listTest = new ArrayList<>();
            listTest = storage.searchPartial("a");
            System.out.println("Zwracanie searchPartial: ");
            for(int i=0;i<listTest.size();i++){
                listTest.get(i).print();
            }
            //System.out.println(productTest.name);
            //PRINT AMOUNT OF PRODUCT COUNT BY CONDITION:
            System.out.println(storage.countByCondition(ItemCondition.NEW));
            //SORT BY AMOUNT:
            storage.sortByAmount();
            storage.summary();
            System.out.println(System.getProperty("line.separator"));
            //SORT BY NAME:
            storage.sortByName();
            storage.summary();
            Item productTest = storage.max();
            System.out.println("Efekt funkcji storage.max(): ");
            productTest.print();
            //storage.summary();
            storageMain.summary();
            storageMain.removeCenter("storage2");
            storageMain.removeCenter("storage2");
            System.out.println(storageMain.storageMap.size());
            //storageMain.removeCenter("storage1");
            System.out.println(storageMain.storageMap.size());
            System.out.println("Ilość pustych magazynów: " + storageMain.findEmpty().size());
    }
}
