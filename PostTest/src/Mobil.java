public class Mobil {
    public String merkMobil;
    public String warna;
    public Mesin mesin;
    public Ban[] daftarBan;

    Mobil (String merkMobil, String warna, String tipeMesin, int ccMesin){
        this.merkMobil = merkMobil;
        this.warna = warna;
        this.mesin = new Mesin(tipeMesin, ccMesin);
        this.daftarBan = new Ban[4];
    }

    public void pasangBan (Ban[] bann){
        if (bann.length <= 4){
            for (int i = 0; i < bann.length; i++){
                this.daftarBan[i] = bann[i];
            }
            System.out.println("Berhasil memasang " + bann.length + " ban ke mobil");
        } else {
            System.out.println("Jumlah ban melebihi kapasitas maksimal (4)!");
        }
    }

    public void tampilkanSpesifikasi(){
        System.out.println("Merk mobil: " + merkMobil);
        System.out.println("Warna mobil: " + warna);
        mesin.tampilkanDetail();
        for (int i = 0; i < daftarBan.length; i++){
            if (daftarBan[i] != null){
                System.out.println("Ban " + (i + 1) + ": " + daftarBan[i].spesifikasi());
            } else {
                System.out.println("Ban " + (i + 1) + ": Kosong");
            }
        }
    }
}
