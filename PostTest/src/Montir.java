public class Montir {
    public String idMontir;
    public String nama;

    public Montir(String idMontir, String nama){
        this.idMontir = idMontir;
        this.nama = nama;
    }

    public void lakukanQualityControl (Mobil mobil){
        System.out.println("Montir " + nama + " (ID: " + idMontir + ") memeriksa mobil");
    }
}
