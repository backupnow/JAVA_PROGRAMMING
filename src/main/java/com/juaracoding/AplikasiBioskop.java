package com.juaracoding;


/*
IntelliJ IDEA 2025.1.2 (Community Edition)
Build #IC-251.26094.121, built on June 3, 2025
@Author HP Wildernes Dakhi
Java Developer
Created on 13/07/2025 21:37
*/

import java.util.Scanner;

public class AplikasiBioskop {

    // Scanner global untuk input dari console
    static Scanner scanner = new Scanner(System.in);

    // Array untuk menyimpan judul film dan penghitung jumlah film
    static String[] daftarFilm = new String[10];
    static int jumlahFilm = 0;

    public static void main(String[] args) {
        // Panggil login terlebih dahulu
        login();

        // Setelah login sukses, masuk ke loop menu utama
        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // mengkonsumsi newline

            switch (pilihan) {
                case 1:
                    // Menampilkan semua film
                    tampilkanFilm();
                    break;
                case 2:
                    // Input data film baru
                    inputFilm();
                    break;
                case 3:
                    // Cari film berdasarkan judul
                    cariFilm();
                    break;
                case 4:
                    // Edit film
                    editFilm();
                    break;
                case 5:
                    // Hapus film
                    hapusFilm();
                    break;
                case 6:
                    // Keluar dari program
                    System.out.println("Terima kasih. Semoga kembali lagi.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    /**
     * Method untuk proses login.
     * Meminta username dan password hingga benar.
     */
    public static void login() {
        String username, password;

        System.out.println("==== Login ====");
        while (true) {
            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();

            // Validasi login
            if (username.equals("admin") && password.equals("12345")) {
                System.out.println("Login berhasil!\n");
                break;
            } else {
                System.out.println("Username atau password salah. Silakan coba lagi.\n");
            }
        }
    }

    /**
     * Method untuk menampilkan opsi menu utama.
     */
    public static void tampilkanMenu() {
        System.out.println("=== Menu Utama ===");
        System.out.println("Silahkan Pilih Menu Yang Tersedia");
        System.out.println("1. Tampilkan Daftar Film");
        System.out.println("2. Input Data Film");
        System.out.println("3. Cari Film");
        System.out.println("4. Edit Film");
        System.out.println("5. Hapus Film");
        System.out.println("6. Keluar");
        System.out.print("Pilih: ");
    }

    /**
     * Method untuk menambahkan film ke array.
     * Membatasi maksimum 10 film.
     */
    public static void inputFilm() {
        if (jumlahFilm >= daftarFilm.length) {
            System.out.println("Kapasitas film sudah penuh (10). Tidak bisa menambah lagi.\n");
            return;
        }

        System.out.print("Masukkan jumlah film yang ingin ditambahkan: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // bersihkan newline

        // Memastikan tidak melebihi kapasitas
        if (jumlahFilm + n > daftarFilm.length) {
            System.out.println("Melebihi kapasitas maksimum. Kamu bisa menambahkan maksimal "
                    + (daftarFilm.length - jumlahFilm) + " film saja.\n");
            return;
        }

        // Input judul film satu per satu
        for (int i = 0; i < n; i++) {
            System.out.print("Film ke-" + (jumlahFilm + 1) + " Judul: ");
            daftarFilm[jumlahFilm] = scanner.nextLine();
            jumlahFilm++;
        }
        System.out.println("Selesai menambahkan " + n + " film.\n");
    }

    /**
     * Method untuk menampilkan seluruh daftar film yang tersimpan.
     */
    public static void tampilkanFilm() {
        if (jumlahFilm == 0) {
            System.out.println("Pesan : Belum ada film yang tersimpan.\n");
            return;
        }

        System.out.println("=== Daftar Film ===");
        for (int i = 0; i < jumlahFilm; i++) {
            System.out.println((i + 1) + ". " + daftarFilm[i]);
        }
        System.out.println(); // baris kosong
    }

    /**
     * Method untuk mencari film berdasarkan judul (case-insensitive).
     */
    public static void cariFilm() {
        if (jumlahFilm == 0) {
            System.out.println("Pesan : Belum ada film yang tersimpan.\n");
            return;
        }

        System.out.print("Masukkan judul film yang dicari: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;

        // Telusuri seluruh daftarFilm
        for (int i = 0; i < jumlahFilm; i++) {
            if (daftarFilm[i].toLowerCase().contains(keyword)) {
                System.out.println("Film ditemukan: " + daftarFilm[i]);
                found = true;
            }
        }
        /*found buat penanda di temukan atau tidak
         * dan keyword buat kata kunci */
        if (!found) {
            System.out.println("Pesan : Film dengan judul \"" + keyword + "\" tidak ditemukan.");
        }
        System.out.println();
    }

    /*
    * Method untuk mengedit film dengan nomor*/
    public static void editFilm(){
        if (jumlahFilm == 0){
            System.out.println("Pesan : Belum ada Film untuk di Edit. \n");
            return;
        }
        //Memanggil Method yang mencetak daftar film
        tampilkanFilm();
        System.out.println("Masukan nomor Film yang mau di Edit : ");
        int nomorFilm = scanner.nextInt(); scanner.nextLine();
        if (nomorFilm < 1 || nomorFilm > jumlahFilm){
            System.out.println("Nomor tidak valid. \n");
            return;
        }
        System.out.println("Masukkan judul baru : ");
        String judulBaru = scanner.nextLine().trim();
        daftarFilm[nomorFilm-1] = judulBaru;
        System.out.println("Pesan : Film nomor " + nomorFilm + " berhasil di ubah. \n");
    }

    /*
    * Method untuk menghapus film dengan nomor*/
    public static void hapusFilm(){
        if (jumlahFilm == 0){
            System.out.println("Pesan : Belum ada film untuk di Hapus");
            return;
        }
        //Memanggil Method yang mencetak daftar film
        tampilkanFilm();
        System.out.println("Masukan nomor film yang ingin di Hapus : ");
        int nomorFilm = scanner.nextInt(); scanner.nextLine();
        // OR = salah satu kondisi terpenuhi untuk di anggap tidak valid
        if (nomorFilm < 1 || nomorFilm > jumlahFilm){
            System.out.println("Nomor tidak valid. \n");
            return;
        }
        /*
        * Menggeser elemen kekiri = menimpa film yang di hapus
        * dengan film berikutnya*/
        for (int i = nomorFilm - 1; i < jumlahFilm - 1; i++){
            daftarFilm[i] = daftarFilm[i+1];
        }
        //mengurangi jumlah film karena di hapus
        daftarFilm[--jumlahFilm] = null;// mengkosongkan slot
        System.out.println("Pesan : Film nomor " + nomorFilm + " berhasil di hapus. \n");


    }


}
