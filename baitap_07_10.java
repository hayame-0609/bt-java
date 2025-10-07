import java.util.*;

interface PaymentMethod {
    void pay(double amount, String customerName);
}

class CashPayment implements PaymentMethod {
    public void pay(double amount, String customerName) {
        System.out.println("Khach hang: " + customerName + ". Tong tien: " + amount + ". Thanh toan tien mat thanh cong.");
    }
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount, String customerName) {
        System.out.println("Khach hang: " + customerName + ". Tong tien: " + amount + ". Thanh toan bang the tin dung thanh cong.");
    }
}

class MomoPayment implements PaymentMethod {
    public void pay(double amount, String customerName) {
        System.out.println("Khach hang: " + customerName + ". Tong tien: " + amount + ". Thanh toan qua vi Momo thanh cong.");
    }
}

abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected String type;

    public Product(String id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo();
}

class ElectronicProduct extends Product {
    private String imei;
    private int warrantyPeriod;

    public ElectronicProduct(String id, String name, double price, String imei, int warrantyPeriod) {
        super(id, name, price, "Electronic");
        this.imei = imei;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String getInfo() {
        return name + " [IMEI: " + imei + ", BH: " + warrantyPeriod + " thang, Gia: " + price + "]";
    }
}

class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String id, String name, double price, String expiryDate) {
        super(id, name, price, "Food");
        this.expiryDate = expiryDate;
    }

    @Override
    public String getInfo() {
        return name + " [HSD: " + expiryDate + ", Gia: " + price + "]";
    }
}

class Order {
    private String customerName;
    private List<Product> products = new ArrayList<>();
    private PaymentMethod payment;

    public Order(String customerName, PaymentMethod payment) {
        this.customerName = customerName;
        this.payment = payment;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void checkout() {
        double total = calculateTotal();
        payment.pay(total, customerName);
    }
}

public class baitap_07_10 {
    public static void main(String[] args) {
        Product p1 = new ElectronicProduct("E01", "dien thoai Samsung", 5000000, "123ABC", 12);
        Product p2 = new FoodProduct("F01", "Banh quy Oreo", 25000, "10/12/2025");

        Order o1 = new Order("Nguyen Van A", new CashPayment());
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.checkout();

        Order o2 = new Order("Nguyen Van B", new CreditCardPayment());
        o2.addProduct(p1);
        o2.checkout();

        Order o3 = new Order("Tran Thi C", new MomoPayment());
        o3.addProduct(p2);
        o3.checkout();
    }
}
