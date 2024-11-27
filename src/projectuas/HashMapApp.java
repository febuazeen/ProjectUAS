/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas;

import java.util.Scanner;

/**
 *
 * @author Alhamdulillah
 */
class Node {

    String key;
    String value;
    Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class LinkedList {

    private Node head;

    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = node;
        }
    }

    public Node find(String key) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.key.equals(key)) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public void remove(String key) {
        if (head.key.equals(key)) {
            head = head.next;
        } else {
            Node curNode = head;
            while (curNode.next != null) {
                if (curNode.next.key.equals(key)) {
                    curNode.next = curNode.next.next;
                    break;
                }
                curNode = curNode.next;
            }
        }
    }

    public void display() {
        Node curNode = head;
        while (curNode != null) {
            System.out.println(curNode.key + ": " + curNode.value);
            curNode = curNode.next;
        }
    }
}

class Hashmap {

    private LinkedList[] buckets;
    private int capacity;
    private int size;

    public Hashmap() {
        capacity = 16;
        buckets = new LinkedList[capacity];
        size = 0;
    }

    public int hash(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public void put(String key, String value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList();
        }
        Node exitingNode = buckets[index].find(key);
        if (exitingNode != null) {
            exitingNode.value = value;
        } else {
            buckets[index].add(new Node(key, value));
            size++;
        }
    }

    public String get(String key) {
        int index = hash(key);
        LinkedList bucket = buckets[index];
        if (bucket != null) {
            Node node = bucket.find(key);
            if (node != null) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        LinkedList bucket = buckets[index];
        if (bucket != null) {
            bucket.remove(key);
        }
    }
}

public class HashMapApp {

    public static void main(String[] args) {
        Hashmap kamus = new Hashmap();

        kamus.put("adus", "mandi");
        kamus.put("wedhi", "pasir");
        kamus.put("kula", "saya");
        kamus.put("ndalem", "rumah");
        kamus.put("cah", "anak");
        kamus.put("mbiyen", "dulu");
        kamus.put("anggo", "pakai");
        kamus.put("esuk", "pagi");
        kamus.put("gawe", "buat");
        kamus.put("tangi", "bangun");
        kamus.put("ngombe", "minum");
        kamus.put("sawon", "ikan");
        kamus.put("kembang", "bunga");
        kamus.put("dhuwur", "tinggi");
        kamus.put("krupuk", "kerupuk");
        kamus.put("jajan", "makanan ringan");
        kamus.put("longkrong", "duduk santai");
        kamus.put("lumpat", "lari");
        kamus.put("turun", "jatuh");
        kamus.put("pangan", "makanan");
        kamus.put("seneng", "senang");
        kamus.put("sedih", "sedih");
        kamus.put("rabi", "istri");
        kamus.put("bojo", "suami");
        kamus.put("keplek", "terjatuh");
        kamus.put("mlaku", "berjalan");
        kamus.put("belanja", "membeli");
        kamus.put("mikir", "berpikir");
        kamus.put("tirakat", "berusaha");
        kamus.put("dolan", "bermain");
        kamus.put("mbangun", "membangun");
        kamus.put("nduk", "mengambil");
        kamus.put("nyekel", "memegang");
        kamus.put("tutup", "penutupan");
        kamus.put("senyum", "tersenyum");
        kamus.put("sesek", "penat");
        kamus.put("golek", "mencari");
        kamus.put("gugur", "jatuh");
        kamus.put("sampun", "sudah");
        kamus.put("ngajeng", "menghadiri");
        kamus.put("sakit", "sakit");
        kamus.put("kenceng", "cepat");
        kamus.put("cetek", "dangkal");
        kamus.put("nyandhet", "terhenti");
        kamus.put("bagus", "baik");
        kamus.put("cemlorot", "berkilau");
        kamus.put("manis", "manis");
        kamus.put("garing", "kering");
        kamus.put("urip", "hidup");
        kamus.put("mateni", "membunuh");
        kamus.put("nguncal", "melempar");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Kamus Jawa-Indonesia ===");
            System.out.println("1. Cari arti kata.");
            System.out.println("2. Tambah kata.");
            System.out.println("3. Hapus kata.");
            System.out.println("4. Keluar.");
            int pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kata: ");
                    String find = sc.nextLine();
                    String arti = kamus.get(find);
                    if (arti == null) {
                        System.out.println("Kata tidak ditemukan.");
                    } else {
                        System.out.println("Arti: " + arti);
                    }
                    break;
                case 2:
                    System.out.print("Masukkan kata jawa: ");
                    String key = sc.nextLine();
                    System.out.print("Masukkan arti dalam bahasa indonesia: ");
                    String value = sc.nextLine();
                    kamus.put(key, value);
                    System.out.println("Kata berhasil ditambahkan.");
                    break;
                case 3:
                    System.out.print("Masukkan kata yang ingin dihapus: ");
                    String delete = sc.nextLine();
                    kamus.remove(delete);
                    System.out.println("Kata berhasil dihapus.");
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan kamus");
                    sc.close();
                    return;
                default:
                    System.out.println("pilihan tidak valid");
            }
        }
    }
}
