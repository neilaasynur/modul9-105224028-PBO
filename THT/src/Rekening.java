//kelas abstrak untuk cetakan rekening. mengimplementasikan interface otorisasi
public abstract class Rekening implements Otorisasi{
    //atribut yang terenkapsulasi agar hanya dapat diakses oleh class ini sendiri atau child class
    protected String noRek;
    protected String namaPemilik;
    protected String pin;
    //atribut saldo agar  tidak dapat diubah di luar class
    private double saldo;
    //komposisi: atribut untuk menyimpan objek buku mutasi
    private BukuMutasi bukuMutasi;

    //construktor untuk awal pembukaan rekening
    public Rekening(String noRek, String namaPemilik, double setorAwal, String pin) {
        this.noRek = noRek;
        this.namaPemilik   = namaPemilik;
        this.pin           = pin;
        //objek mutasi langsung dibuat di construktor
        this.bukuMutasi    = new BukuMutasi(noRek); // Komposisi
        this.saldo         = 0;
        //memanggil setor untuk memasukkan setoran awal ke saldo
        setor(setorAwal);
    }

    //getter untuk mengakses atribut terenkapsulasi
    public double getSaldo() {
        return saldo;
    }
    public String getNoRek(){
        return noRek;
    }
    public String getNamaPemilik(){
        return namaPemilik;
    }
    //setter untuk mengatur/set nilai pada saldo
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //method untuk menambah nilai saldo pada rek
    public void setor(double jumlah) {
        //jika setoran kurang dari 0, maka akan ditolak
        if (jumlah <= 0) {
            System.out.println(" >> ERROR! Jumlah setoran tidak valid.");
            return;
        }
        //tambahkan nilai saldo dengan jumlah setoran
        saldo += jumlah;
        //catat di mutasi rekening
        bukuMutasi.catatAktivitas("SETOR", jumlah, saldo);
    }
    //method yang wajib dibuat aturan sendiri oleh child class
    public abstract void tarik(double jumlah);

    //implementasi method yang ada pada interface
    @Override
    public boolean verifikasiPin(String inputPin) {
        return this.pin.equals(inputPin);
    }
    //method untuk mencatat mutasi dari rekening
    protected void catatMutasi(String jenis, double jumlah) {
        bukuMutasi.catatAktivitas(jenis, jumlah, saldo);
    }

    //menampilkan info dari rekening
    public void tampilInfo() {
        System.out.printf("Nomor Rekening: " + noRek);
        System.out.println("Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
    }

    //method untuksimulasi menghancurkan relasi komposisi
    public void tutupRekening() {
        System.out.println(" >> [Rekening] Rekening " + noRek + " ditutup oleh sistem pusat!");
        bukuMutasi.dihancurkan();
        bukuMutasi = null; // Menghancurkan referensi agar dihapus dari memori
    }   
}
