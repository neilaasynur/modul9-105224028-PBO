public class RekeningReguler extends Rekening{
    //atribut konstanta untuk menetapkan biaya admin
    private final double BIAYA_ADMIN = 2500.0;
 
    //construktor
    public RekeningReguler(String nomorRekening, String namaPemilik, double setorAwal, String pin) {
        //mengambil nilai atribut dari parent class
        super(nomorRekening, namaPemilik, setorAwal, pin);
    }
 
    //override method tarik dari parent dengan aturan khusus reguler
    @Override
    public void tarik(double jumlah) {
        double total = jumlah + BIAYA_ADMIN;
        //jika total yang mau ditarik melebihi dari saldo yang ada di rek
        if (total > getSaldo()) {
            //sistem akan memberikan massage bahwa transaksi gagal
            System.out.printf(" >> [GAGAL] Saldo tidak cukup untuk penarikan + biaya admin!");
            return;
        }
        //atur supaya saldo dikurang dengan total nominal tarik + biaya admin
        setSaldo(getSaldo() - total);
        //berikan massage bahwa transaksi telah selesai dilakukan
        System.out.printf(" >> [TARIK-REGULER] Berhasil. Jumlah: Rp" + jumlah);
        System.out.println("Biaya Admin: Rp" + BIAYA_ADMIN);
        System.out.println("Total: Rp" + total);
        //catat transaksi di buku mutasi
        catatMutasi("TARIK+ADMIN", total);
    }
}
