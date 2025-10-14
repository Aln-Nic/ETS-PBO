import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        // Inisialisasi produk
        vm.addItem(new Item("A1", "Chitato", 8000, 5));
        vm.addItem(new Item("A2", "Tango", 6000, 3));
        vm.addItem(new Item("B1", "Aqua", 5000, 6));
        vm.addItem(new Item("B2", "Coca-Cola", 10000, 2));

        Scanner sc = new Scanner(System.in);
        boolean run = true;

        System.out.println("=== Vending Snack Machine ===");

        while (run) {
            System.out.println("\n1. Lihat Produk");
            System.out.println("2. Masukkan Uang");
            System.out.println("3. Pilih Produk");
            System.out.println("4. Refill (Admin)");
            System.out.println("5. Lihat Log Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    vm.showItems();
                    break;
                case "2":
                    System.out.print("Masukkan nominal uang: Rp ");
                    int money = Integer.parseInt(sc.nextLine());
                    vm.insertMoney(money);
                    break;
                case "3":
                    System.out.print("Masukkan kode produk: ");
                    String code = sc.nextLine();
                    vm.selectItem(code);
                    break;
                case "4":
                    System.out.print("Masukkan kode produk: ");
                    String rCode = sc.nextLine();
                    System.out.print("Masukkan jumlah refill: ");
                    int qty = Integer.parseInt(sc.nextLine());
                    vm.refillItem(rCode, qty);
                    break;
                case "5":
                    vm.showLog();
                    break;
                case "6":
                    run = false;
                    System.out.println("Terima kasih telah menggunakan Vending Snack Machine!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        sc.close();
    }
}
