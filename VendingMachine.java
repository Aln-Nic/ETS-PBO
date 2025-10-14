import java.util.*;

public class VendingMachine {
    private List<Item> items;
    private int balance;
    private List<String> transactionLog;

    public VendingMachine() {
        items = new ArrayList<>();
        transactionLog = new ArrayList<>();
        balance = 0;
    }

    public void addItem(Item item) {
        items.add(item);    
    }
    
    public void insertMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Nominal tidak valid!");
            return;
        }
        balance += amount;
        System.out.println("Saldo saat ini: Rp " + balance);
    }

    public void showItems() {
        System.out.println("\n=== Daftar Produk ===");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("======================");
    }

    public void selectItem(String code) {
        for (Item item : items) {
            if (item.getCode().equalsIgnoreCase(code)) {
                if (item.getStock() <= 0) {
                    System.out.println("Stok habis untuk " + item.getName() + ". Harap refill.");
                    return;
                }

                if (balance < item.getPrice()) {
                    System.out.println("Saldo tidak cukup! Harga: Rp " + item.getPrice());
                    return;
                }

                // Transaksi berhasil
                item.reduceStock();
                balance -= item.getPrice();
                transactionLog.add("Beli: " + item.getName() + " (Rp " + item.getPrice() + ")");
                System.out.println("Anda membeli: " + item.getName());
                System.out.println("Kembalian: Rp " + balance);
                balance = 0; // reset saldo setelah transaksi
                return;
            }
        }
        System.out.println("Kode produk tidak ditemukan!");
    }

    public void refillItem(String code, int qty) {
        for (Item item : items) {
            if (item.getCode().equalsIgnoreCase(code)) {
                item.restock(qty);
                System.out.println("Berhasil refill " + item.getName() + " sebanyak " + qty);
                return;
            }
        }
        System.out.println("Produk tidak ditemukan!");
    }

    public void showLog() {
        System.out.println("\n=== Log Transaksi ===");
        if (transactionLog.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String log : transactionLog) {
                System.out.println(log);
            }
        }
        System.out.println("=====================");
    }
}
