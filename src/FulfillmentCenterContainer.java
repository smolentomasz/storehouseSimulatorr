import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> storageMap = new HashMap<String, FulfillmentCenter>();
    public void addCenter(String storageName, double storageCapacity){
        FulfillmentCenter newStorage = new FulfillmentCenter(storageName, storageCapacity);
        storageMap.put(storageName, newStorage);
    }
    public void addCenter(FulfillmentCenter center){
        storageMap.put(center.storageName, center);
    }
    public void removeCenter(String storageName){
        if(storageMap.containsKey(storageName)){
            storageMap.remove(storageName);
            System.out.println("Usunięto magazyn!");
        }
        else{
            System.out.println("Magazyn o podanej nazwie nie istnieje!");
        }
    }
    public List<FulfillmentCenter> findEmpty(){
        List<FulfillmentCenter> centerList = new ArrayList<>();
        for (FulfillmentCenter center : storageMap.values()) {
            if(center.isEmpty()){
                centerList.add(center);
                System.out.println("Dodano pusty magazyn do listy!");
            }
        }
        return  centerList;

    }
    public void summary(){
        Set<Map.Entry<String, FulfillmentCenter>> entrySet = storageMap.entrySet();
        for(Map.Entry<String,FulfillmentCenter> entry:entrySet){//przeszukiwanie po mapie
            double currentMass = 0;
            for(int i=0;i<entry.getValue().productsList.size();i++){
                currentMass += entry.getValue().productsList.get(i).mass; //masa produktów w magazynie
            }
            double percentageUsage = currentMass/entry.getValue().maxStorageCapacity * 100;//procentowe zapełnienie
            System.out.println("Nazwa magazynu: " + entry.getValue().storageName + ", procentowe zapełnienie: " + percentageUsage + "%");
        }
    }
}
