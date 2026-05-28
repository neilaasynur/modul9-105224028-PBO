public class RekeningPrioritas extends Rekening{
    //atribut konstanta untuk menetapkan minimal penarikan yang dapat dilakukan
    private final double PENARIKAN_MIN = 100_000.0;
 
    //construktor
    public RekeningPrioritas(String nomorRekening, String namaPemilik, double setorAwal, String pin) {
        //mengambil value atribut dari parent class
        super(nomorRekening, namaPemilik, setorAwal, pin);
    }
 
    //override method tari dengan aturan khusus rekening prioritas
    @Override
    public void tarik(double jumlah) {
        //jikan jumlah penarikan dibawah minimal penarikan
        if (jumlah < PENARIKAN_MIN) {
            //berikan massage bahwa hal tersebut tidak bisa dilakukan
            System.out.printf(" >> [GAGAL] Penarikan ditolak! Minimum penarikan adalah Rp" + PENARIKAN_MIN);
            return;
        }
        //jika penarikan lebih besar dari total saldo yang ada di rek
        if (jumlah > getSaldo()){
            //berikan jika hal ini gagal untuk dilakukan
            System.out.println(" >> [GAGAL] Saldo tidak cukup!");
            return;
        }
        //atur saldo pada rekening untuk dikurangi dengan nominal penarikan
        setSaldo(getSaldo() - jumlah);
        System.out.printf("  [TARIK-PRIORITAS] Berhasil.Jumlah: Rp" + jumlah);
        System.out.println("Biaya Admin: GRATIS");
        System.out.println("Saldo Sisa: Rp" + getSaldo());
        //catat transaksi di buku mutasi
        catatMutasi("TARIK-GRATIS", jumlah);
    }
}
