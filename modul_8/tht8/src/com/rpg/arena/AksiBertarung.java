package com.rpg.arena;

 // Interface yang mendefinisikan kontrak aksi bertarung.
 // Setiap karakter yang bertarung WAJIB mengimplementasikan ketiga metode ini.
public interface AksiBertarung {
    int serang();           // Melakukan serangan dasar dengan @return nilai damage integer yang akan diterima lawan

    void bertahan();        // Mengaktifkan mode bertahan

    void gunakanItem();     // Menggunakan item yang efeknya beda tiap subclass
}
