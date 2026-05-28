import java.util.Scanner;

public class App {
// Scanner global untuk input pengguna
    static Scanner scanner = new Scanner(System.in);

    // Data aktif sesi
    static Nasabah nasabahAktif = null;         // Nasabah yang sedang login
    static Rekening rekeningAktif = null;       // Rekening yang sedang aktif di sesi
    static boolean sudahLogin = false;
    static Nasabah[] semuaNasabah = new Nasabah[10];    // "Database" sederhana: array penampung semua nasabah dan rekening yang ada
    static int jumlahNasabahTerdaftar = 0;
    static Rekening[] arsipRekening = new Rekening[30];
    static int jumlahArsipRekening = 0;

    // CustomerService siaga
    static CustomerService cs1 = new CustomerService("CS-001", "Rina Puspitasari");
    static CustomerService cs2 = new CustomerService("CS-002", "Budi Santoso");

    // Nomor rekening counter (auto-increment)
    static int counterNomorRek = 1001;

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("SELAMAT DATANG DI NEOBANK");
        System.out.println("=========================================");
     
        boolean jalan = true;
        while (jalan) {
            if (!sudahLogin) {
                tampilkanMenuUtama();
                int pilihan = bacaAngka();
                switch (pilihan) {
                    case 1 : 
                        menuRegistrasiNasabah();
                        break;
                    case 2 : 
                        menuLogin();
                        break;
                    case 3 : 
                        menuHubungiCS(null);  // tanpa login juga bisa
                        break;
                    case 0 : 
                        System.out.println("\nTerima kasih telah menggunakan NeoBank. Sampai jumpa!");
                        skenarioPenutupanAkunPaksa();       // SKENARIO PENUTUPAN AKUN PAKSA
                        jalan = false;
                        break;
                    default : 
                        System.out.println("  Pilihan tidak valid.");
                        break;
                }
            } 
            else {
                tampilkanMenuNasabah();
                int pilihan = bacaAngka();
                switch (pilihan) {
                    case 1 : 
                        menuBukaRekening();
                        break;
                    case 2 : 
                        menuPilihRekening();
                        break;
                    case 3 : 
                        menuSetor();
                        break;
                    case 4 : 
                        menuTarik();
                        break;
                    case 5 : 
                        menuLihatInfo();
                        break;
                    case 6 : 
                        menuHubungiCS(nasabahAktif);
                        break;
                    case 7 : 
                        logout();
                        break;
                    case 0 : {
                        logout();
                        skenarioPenutupanAkunPaksa();
                        jalan = false;
                        break;
                    }
                    default : 
                        System.out.println("  Pilihan tidak valid.");
                        break;
                }
            }
        }
        scanner.close();
    }

    static void tampilkanMenuUtama() {      // Tampilan menu utama
        System.out.println("\n========================================");
        System.out.println("MENU UTAMA");
        System.out.println("========================================");
        System.out.println("1. Registrasi Nasabah Baru");
        System.out.println("2. Login");
        System.out.println("3. Hubungi Customer Service");
        System.out.println("0. Keluar");
        System.out.println("========================================");
        System.out.print("Pilih: ");
    }

    static void tampilkanMenuNasabah() {            // Tampilan menu nasabah
        String info = nasabahAktif.getNamaLengkap();
        if (rekeningAktif != null) info += " | Rek: " + rekeningAktif.getNomorRekening();
        System.out.println("\n========================================");
        System.out.println(" Login sebagai: " + info);
        System.out.println("========================================");
        System.out.println("1. Buka Rekening Baru");
        System.out.println("2. Pilih / Ganti Rekening Aktif");
        System.out.println("3. Setor Dana");
        System.out.println("4. Tarik Dana");
        System.out.println("5. Lihat Info Rekening");
        System.out.println("6. Hubungi Customer Service");
        System.out.println("7. Logout");
        System.out.println("0. Keluar & Tutup Aplikasi");
        System.out.println("========================================");
        System.out.print("Pilihan Anda: ");
    }

    static void menuRegistrasiNasabah() {           // MENU REGISTRASI
        System.out.println("\n=== REGISTRASI NASABAH BARU ===");
        if (jumlahNasabahTerdaftar >= 10) {
            System.out.println("  [ERROR] Database penuh.");
            return;
        }
        System.out.print("Nama Lengkap  : ");
        String nama = scanner.nextLine().trim();
        System.out.print("No. Telepon   : ");
        String telp = scanner.nextLine().trim();

        if (nama.isEmpty() || telp.isEmpty()) {
            System.out.println("Data tidak boleh kosong.");
            return;
        }
        
        String idNasabah = "NSB-" + (jumlahNasabahTerdaftar + 1);   // Generate ID nasabah otomatis
        Nasabah nasabahBaru = new Nasabah(idNasabah, nama, telp);   // INSTANSIASI Nasabah baru (referensi disimpan di array database)
        semuaNasabah[jumlahNasabahTerdaftar] = nasabahBaru;
        jumlahNasabahTerdaftar++;

        System.out.println("  ID Nasabah Anda: " + idNasabah);
        System.out.println("  Registrasi berhasil! Silakan login.");
    }

    static void menuLogin() {               // MENU LOGIN & verifikasiPIN via interface Otorisasi
        System.out.println("\n=== LOGIN ===");
        System.out.print("ID Nasabah    : ");
        String idInput = scanner.nextLine().trim();

        // Cari nasabah berdasarkan ID
        Nasabah ditemukan = null;
        for (int i = 0; i < jumlahNasabahTerdaftar; i++) {
            if (semuaNasabah[i].getIdNasabah().equalsIgnoreCase(idInput)) {
                ditemukan = semuaNasabah[i];
                break;
            }
        }

        if (ditemukan == null) {
            System.out.println("ID Nasabah tidak ditemukan.");
            return;
        }
       
        if (ditemukan.getJumlahRekening() == 0) {       // Jika nasabah belum punya rekening, langsung masuk tanpa PIN rekening
            nasabahAktif = ditemukan;
            sudahLogin = true;
            System.out.println("Selamat datang, " + nasabahAktif.getNamaLengkap());
            System.out.println("Anda belum memiliki rekening. Silakan buka rekening terlebih dahulu.");
            return;
        }

        System.out.println("Rekening yang terdaftar:");           // Pilih rekening untuk verifikasi PIN
        for (int i = 0; i < ditemukan.getJumlahRekening(); i++) {
            System.out.println("  " + (i + 1) + ". " + ditemukan.getRekening(i).getNomorRekening());
        }
        System.out.print("Pilih rekening (nomor): ");
        int pil = bacaAngka() - 1;
        Rekening rekPilih = ditemukan.getRekening(pil);

        if (rekPilih == null) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        System.out.print("Masukkan PIN    : ");
        String pinInput = scanner.nextLine().trim();

        if (rekPilih.verifikasiPIN(pinInput)) {     // ABSTRAKSI via interface Otorisasi: panggil verifikasiPIN()
            nasabahAktif = ditemukan;
            rekeningAktif = rekPilih;
            sudahLogin = true;
            System.out.println("Login berhasil! Selamat datang, " + nasabahAktif.getNamaLengkap() + ".");
        } else {
            System.out.println("PIN salah. Akses ditolak.");
        }
    }

    static void menuBukaRekening() {        // MENU BUKA REKENING
        System.out.println("\n=== BUKA REKENING BARU ===");
        System.out.println("Jenis rekening:");
        System.out.println("1. Rekening Reguler  (biaya admin Rp7.500 per penarikan)");
        System.out.println("2. Rekening Prioritas (bebas biaya admin, saldo min. Rp5jt)");
        System.out.print("  Pilih jenis: ");
        int jenis = bacaAngka();

        if (jenis != 1 && jenis != 2) {
            System.out.println("  Pilihan tidak valid.");
            return;
        }

        System.out.print("Saldo awal (Rp): ");
        double saldoAwal;
        try {
            saldoAwal = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
            return;
        }

        System.out.print("  Buat PIN (6 digit): ");
        String pin = scanner.nextLine().trim();
        if (pin.length() != 6) {
            System.out.println("PIN harus 6 digit.");
            return;
        }

        
        String nomorRek = "NEO-" + (counterNomorRek++);     // Generate nomor rekening
        Rekening rekeningBaru;      // PEWARISAN + POLIMORFISME: buat subclass yang sesuai
        if (jenis == 1) {
            rekeningBaru = new RekeningReguler(nomorRek, nasabahAktif.getNamaLengkap(), saldoAwal, pin);
        } else {
            rekeningBaru = new RekeningPrioritas(nomorRek, nasabahAktif.getNamaLengkap(), saldoAwal, pin);
        }

        arsipRekening[jumlahArsipRekening++] = rekeningBaru;        // AGREGASI: simpan referensi rekening di arsip pusat (independen dari nasabah)

        if (nasabahAktif.tambahRekening(rekeningBaru)) {            // AGREGASI: tambahkan referensi ke profil nasabah (loose-coupling)
            rekeningAktif = rekeningBaru; // otomatis set sebagai rekening aktif
            System.out.println("Nomor rekening baru Anda: " + nomorRek);
        }
    }

    static void menuPilihRekening() {           // MENU PILIH REKENING AKTIF
        System.out.println("\n=== PILIH REKENING AKTIF ===");
        if (nasabahAktif.getJumlahRekening() == 0) {
            System.out.println("Belum ada rekening. Silakan buka rekening dulu.");
            return;
        }
        nasabahAktif.tampilkanSemuaRekening();
        System.out.print("\nPilih nomor rekening (1-" + nasabahAktif.getJumlahRekening() + "): ");
        int pil = bacaAngka() - 1;
        Rekening pilih = nasabahAktif.getRekening(pil);
        if (pilih == null) {
            System.out.println("Pilihan tidak valid.");
            return;
        }
        System.out.print("Masukkan PIN rekening " + pilih.getNomorRekening() + ": ");
        String pin = scanner.nextLine().trim();

        // Verifikasi PIN sebelum berpindah rekening aktif
        if (pilih.verifikasiPIN(pin)) {
            rekeningAktif = pilih;
            System.out.println("Rekening aktif berganti ke: " + rekeningAktif.getNomorRekening());
        } else {
            System.out.println("PIN salah.");
        }
    }

    static void menuSetor() {           // MENU SETOR
        System.out.println("\n=== SETOR DANA ===");
        if (rekeningAktif == null) {
            System.out.println("Pilih rekening aktif terlebih dahulu.");
            return;
        }
        System.out.println("Rekening aktif: " + rekeningAktif.getNomorRekening());
        System.out.print("Jumlah setor (Rp): ");
        try {
            double jumlah = Double.parseDouble(scanner.nextLine().trim());
            // ENKAPSULASI: hanya bisa setor lewat metode setor()
            rekeningAktif.setor(jumlah);
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        }
    }

    static void menuTarik() {           // MENU TARIK
        System.out.println("\n=== TARIK DANA ===");
        if (rekeningAktif == null) {
            System.out.println("Pilih rekening aktif terlebih dahulu.");
            return;
        }
        System.out.println("Rekening aktif: " + rekeningAktif.getNomorRekening() + " (" + rekeningAktif.getClass().getSimpleName() + ")");
        System.out.println("Saldo saat ini: Rp" + String.format("%,.0f", rekeningAktif.getSaldo()));
        System.out.print("Jumlah tarik (Rp): ");
        try {
            double jumlah = Double.parseDouble(scanner.nextLine().trim());
            // POLIMORFISME: memanggil tarik() — JVM menentukan versi mana yang dijalankan
            // (RekeningReguler.tarik() atau RekeningPrioritas.tarik()) secara otomatis
            rekeningAktif.tarik(jumlah);
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        }
    }

    static void menuLihatInfo() {           // MENU LIHAT INFO
        System.out.println("\n=== INFO PROFIL & REKENING ===");
        nasabahAktif.tampilkanProfil();
        nasabahAktif.tampilkanSemuaRekening();
    }

    // ================================================================
    // MENU CUSTOMER SERVICE — ASOSIASI
    // ================================================================

    static void menuHubungiCS(Nasabah nasabah) {
        System.out.println("\n=== HUBUNGI CUSTOMER SERVICE ===");
        System.out.println("CS tersedia:");
        System.out.println("1. " + cs1.getNamaCS() + " (" + cs1.getIdCS() + ")");
        System.out.println("2. " + cs2.getNamaCS() + " (" + cs2.getIdCS() + ")");
        System.out.print("Pilih CS: ");
        int pilCS = bacaAngka();
        CustomerService csYangDipilih = (pilCS == 1) ? cs1 : cs2;

        System.out.print("Nama Anda (jika belum login): ");
        String namaPelapor;
        if (nasabah != null) {
            namaPelapor = nasabah.getNamaLengkap();
            System.out.println("  (Otomatis menggunakan nama: " + namaPelapor + ")");
        } else {
            namaPelapor = scanner.nextLine().trim();
            if (namaPelapor.isEmpty()) namaPelapor = "Anonim";
        }

        System.out.print("Keluhan Anda  : ");
        String keluhan = scanner.nextLine().trim();

        if (nasabah != null) {            // ASOSIASI: Nasabah memanggil laporKeluhan() dengan CS sebagai parameter
            nasabah.laporKeluhan(csYangDipilih, keluhan);
        } else {            // Akses langsung CS tanpa objek Nasabah (asosiasi umum)
            csYangDipilih.terimaKeluhan(namaPelapor, keluhan);
        }
    }

    static void logout() {          // LOGOUT
        System.out.println("\n  Logout berhasil. Sampai jumpa, " + nasabahAktif.getNamaLengkap() + ".");
        nasabahAktif = null;
        rekeningAktif = null;
        sudahLogin = false;
    }

    static int bacaAngka() {        // Baca angka dari input
        try {
            String line = scanner.nextLine().trim();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /*
    SKENARIO PENUTUPAN AKUN PAKSA
     
    [KOMPOSISI] Rekening -> BukuMutasi
    Ketika objek Rekening di-set null (dan tidak ada referensi lain), JVM akan
    menandainya untuk Garbage Collection. BukuMutasi yang dibuat di dalam
    constructor Rekening juga ikut musnah karena referensinya hanya ada di dalam
    field private Rekening, sehingga tidak bisa diakses dari luar.
     
    [AGREGASI] Nasabah -> Rekening[]
    Ketika profil Nasabah di-set null, objek Rekening yang ada di dalam array-nya
    TIDAK otomatis musnah, selama masih ada referensi lain yang menunjuk ke
    objek Rekening tersebut (dalam kasus ini: array arsipRekening di kelas Main).
     */
    static void skenarioPenutupanAkunPaksa() {
        System.out.println("\n");
        System.out.println("==============================================================");
        System.out.println("SKENARIO PENUTUPAN AKUN PAKSA");
        System.out.println("==============================================================");

        System.out.println("\n[1] Membuat objek nasabah dan rekening untuk demonstrasi...");

        // Buat nasabah demo
        Nasabah nasabahDemo = new Nasabah("NSB-DEMO", "Demo Nasabah", "08123456789");

        // Buat rekening (rekening membuat BukuMutasi secara internal — KOMPOSISI)
        RekeningReguler rekeningDemo = new RekeningReguler("NEO-9999", "Demo Nasabah", 2_000_000, "123456");

        // Simpan referensi independen ke rekening (untuk demo agregasi)
        Rekening referensiIndependen = rekeningDemo;

        // AGREGASI: nasabah memegang referensi ke rekening (bukan membuatnya)
        nasabahDemo.tambahRekening(rekeningDemo);

        System.out.println("\n[2] Melakukan transaksi untuk mengisi buku mutasi...");
        rekeningDemo.setor(500_000);
        rekeningDemo.tarik(100_000);

        System.out.println("\n[3] Menutup profil nasabah secara paksa (nasabahDemo = null)...");
        // Profil nasabah dihancurkan (set null -> eligible untuk Garbage Collection)
        nasabahDemo = null;

        System.out.println("\n========== ANALISIS SIKLUS HIDUP OBJEK ==========");
        System.out.println();
        System.out.println(">> [AGREGASI — TERBUKTI]");
        System.out.println("   Nasabah di-set null, tetapi objek Rekening NEO-9999 MASIH HIDUP.");
        System.out.println("   Bukti: referensiIndependen masih bisa mengakses rekening.");
        System.out.println("   Saldo rekening sekarang: Rp" + referensiIndependen.getSaldo());
        System.out.println("   -> Rekening adalah entitas mandiri (loose coupling).");
        System.out.println("   -> Menghapus nasabah TIDAK menghapus rekening.");
        System.out.println("   -> Ini sesuai definisi AGREGASI dalam teori OOP.");
        System.out.println();

        System.out.println(">> [KOMPOSISI — ANALISIS TEORITIS]");
        System.out.println("   BukuMutasi dibuat HANYA di dalam constructor Rekening.");
        System.out.println("   Referensi ke BukuMutasi hanya ada di field private Rekening.");
        System.out.println("   Tidak ada cara untuk mengakses BukuMutasi dari luar Rekening.");
        System.out.println("   Ketika semua referensi ke Rekening di-set null:");
        System.out.println("     -> Rekening eligible untuk Garbage Collection");
        System.out.println("     -> BukuMutasi kehilangan satu-satunya referensi (dari Rekening)");
        System.out.println("     -> BukuMutasi juga eligible untuk Garbage Collection");
        System.out.println("     -> Keduanya musnah bersama (BukuMutasi tidak bisa hidup sendiri)");
        System.out.println("   -> Ini sesuai definisi KOMPOSISI: 'part-of' yang tidak bisa berdiri sendiri.");
        System.out.println();

        System.out.println("[4] Menghapus referensi terakhir ke rekening...");
        referensiIndependen = null;
        rekeningDemo = null;

        System.out.println("   Semua referensi ke Rekening NEO-9999 sudah null.");
        System.out.println("   -> Rekening (beserta BukuMutasi-nya) sekarang eligible untuk GC.");
        System.out.println("   -> Pada GC berikutnya, keduanya akan dibebaskan dari heap memory.");
        System.out.println();
        System.out.println("=================================================");
        System.out.println("Skenario selesai. Arsitektur OOP NeoBank telah diverifikasi.");
        System.out.println("=================================================");
    }
}
