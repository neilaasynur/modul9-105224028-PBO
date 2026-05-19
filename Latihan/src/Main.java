public class Main {
    public static void main(String[] args) throws Exception {
        Dokter dr1 = new Dokter("Dr. Adi", "Dokter Umum");
        Dokter dr2 = new Dokter("Dr. Hesti", "Dokter Umum");
        Pasien pasien1 = new Pasien("Neila", 20);
        Pasien pasien2 = new Pasien("Zakia", 21);

        dr2.memeriksaPasien(pasien2);

        RumahSakit RsSehatSelalu = new RumahSakit();

        RsSehatSelalu.tambahDokter(dr1);
        RsSehatSelalu.tambahDokter(dr2);
        RsSehatSelalu.daftarRuang();
        RsSehatSelalu.infoDokter();

        RsSehatSelalu = null;
    }
}
