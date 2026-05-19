public class Ban {
    public String merk;
    public int ukuranRing;

    public Ban (String merk, int ukuranRing){
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }

    public String spesifikasi (){
        return "Merk: " + merk + ", Ukuran ring: " + ukuranRing;
    }
}
