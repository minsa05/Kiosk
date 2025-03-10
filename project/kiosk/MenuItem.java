package project.kiosk;

public class MenuItem {
    private String name;
    private double price;
    private String ex;

   public MenuItem(String name, double price, String ex) {
        this.name = name;
        this.price = price;
        this.ex = ex;
    }

    public String getname() {
       return name;
    }

    public double getprice() {
        return price;
    }

    public String getex() {
        return ex;
    }


}
