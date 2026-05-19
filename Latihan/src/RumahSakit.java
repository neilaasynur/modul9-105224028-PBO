import java.util.ArrayList;

public class RumahSakit {
    private final Ruangan[] daftarRuangan;
    ArrayList<Dokter> daftarDokter = new ArrayList<>();

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
    
    public void tambahDokter(Dokter dr){
        this.daftarDokter.add(dr);
    }

    public void infoDokter(){
        for(int i = 0; i < daftarDokter.size(); i++){
            System.out.println(daftarDokter.get(i).namaDokter + " adalah dokter spesialis " + daftarDokter.get(i).getSpesialis());
        }
    }
}
