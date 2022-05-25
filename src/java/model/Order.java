package model;


public class Order {
    private int id;
    private String date;
    private int c_id;
    private double totalmoney;

    public Order() {
    }

    public Order(int id, String date, int c_id, double totalmoney) {
        this.id = id;
        this.date = date;
        this.c_id = c_id;
        this.totalmoney = totalmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    
    
}
