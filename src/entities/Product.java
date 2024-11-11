package entities;

public class Product {
    private String name;
    private Double price;

    public Product(Double price, String name) {
        this.price = price;
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s   preço R$%.2f",name, price);
    }

}

