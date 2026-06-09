import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === COMPOSITION ROOT ===
        // Menyusun semua dependency dan inject ke Reservasi
        // Ini adalah satu-satunya tempat di mana class konkret di-instantiate

        // Siapkan data transportasi
        List<Transportasi> daftarTransportasi = new ArrayList<>();
        daftarTransportasi.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarTransportasi.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));

        // Buat implementasi konkret dari setiap interface
        Validatable validator = new ValidasiPenumpang();
        Searchable<Transportasi> pencari = new PencarianTransportasi(daftarTransportasi);
        Bookable booker = new BookingService();
        Printable printer = new CetakTiket();

        // Inject semua dependency ke Reservasi (Dependency Inversion Principle)
        Reservasi reservasi = new Reservasi(validator, pencari, booker, printer, daftarTransportasi);

        System.out.println("========================================");
        System.out.println("   Selamat Datang di JAVA EXPRESS");
        System.out.println("   Sistem Reservasi Tiket Kereta Api");
        System.out.println("========================================");

        boolean running = true;

        try {
            while (running) {
                System.out.println("\n--- MENU UTAMA ---");
                System.out.println("1. Lihat Jadwal Kereta");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");

                int pilihan;
                try {
                    pilihan = scanner.nextInt();
                    scanner.nextLine(); // bersihkan buffer
                } catch (InputMismatchException e) {
                    System.out.println("[ERROR] Input tidak valid. Masukkan angka 1-3.");
                    scanner.nextLine();
                    continue;
                }

                switch (pilihan) {
                    case 1:
                        tampilkanJadwal(reservasi);
                        break;

                    case 2:
                        prosesBoking(scanner, reservasi);
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("[INFO] Pilihan tidak tersedia. Pilih 1-3.");
                }
            }
        } finally {
            System.out.println("\n========================================");
            System.out.println("   Terima kasih telah menggunakan");
            System.out.println("   JAVA EXPRESS. Sampai jumpa!");
            System.out.println("========================================");
            scanner.close();
        }
    }

    private static void tampilkanJadwal(Reservasi reservasi) {
        System.out.println("\n========================================");
        System.out.println("          JADWAL KERETA TERSEDIA");
        System.out.println("========================================");
        System.out.println("Kode" + " | " + "Nama Kereta" + " | " + "Rute" + " | " + "Sisa Kursi");
        System.out.println("----------------------------------------------------------");
        for (Transportasi t : reservasi.getDaftarTransportasi()) {
            System.out.println(t);
        }
        System.out.println("========================================");
    }

    private static void prosesBoking(Scanner scanner, Reservasi reservasi) {
        System.out.println("\n--- PEMESANAN TIKET ---");

        System.out.print("Kode Kereta   : ");
        String kode = scanner.nextLine().trim();

        System.out.print("NIK Penumpang : ");
        String nik = scanner.nextLine().trim();

        System.out.print("Nama Penumpang: ");
        String nama = scanner.nextLine().trim();

        int jumlah;
        try {
            System.out.print("Jumlah Tiket  : ");
            jumlah = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Jumlah tiket harus berupa angka.");
            return;
        }

        if (jumlah <= 0) {
            System.out.println("[ERROR] Jumlah tiket harus lebih dari 0.");
            return;
        }

        try {
            reservasi.pesanTiket(kode, nik, nama, jumlah);
        } catch (DataPenumpangTidakValidException e) {
            System.out.println("[ERROR] Data penumpang tidak valid: " + e.getMessage());
        } catch (RuteTidakDitemukanException e) {
            System.out.println("[ERROR] Rute tidak ditemukan: " + e.getMessage());
        } catch (TiketHabisException e) {
            System.out.println("[ERROR] Tiket tidak mencukupi!");
            System.out.println("  Kereta  : " + e.getNamaKereta());
            System.out.println("  Tersisa : " + e.getSisaKursi() + " kursi");
        }
    }
}
