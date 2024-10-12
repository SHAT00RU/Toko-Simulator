import java.util.HashMap;
import java.util.Map;

public class Inventory implements Storable {
    private Map<String, Integer> itemMap;
    private int totalItem;

    // Constructor
    public Inventory() {
        itemMap = new HashMap<>();
        totalItem = 0;
    }

    @Override
    public void tambahItem(String item, int jumlah) {
        if (itemMap.containsKey(item)) {
            itemMap.put(item, itemMap.get(item) + jumlah);
        } else {
            itemMap.put(item, jumlah);
        }
        totalItem += jumlah;
        System.out.println(jumlah + " unit " + item + " telah ditambahkan.");
    }

    @Override
    public void hapusItem(String item) {
        if (itemMap.containsKey(item)) {
            int jumlahItem = itemMap.remove(item);
            totalItem -= jumlahItem;
            System.out.println(item + " telah dihapus dari inventaris.");
        } else {
            System.out.println(item + " tidak ditemukan di inventaris.");
        }
    }

    @Override
    public void tampilkanItem() {
        if (itemMap.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            System.out.println("Daftar Item di Inventaris Toko:");
            for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " unit");
            }
            System.out.println("Total item: " + totalItem);
        }
    }
}
