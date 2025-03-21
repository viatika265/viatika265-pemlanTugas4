package swalayantiny;

import java.util.Scanner;

public class Main { // class utama untuk menjalankan program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pelanggan pelanggan = new Pelanggan("Wonahika", "KA12097429", 90000, "SIAPK"); 
        
    
        while (true) { //loop transaksi
            System.out.print("Masukkan nomor pelanggan anda: ");
            String nomor = input.next();
            System.out.print("Masukkan PIN anda: ");
            String pin = input.next();


            if (!pelanggan.autentifikasi(nomor, pin)) { // autentifikasi pelanggan
                continue;
            }

            while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Top Up");
            System.out.println("2. Pembelian");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();

            if (pilih == 1) { // pelanggan memilih top up
                System.out.print("Masukkan nominal top up: ");
                int jumlahTransaksi = input.nextInt();
                pelanggan.topUp(jumlahTransaksi); // memanggil metode topUp
            } else if (pilih == 2) { // pelanggan memilih melakukan transaksi pembelian
                System.out.print("Masukkan nominal pembelian: ");
                int jumlahTransaksi = input.nextInt();
                pelanggan.transaksi(jumlahTransaksi); // memanggil metode transaksi
            } else { // pelanggan menghentikan proses atau keluar
                System.out.println("Terima kasih telah bertransaksi di Swalayan Tiny");
                break;
            }

            
        }
    

        input.close(); // menutup program
    }
}
}
