package swalayantiny;
import java.util.Scanner;

class Pelanggan { // class
    private int saldo; // atribute private
    private String noPelanggan;
    private String nama;
    private String pin;
    private boolean diblokir = false;
    private int kesalahanAutentifikasi = 0;


    public Pelanggan (String nama, String nopelanggan, int saldo, String pin) { //konstraktor
        this.saldo = saldo; //menggunakan this karena nama atribut dan konstraktornya sama
        this.noPelanggan = nopelanggan;
        this.nama = nama;
        this.pin = pin;
    }

    public int getSaldo() { // mengambil nilai saldo
        return saldo;

    }

    public String getNoPelanggan() { //mengambil nilai nomor pelanggan
        return noPelanggan;
    }
    
    public String getNama() { //mengambil nilai nama
        return nama;
    }

    public String getPin() { //mengambil nilai pin
        return pin;
    }

    public boolean isDiblokir() { //mengecek apakah akun pelanggan diblokir
        return diblokir;
    } 

    public boolean autentifikasi (String no, String pinInput){ //autentifikasi berdasarkan nomor dan pin
        if (diblokir) {
            System.out.println("Akun anda telah diblokir");
            return false;
        }
            if (no.equals(noPelanggan) && pinInput.equals(pin)) { // autentifikasi berhasil
                kesalahanAutentifikasi = 0; // reset kesalahan autentifikasi
                return true;
            } else { // jika autentifikasi gagal
                kesalahanAutentifikasi++;
                System.out.println("Autentikasi gagal (" + kesalahanAutentifikasi + "/3).");
                if (kesalahanAutentifikasi >= 3) { //jika gagal 3 kali, akun akan diblokir
                    diblokir = true;
                    System.out.println("Akun anda telah diblokir.");
                }
                return false;
            }
        }

        public void topUp (int jumlahTransaksi) { //method top up saldo
            saldo += jumlahTransaksi; // tambah saldo dengan jumlah yang di top up
            System.out.println("Top up berhasil ditambahkan: Rp" + saldo);

        }

        public void transaksi(int jumlahTransaksi) {
            if (saldo - jumlahTransaksi > 10000) {
                pembelian(jumlahTransaksi);
            } else {
                System.out.println("Transaksi tidak dapat diproses! Saldo anda kurang dari 10.000 setelah transaksi.");
            }
        }//memproses pembelian
        
        private void pembelian (int jumlahTransaksi) { //method untuk menangani pembelian dan cashback
            int cashback = hitungCashback(jumlahTransaksi); // hitung cashbback berdasarkan jumlah transaksi
             saldo -= jumlahTransaksi; // menambahkan cashback ke saldo
             saldo += cashback;
             System.out.println("Pembelian berhasil! Cashback: Rp" + cashback);
             System.out.println("Saldo sekarang: Rp" + saldo);
        }

        private int hitungCashback (int jumlahTransaksi) { // method mengitung casgback
            String jenis = noPelanggan.substring(0, 2); // 2 digit dari nomor pelanggan
            if (jenis.equals("38")) { //pelanggan silver
                return (jumlahTransaksi > 1000000) ? jumlahTransaksi * 5 / 100 : 0;
            } else if (jenis.equals("56")) { //pelanggan gold
                return (jumlahTransaksi > 1000000) ? jumlahTransaksi * 7 / 100 : jumlahTransaksi * 2 / 100;
            } else if (jenis.equals("74")) { //pelanggan platinum
                return (jumlahTransaksi > 1000000) ? jumlahTransaksi * 10 / 100 : jumlahTransaksi * 5 / 100;
            }
            return 0; // tttidak ada cashback untuk nomor yang tidak dikenali
        }


    }

    

