import java.util.Scanner;

/**
 * Kelas Main — Antarmuka Terminal NeoBank
 * 
 * Merakit seluruh arsitektur OOP yang telah dibangun ke dalam menu interaktif.
 * Pengguna dapat melakukan registrasi, buka rekening, login, transaksi,
 * dan menghubungi customer service.
 * 
 * Di akhir: skenario penutupan akun paksa dengan analisis siklus hidup objek.
 */
public class Main {

    // Scanner global untuk input pengguna
    static Scanner scanner = new Scanner(System.in);

    // Data aktif sesi
    static Nasabah nasabahAktif = null;         // Nasabah yang sedang login
    static Rekening rekeningAktif = null;       // Rekening yang sedang aktif di sesi
    static boolean sudahLogin = false;

    // "Database" sederhana: array penampung semua nasabah dan rekening yang ada
    static Nasabah[] semuaNasabah = new Nasabah[10];
    static int jumlahNasabahTerdaftar = 0;

    // =====================================================================
    // PENTING: Referensi independen ke rekening (untuk demo AGREGASI)
    // Rekening yang dibuat disimpan juga di sini, terpisah dari nasabah.
    // Ini membuktikan bahwa rekening bisa hidup meski nasabahnya dihapus.
    // =====================================================================
    static Rekening[] arsipRekening = new Rekening[30];
    static int jumlahArsipRekening = 0;

    // CustomerService siaga
    static CustomerService cs1 = new CustomerService("CS-001", "Rina Puspitasari");
    static CustomerService cs2 = new CustomerService("CS-002", "Budi Santoso");

    // Nomor rekening counter (auto-increment)
    static int counterNomorRek = 1001;

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        SELAMAT DATANG DI NEOBANK     ║");
        System.out.println("║     Sistem Perbankan Digital Modern   ║");
        System.out.println("╚══════════════════════════════════════╝");

