public class Dokter {
    public String namaDokter;
    private String spesialis;
    
    public Dokter (String namaDokter, String spesialis){
        this.namaDokter = namaDokter;
        this.spesialis = spesialis;
    }

    public void memeriksaPasien (Pasien pasien){
        System.out.println(this.namaDokter + " adalah dokter spesialis " + this.spesialis + " sedang memeriksa pasien " + pasien.namaPasien + " yang berumur " + pasien.umur + "tahun");
    }

    public String getSpesialis (){
        return this.spesialis;
    }
}
