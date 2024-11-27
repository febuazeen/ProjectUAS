/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas;

/**
 *
 * @author Alhamdulillah
 */
import java.util.Scanner;

class Hashmap2 {

    private LinkedList[] buckets;
    private int capacity;
    private int size;

    public Hashmap2() {
        capacity = 16;
        buckets = new LinkedList[capacity];
        size = 0;
    }

    public int hash(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public void put(String key, LinkedList value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = value;
            size++;
        } else {
            buckets[index] = value; // Replace existing LinkedList
        }
    }

    public LinkedList get(String key) {
        int index = hash(key);
        return buckets[index];
    }

    public void remove(String key) {
        int index = hash(key);
        buckets[index] = null;
        size--;
    }
}

public class DisasterManagementApp {

    public static void main(String[] args) {
        Hashmap2 disasterMap = new Hashmap2();
        Scanner sc = new Scanner(System.in);
        LinkedList flood = new LinkedList();
        flood.add(new Node("Deskripsi", "Kondisi saat air menggenangi wilayah tertentu."));
        flood.add(new Node("Penyebab", "Curah hujan tinggi, drainase buruk."));
        flood.add(new Node("Pencegahan", "Memperbaiki saluran air, reboisasi."));
        flood.add(new Node("Cara Mengatasi", "Evakuasi, membangun tanggul."));
        disasterMap.put("Banjir", flood);

        LinkedList forestFire = new LinkedList();
        forestFire.add(new Node("Deskripsi", "Kebakaran yang meluas di area hutan."));
        forestFire.add(new Node("Penyebab", "Cuaca kering, pembakaran liar."));
        forestFire.add(new Node("Pencegahan", "Pengawasan, patroli hutan."));
        forestFire.add(new Node("Cara Mengatasi", "Pemadaman api dengan alat khusus."));
        disasterMap.put("Kebakaran Hutan", forestFire);

        LinkedList earthquake = new LinkedList();
        earthquake.add(new Node("Deskripsi", "Getaran pada permukaan bumi akibat pergerakan lempeng."));
        earthquake.add(new Node("Penyebab", "Pergeseran lempeng tektonik."));
        earthquake.add(new Node("Pencegahan", "Bangunan tahan gempa."));
        earthquake.add(new Node("Cara Mengatasi", "Evakuasi ke tempat aman."));
        disasterMap.put("Gempa Bumi", earthquake);

        LinkedList tsunami = new LinkedList();
        tsunami.add(new Node("Deskripsi", "Gelombang besar yang menghantam daratan."));
        tsunami.add(new Node("Penyebab", "Gempa bawah laut, letusan gunung api."));
        tsunami.add(new Node("Pencegahan", "Sistem peringatan dini."));
        tsunami.add(new Node("Cara Mengatasi", "Evakuasi ke dataran tinggi."));
        disasterMap.put("Tsunami", tsunami);

        LinkedList volcanicEruption = new LinkedList();
        volcanicEruption.add(new Node("Deskripsi", "Letusan gunung berapi yang memuntahkan material."));
        volcanicEruption.add(new Node("Penyebab", "Aktivitas magma di dalam gunung."));
        volcanicEruption.add(new Node("Pencegahan", "Zona larangan masuk."));
        volcanicEruption.add(new Node("Cara Mengatasi", "Evakuasi dan penyelamatan."));
        disasterMap.put("Gunung Meletus", volcanicEruption);

        while (true) {
            System.out.println("\n=== Sistem Informasi Bencana Alam ===");
            System.out.println("1. Tambah data bencana.");
            System.out.println("2. Tampilkan data bencana.");
            System.out.println("3. Hapus data bencana.");
            System.out.println("4. Keluar.");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama bencana: ");
                    String disasterName = sc.nextLine();

                    LinkedList disasterDetails = new LinkedList();
                    System.out.print("Deskripsi bencana: ");
                    disasterDetails.add(new Node("Deskripsi", sc.nextLine()));
                    System.out.print("Penyebab bencana: ");
                    disasterDetails.add(new Node("Penyebab", sc.nextLine()));
                    System.out.print("Pencegahan bencana: ");
                    disasterDetails.add(new Node("Pencegahan", sc.nextLine()));
                    System.out.print("Cara mengatasi bencana: ");
                    disasterDetails.add(new Node("Cara Mengatasi", sc.nextLine()));

                    disasterMap.put(disasterName, disasterDetails);
                    System.out.println("Data bencana berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.print("Masukkan nama bencana yang ingin ditampilkan: ");
                    String searchName = sc.nextLine();
                    LinkedList data = disasterMap.get(searchName);
                    if (data == null) {
                        System.out.println("Data bencana tidak ditemukan.");
                    } else {
                        System.out.println("Informasi tentang: " + searchName);
                        data.display();
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nama bencana yang ingin dihapus: ");
                    String deleteName = sc.nextLine();
                    disasterMap.remove(deleteName);
                    System.out.println("Data bencana berhasil dihapus.");
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem informasi.");
                    sc.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
