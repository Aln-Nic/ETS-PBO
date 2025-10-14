public class Item {
    private String code;
    private String name;
    private int price;
    private int stock;

    public Item(String code, String name, int price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock() {
        if (stock > 0) stock--;
    }

    public void restock(int qty) {
        stock += qty;
    }

    @Override
    public String toString() {
        return code + " | " + name + " | Rp " + price + " | Stok: " + stock;
    }
}
