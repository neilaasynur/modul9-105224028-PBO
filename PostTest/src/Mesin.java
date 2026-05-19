public class Mesin {
    public String nomorSeri;
    public int kapasitasCc;

    public Mesin (String nomorSeri, int kapasitasCc){
        this.nomorSeri = nomorSeri;
        this.kapasitasCc = kapasitasCc;
    }

    public void tampilkanDetail(){
        System.out.println("Nomor seri mesin: " + nomorSeri);
        System.out.println("Kapasitas CC: " + kapasitasCc);
    }
}