        boolean jalan = true;
        while (jalan) {
            if (!sudahLogin) {
                tampilkanMenuUtama();
                int pilihan = bacaAngka();
                switch (pilihan) {
                    case 1 -> menuRegistrasiNasabah();
                    case 2 -> menuLogin();
                    case 3 -> menuHubungiCS(null);  // tanpa login juga bisa
                    case 0 -> {
                        System.out.println("\nTerima kasih telah menggunakan NeoBank. Sampai jumpa!");
                        // ================================================================
                        // SKENARIO PENUTUPAN AKUN PAKSA
                        // Dilakukan di sini sebelum program benar-benar berakhir
                        // ================================================================
                        skenarioPenutupanAkunPaksa();
                        jalan = false;
                    }
                    default -> System.out.println("  Pilihan tidak valid.");
                }
            } else {
                tampilkanMenuNasabah();
                int pilihan = bacaAngka();
                switch (pilihan) {
                    case 1 -> menuBukaRekening();
                    case 2 -> menuPilihRekening();
                    case 3 -> menuSetor();
                    case 4 -> menuTarik();
                    case 5 -> menuLihatInfo();
                    case 6 -> menuHubungiCS(nasabahAktif);
                    case 7 -> logout();
                    case 0 -> {
                        logout();
                        skenarioPenutupanAkunPaksa();
                        jalan = false;
                    }
                    default -> System.out.println("  Pilihan tidak valid.");
                }
            }
        }
        scanner.close();
    }

    // ================================================================
    // MENU DISPLAY
    // ================================================================

    static void tampilkanMenuUtama() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│           MENU UTAMA NEOBANK         │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Registrasi Nasabah Baru          │");
        System.out.println("│  2. Login                            │");
        System.out.println("│  3. Hubungi Customer Service         │");
        System.out.println("│  0. Keluar                           │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Pilihan Anda: ");
    }

    static void tampilkanMenuNasabah() {
        String info = nasabahAktif.getNamaLengkap();
        if (rekeningAktif != null) info += " | Rek: " + rekeningAktif.getNomorRekening();
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│  Login sebagai: " + info);
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Buka Rekening Baru               │");
        System.out.println("│  2. Pilih / Ganti Rekening Aktif     │");
        System.out.println("│  3. Setor Dana                       │");
        System.out.println("│  4. Tarik Dana                       │");
        System.out.println("│  5. Lihat Info Rekening              │");
        System.out.println("│  6. Hubungi Customer Service         │");
        System.out.println("│  7. Logout                           │");
        System.out.println("│  0. Keluar & Tutup Aplikasi          │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Pilihan Anda: ");
    }

    // ================================================================
    // MENU REGISTRASI
    // ================================================================

    static void menuRegistrasiNasabah() {
        System.out.println("\n=== REGISTRASI NASABAH BARU ===");
        if (jumlahNasabahTerdaftar >= 10) {
            System.out.println("  [ERROR] Database penuh.");
            return;
        }
        System.out.print("  Nama Lengkap  : ");
        String nama = scanner.nextLine().trim();
        System.out.print("  No. Telepon   : ");
        String telp = scanner.nextLine().trim();

        if (nama.isEmpty() || telp.isEmpty()) {
            System.out.println("  [ERROR] Data tidak boleh kosong.");
            return;
        }

        // Generate ID nasabah otomatis
        String idNasabah = "NSB-" + String.format("%04d", jumlahNasabahTerdaftar + 1);

        // INSTANSIASI Nasabah baru (referensi disimpan di array database)
        Nasabah nasabahBaru = new Nasabah(idNasabah, nama, telp);
        semuaNasabah[jumlahNasabahTerdaftar] = nasabahBaru;
        jumlahNasabahTerdaftar++;

        System.out.println("  ID Nasabah Anda: " + idNasabah);
        System.out.println("  Registrasi berhasil! Silakan login.");
    }

    // ================================================================
    // MENU LOGIN — simulasi verifikasiPIN via interface Otorisasi
    // ================================================================

    static void menuLogin() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("  ID Nasabah    : ");
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
            System.out.println("  [GAGAL] ID Nasabah tidak ditemukan.");
            return;
        }

        // Jika nasabah belum punya rekening, langsung masuk tanpa PIN rekening
        if (ditemukan.getJumlahRekening() == 0) {
            nasabahAktif = ditemukan;
            sudahLogin = true;
            System.out.println("  Selamat datang, " + nasabahAktif.getNamaLengkap() + "!");
            System.out.println("  Anda belum memiliki rekening. Silakan buka rekening terlebih dahulu.");
            return;
        }

        // Pilih rekening untuk verifikasi PIN
        System.out.println("  Rekening yang terdaftar:");
        for (int i = 0; i < ditemukan.getJumlahRekening(); i++) {
            System.out.println("  " + (i + 1) + ". " + ditemukan.getRekening(i).getNomorRekening());
        }
        System.out.print("  Pilih rekening (nomor): ");
        int pil = bacaAngka() - 1;
        Rekening rekPilih = ditemukan.getRekening(pil);

        if (rekPilih == null) {
            System.out.println("  [ERROR] Pilihan tidak valid.");
            return;
        }

        System.out.print("  Masukkan PIN    : ");
        String pinInput = scanner.nextLine().trim();

        // ABSTRAKSI via interface Otorisasi: panggil verifikasiPIN()
        // Kita tidak perlu tahu implementasinya — cukup panggil kontraknya.
        if (rekPilih.verifikasiPIN(pinInput)) {
            nasabahAktif = ditemukan;
            rekeningAktif = rekPilih;
            sudahLogin = true;
            System.out.println("  Login berhasil! Selamat datang, " + nasabahAktif.getNamaLengkap() + ".");
        } else {
            System.out.println("  [GAGAL] PIN salah. Akses ditolak.");
        }
    }

    // ================================================================
    // MENU BUKA REKENING
    // ================================================================

    static void menuBukaRekening() {
        System.out.println("\n=== BUKA REKENING BARU ===");
        System.out.println("  Jenis rekening:");
        System.out.println("  1. Rekening Reguler  (biaya admin Rp7.500 per penarikan)");
        System.out.println("  2. Rekening Prioritas (bebas biaya admin, saldo min. Rp5jt)");
        System.out.print("  Pilih jenis: ");
        int jenis = bacaAngka();

        if (jenis != 1 && jenis != 2) {
            System.out.println("  Pilihan tidak valid.");
            return;
        }

        System.out.print("  Saldo awal (Rp): ");
        double saldoAwal;
        try {
            saldoAwal = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  [ERROR] Input tidak valid.");
            return;
        }

        System.out.print("  Buat PIN (6 digit): ");
        String pin = scanner.nextLine().trim();
        if (pin.length() != 6) {
            System.out.println("  [ERROR] PIN harus 6 digit.");
            return;
        }

        // Generate nomor rekening
        String nomorRek = "NEO-" + (counterNomorRek++);

        // PEWARISAN + POLIMORFISME: buat subclass yang sesuai
        Rekening rekeningBaru;
        if (jenis == 1) {
            rekeningBaru = new RekeningReguler(nomorRek, nasabahAktif.getNamaLengkap(), saldoAwal, pin);
        } else {
            rekeningBaru = new RekeningPrioritas(nomorRek, nasabahAktif.getNamaLengkap(), saldoAwal, pin);
        }

        // AGREGASI: simpan referensi rekening di arsip pusat (independen dari nasabah)
        arsipRekening[jumlahArsipRekening++] = rekeningBaru;

        // AGREGASI: tambahkan referensi ke profil nasabah (loose-coupling)
        if (nasabahAktif.tambahRekening(rekeningBaru)) {
            rekeningAktif = rekeningBaru; // otomatis set sebagai rekening aktif
            System.out.println("  Nomor rekening baru Anda: " + nomorRek);
        }
    }

    // ================================================================
    // MENU PILIH REKENING AKTIF
    // ================================================================

    static void menuPilihRekening() {
        System.out.println("\n=== PILIH REKENING AKTIF ===");
        if (nasabahAktif.getJumlahRekening() == 0) {
            System.out.println("  Belum ada rekening. Silakan buka rekening dulu.");
            return;
        }
        nasabahAktif.tampilkanSemuaRekening();
        System.out.print("\n  Pilih nomor rekening (1-" + nasabahAktif.getJumlahRekening() + "): ");
        int pil = bacaAngka() - 1;
        Rekening pilih = nasabahAktif.getRekening(pil);
        if (pilih == null) {
            System.out.println("  Pilihan tidak valid.");
            return;
        }
        System.out.print("  Masukkan PIN rekening " + pilih.getNomorRekening() + ": ");
        String pin = scanner.nextLine().trim();

        // Verifikasi PIN sebelum berpindah rekening aktif
        if (pilih.verifikasiPIN(pin)) {
            rekeningAktif = pilih;
            System.out.println("  Rekening aktif berganti ke: " + rekeningAktif.getNomorRekening());
        } else {
            System.out.println("  [GAGAL] PIN salah.");
        }
    }

    // ================================================================
    // MENU SETOR
    // ================================================================

    static void menuSetor() {
        System.out.println("\n=== SETOR DANA ===");
        if (rekeningAktif == null) {
            System.out.println("  Pilih rekening aktif terlebih dahulu.");
            return;
        }
        System.out.println("  Rekening aktif: " + rekeningAktif.getNomorRekening());
        System.out.print("  Jumlah setor (Rp): ");
        try {
            double jumlah = Double.parseDouble(scanner.nextLine().trim());
            // ENKAPSULASI: hanya bisa setor lewat metode setor()
            rekeningAktif.setor(jumlah);
        } catch (NumberFormatException e) {
            System.out.println("  [ERROR] Input tidak valid.");
        }
    }

    // ================================================================
    // MENU TARIK
    // ================================================================

    static void menuTarik() {
        System.out.println("\n=== TARIK DANA ===");
        if (rekeningAktif == null) {
            System.out.println("  Pilih rekening aktif terlebih dahulu.");
            return;
        }
        System.out.println("  Rekening aktif: " + rekeningAktif.getNomorRekening()
                + " (" + rekeningAktif.getClass().getSimpleName() + ")");
        System.out.println("  Saldo saat ini: Rp" + String.format("%,.0f", rekeningAktif.getSaldo()));
        System.out.print("  Jumlah tarik (Rp): ");
        try {
            double jumlah = Double.parseDouble(scanner.nextLine().trim());
            // POLIMORFISME: memanggil tarik() — JVM menentukan versi mana yang dijalankan
            // (RekeningReguler.tarik() atau RekeningPrioritas.tarik()) secara otomatis
            rekeningAktif.tarik(jumlah);
        } catch (NumberFormatException e) {
            System.out.println("  [ERROR] Input tidak valid.");
        }
    }

    // ================================================================
    // MENU LIHAT INFO
    // ================================================================

    static void menuLihatInfo() {
        System.out.println("\n=== INFO PROFIL & REKENING ===");
        nasabahAktif.tampilkanProfil();
        nasabahAktif.tampilkanSemuaRekening();
    }

    // ================================================================
    // MENU CUSTOMER SERVICE — ASOSIASI
    // ================================================================

    static void menuHubungiCS(Nasabah nasabah) {
        System.out.println("\n=== HUBUNGI CUSTOMER SERVICE ===");
        System.out.println("  CS tersedia:");
        System.out.println("  1. " + cs1.getNamaCS() + " (" + cs1.getIdCS() + ")");
        System.out.println("  2. " + cs2.getNamaCS() + " (" + cs2.getIdCS() + ")");
        System.out.print("  Pilih CS: ");
        int pilCS = bacaAngka();
        CustomerService csYangDipilih = (pilCS == 1) ? cs1 : cs2;

        System.out.print("  Nama Anda (jika belum login): ");
        String namaPelapor;
        if (nasabah != null) {
            namaPelapor = nasabah.getNamaLengkap();
            System.out.println("  (Otomatis menggunakan nama: " + namaPelapor + ")");
        } else {
            namaPelapor = scanner.nextLine().trim();
            if (namaPelapor.isEmpty()) namaPelapor = "Anonim";
        }

        System.out.print("  Keluhan Anda  : ");
        String keluhan = scanner.nextLine().trim();

        if (nasabah != null) {
            // ASOSIASI: Nasabah memanggil laporKeluhan() dengan CS sebagai parameter
            nasabah.laporKeluhan(csYangDipilih, keluhan);
        } else {
            // Akses langsung CS tanpa objek Nasabah (asosiasi umum)
            csYangDipilih.terimaKeluhan(namaPelapor, keluhan);
        }
    }

    // ================================================================
    // LOGOUT
    // ================================================================

    static void logout() {
        System.out.println("\n  Logout berhasil. Sampai jumpa, " + nasabahAktif.getNamaLengkap() + ".");
        nasabahAktif = null;
        rekeningAktif = null;
        sudahLogin = false;
    }

    // ================================================================
    // HELPER: Baca angka dari input
    // ================================================================

    static int bacaAngka() {
        try {
            String line = scanner.nextLine().trim();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ================================================================
    // SKENARIO PENUTUPAN AKUN PAKSA
    // Analisis siklus hidup objek: KOMPOSISI vs AGREGASI
    // ================================================================

    /**
     * Skenario penutupan akun paksa untuk membuktikan teori OOP:
     * 
     * [KOMPOSISI] Rekening → BukuMutasi
     * Ketika objek Rekening di-set null (dan tidak ada referensi lain), JVM akan
     * menandainya untuk Garbage Collection. BukuMutasi yang dibuat di dalam
     * constructor Rekening juga ikut musnah karena referensinya hanya ada di dalam
     * field private Rekening — tidak bisa diakses dari luar.
     * 
     * [AGREGASI] Nasabah → Rekening[]
     * Ketika profil Nasabah di-set null, objek Rekening yang ada di dalam array-nya
     * TIDAK otomatis musnah, selama masih ada referensi lain yang menunjuk ke
     * objek Rekening tersebut (dalam kasus ini: array arsipRekening di kelas Main).
     */
    static void skenarioPenutupanAkunPaksa() {
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          SKENARIO PENUTUPAN AKUN PAKSA (DEMO OOP)        ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

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
        // Profil nasabah dihancurkan (set null → eligible untuk Garbage Collection)
        nasabahDemo = null;

        System.out.println("\n========== ANALISIS SIKLUS HIDUP OBJEK ==========");
        System.out.println();
        System.out.println(">> [AGREGASI — TERBUKTI]");
        System.out.println("   Nasabah di-set null, tetapi objek Rekening NEO-9999 MASIH HIDUP.");
        System.out.println("   Bukti: referensiIndependen masih bisa mengakses rekening.");
        System.out.println("   Saldo rekening sekarang: Rp"
                + String.format("%,.0f", referensiIndependen.getSaldo()));
        System.out.println("   → Rekening adalah entitas mandiri (loose coupling).");
        System.out.println("   → Menghapus nasabah TIDAK menghapus rekening.");
        System.out.println("   → Ini sesuai definisi AGREGASI dalam teori OOP.");
        System.out.println();

        System.out.println(">> [KOMPOSISI — ANALISIS TEORITIS]");
        System.out.println("   BukuMutasi dibuat HANYA di dalam constructor Rekening.");
        System.out.println("   Referensi ke BukuMutasi hanya ada di field private Rekening.");
        System.out.println("   Tidak ada cara untuk mengakses BukuMutasi dari luar Rekening.");
        System.out.println("   Ketika semua referensi ke Rekening di-set null:");
        System.out.println("     → Rekening eligible untuk Garbage Collection");
        System.out.println("     → BukuMutasi kehilangan satu-satunya referensi (dari Rekening)");
        System.out.println("     → BukuMutasi juga eligible untuk Garbage Collection");
        System.out.println("     → Keduanya musnah bersama (BukuMutasi tidak bisa hidup sendiri)");
        System.out.println("   → Ini sesuai definisi KOMPOSISI: 'part-of' yang tidak bisa berdiri sendiri.");
        System.out.println();

        System.out.println("[4] Menghapus referensi terakhir ke rekening...");
        referensiIndependen = null;
        rekeningDemo = null;

        System.out.println("   Semua referensi ke Rekening NEO-9999 sudah null.");
        System.out.println("   → Rekening (beserta BukuMutasi-nya) sekarang eligible untuk GC.");
        System.out.println("   → Pada GC berikutnya, keduanya akan dibebaskan dari heap memory.");
        System.out.println();
        System.out.println("=================================================");
        System.out.println("Skenario selesai. Arsitektur OOP NeoBank telah diverifikasi.");
        System.out.println("=================================================");
    }
}
