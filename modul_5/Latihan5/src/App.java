public class App {
    public static void main(String[] args) throws Exception {           //No.4
        Karyawan staff = new Karyawan();                        //No.1
        staff.karyawan(354, "Mahiru");

        System.out.println(staff.getIdKaryawan());
        System.out.println(staff.getNamaKaryawan());

        staff.setGajiPokok(-2000000);                       //No.2
        staff.setGajiPokok(2000000);

        staff.setDepartemen("finance");     //No.3
        staff.tampilkanDataKaryawan();


    }
}
