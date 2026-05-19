public class Main {
    public static void main(String[] args) throws Exception {
        Ban[] setBan = new Ban[4];
        setBan[0] = new Ban("Dunlop", 16);
        setBan[1] = new Ban("Dunlop", 16);
        setBan[2] = new Ban("Dunlop", 16);
        setBan[3] = new Ban("Dunlop", 16);

        Mobil mobilPrototipe = new Mobil("Toyota", "Abu-Abu", " In-line", 1500);

        mobilPrototipe.pasangBan(setBan);
        mobilPrototipe.tampilkanSpesifikasi();

        Montir montir = new Montir("M-01",  "Heyu");
        montir.lakukanQualityControl(mobilPrototipe);

        mobilPrototipe = null;
    }
}
