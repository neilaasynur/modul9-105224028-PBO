public class BukuMutasi {
    //atribut untuk menyimpan referensi nomor rek pemilik mutasi
    private String nomorRekening;
 
    //construktor untuk inisialisasi buku mutasi di awal pembuatan rekening
    public BukuMutasi(String nomorRekening) {
        this.nomorRekening = nomorRekening;
        System.out.println(" >> [BukuMutasi] Buku mutasi untuk rekening " + nomorRekening + " telah dibuat!");
    }
 
    //method untuk mencetak log aktivitas pada rekening
    public void catatAktivitas(String jenis, double jumlah, double saldoAkhir) {
        System.out.println("  >> [MUTASI | " + nomorRekening + "] " + jenis);
        System.out.println("Jumlah: Rp" + jumlah);
        System.out.println("Saldo Akhir: Rp" + saldoAkhir);
    }
 
    //method ketika buku mutasi dihancurkan
    public void dihancurkan() {
        System.out.println(" >> [BukuMutasi] Buku mutasi rekening " + nomorRekening  + " telah dihancurkan!");
    }
}
