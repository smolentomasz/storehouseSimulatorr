public class Item implements Comparable<Item>{
    String name;
    ItemCondition condition;
    double mass;
    Integer quantity;

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Item(String nazwa, ItemCondition stan, double masa, Integer ilosc) {
        this.name = nazwa;
        this.condition = stan;
        this.mass = masa * ilosc;
        this.quantity = ilosc;
    }
    public void print(){
        System.out.println("Nazwa: " + name + ", masa: " + mass + ", stan: " + condition + ", ilość: " + quantity);
    }

    @Override
    public int compareTo(Item o) {
        return name.compareTo(o.name);
    }
}
