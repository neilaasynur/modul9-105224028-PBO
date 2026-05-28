public class CustomerService {
    //atribut untuk menampilkan nama dari cs
    private String namaCS;
 
    //construktor untuk inisialisasi nama cs
    public CustomerService(String namaCS) {
        this.namaCS = namaCS;
    }
 
    //asosiasi: nasabah dikirim sebagai parameter
    public void terimaKeluhan(Nasabah nasabah, String keluhan) {
        System.out.println(" \n[TIKET PENGADUAN NASABAH]");
        System.out.println("  CS Bertugas : " + namaCS);
        System.out.println("  Nasabah     : " + nasabah.getNama());
        System.out.println("  Keluhan     : " + keluhan);
        System.out.println("  Status      : Tiket telah dicatat. Tim akan menghubungi Anda segera!");
    }
}
