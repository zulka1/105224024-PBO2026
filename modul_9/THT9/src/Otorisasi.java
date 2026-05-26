/*
Interface Otorisasi
Mendefinisikan kontrak keamanan yang WAJIB diimplementasikan oleh setiap
entitas rekening. Ini adalah bentuk abstraksi — kita tidak peduli bagaimana
verifikasiPIN() diimplementasikan, yang penting semua rekening punya metode itu.
 */
public interface Otorisasi {
    boolean verifikasiPIN(String pinInput);     // Metode abstrak verifikasiPIN
}
