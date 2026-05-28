public class Nasabah {
    //atribut yang menyimpan identitas dari nasabah
    private String idNasabah;
    private String nama;
 
    //agregrasi: array rekening menyimpan sekumpulan objek rekening
    private Rekening[] daftarRekening;
    private int jumlahRekening;
    //batas kapasitas array
    private final int MAX_REKENING = 3;

    //construktor untuk inisialisasi data nasabah
    public Nasabah(String idNasabah, String nama) {
        this.idNasabah      = idNasabah;
        this.nama           = nama;
        this.daftarRekening = new Rekening[MAX_REKENING];
        this.jumlahRekening = 0;
    }
    
    // Getter untuk akses atribut
    public String getNama(){ 
        return nama;      
    }
    public String getIdNasabah(){ 
        return idNasabah; 
    }
    public int getJumlahRekening(){ 
        return jumlahRekening;
    }
    // Getter array rekening (untuk akses oleh Main)
    public Rekening getRekening(int index) {
        if (index >= 0 && index < jumlahRekening) return daftarRekening[index];
        return null;
    }
    
    // Menambahkan rekening ke profil nasabah
    public boolean tambahRekening(Rekening rekening) {
        if (jumlahRekening >= MAX_REKENING) {
            System.out.println(" >> [ERROR] Maksimal " + MAX_REKENING + " rekening per nasabah!");
            return false;
        }
        daftarRekening[jumlahRekening++] = rekening;
        System.out.println(" >> [Nasabah] Rekening ditambahkan ke profil " + nama);
        return true;
    }
 
    //pencarian rekening berdasarkan nomor rek
    public Rekening cariRekening(String noRek) {
        for (int i = 0; i < jumlahRekening; i++) {
            if (daftarRekening[i].getNoRek().equals(noRek)) {
                return daftarRekening[i];
            }
        }
        return null;
    }

    //asosiasi: nasabah menghubungi CS
    public void hubungiCS(CustomerService cs, String keluhan) {
        cs.terimaKeluhan(this, keluhan);
    }
 
    // Tampilkan semua rekening milik nasabah
    public void tampilSemuaRekening() {
        if (jumlahRekening == 0) {
            System.out.println("  Nasabah belum memiliki rekening.");
            return;
        }
        for (int i = 0; i < jumlahRekening; i++) {
            daftarRekening[i].tampilInfo();
        }
    }
}
