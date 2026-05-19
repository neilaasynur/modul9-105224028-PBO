public class RumahSakit {
    // public String alamat;
    private final Ruangan[] daftarRuangan;

    public RumahSakit(){
        this.daftarRuangan = new Ruangan[2];
        this.daftarRuangan[0] = new Ruangan ("R-01", 5);
        this.daftarRuangan[1] = new Ruangan("R-02", 5);
    }

    public void daftarRuang(){
        for (Ruangan list : daftarRuangan) {
            if (list != null){
                System.out.println("Ruangan: " + list.nomorRegis);
                System.out.println("Kapasitas Maksimal: " + list.kapasitas + " pasien");
            }
        }
    }
}
