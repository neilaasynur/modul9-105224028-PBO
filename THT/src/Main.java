import java.util.*;

public class Main {
    public static void main(String[] args) {
        //deklarasi scanner untuk dapat membaca inputan dari user
        Scanner scanner = new Scanner(System.in);
        //inisialisasi cs 
        CustomerService csPusat = new CustomerService("Budi");
        
        // Objek di luar nasabah biar terbukti tetap ada saat nasabah di null kan
        Rekening[] bankDataPusat = new Rekening[5]; 
        int totalRekeningGlobal = 0;

        //variabel untuk melacak status sesi yang aktif
        Nasabah nasabahAktif = null;

        boolean berjalan = true;
        while (berjalan) { //melakukan perulangan menu selama variabel 'berjalan' bernilai true
            System.out.println("\nMENU UTAMA:");
            System.out.println("1. Registrasi Profil Nasabah");
            System.out.println("2. Buka Rekening Baru (Dimasukkan ke Profil)");
            System.out.println("3. Lihat Profil & Saldo");
            System.out.println("4. Simulasi Transaksi (Setor / Tarik)");
            System.out.println("5. Hubungi Customer Service");
            System.out.println("6. Keluar & Simulasi Penghancuran Akun (Set Null)");
            System.out.print("Pilih opsi: ");
            
            int pilihan = scanner.nextInt(); 
            scanner.nextLine(); //membersihkan sisa karakter enter di memori

            switch (pilihan) {
                case 1: //blok menu 1: registrasi nasabah baru
                    System.out.print("Masukkan ID Nasabah: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Nasabah: ");
                    String nama = scanner.nextLine();
                    nasabahAktif = new Nasabah(id, nama);
                    System.out.println("Profil Nasabah Berhasil Dibuat!");
                    break;

                case 2: //blok menu 2: buka rekening baru
                    //pengecekan status login
                    if (nasabahAktif == null) { 
                        System.out.println("Silakan registrasi nasabah terlebih dahulu!");
                        break;
                    }
                    //pengecekan batasan indeks array bank data pusat
                    if (totalRekeningGlobal >= 5) {
                        System.out.println("Kapasitas bank data pusat penuh (Maks 5)!");
                        break;
                    }
                    System.out.print("Masukkan No Rekening: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Setoran Awal: Rp");
                    double saldoAwal = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Buat PIN (6 Digit): ");
                    String pin = scanner.nextLine();
                    
                    System.out.println("Pilih Jenis Rekening: \n1. Reguler \n2. Prioritas");
                    System.out.print("Pilih (1/2): ");
                    int jenis = scanner.nextInt();
                    
                    Rekening rekBaru;
                    if (jenis == 1) {
                        rekBaru = new RekeningReguler(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    } else {
                        rekBaru = new RekeningPrioritas(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    }

                    //agregasi: objek yang sama disimpan di profil nasabah dan pusat bank
                    boolean berhasilTambah = nasabahAktif.tambahRekening(rekBaru);
                    if (berhasilTambah) {
                        bankDataPusat[totalRekeningGlobal++] = rekBaru;
                    }
                    break;

                case 3: //blok menu 3: lihat profil nasabah
                    if (nasabahAktif == null) { 
                        System.out.println("Belum ada nasabah terdaftar.");
                    } else {
                        System.out.println("\n--- PROFIL NASABAH ---");
                        System.out.println("ID   : " + nasabahAktif.getIdNasabah());
                        System.out.println("Nama : " + nasabahAktif.getNama());
                        System.out.println("Daftar Rekening:");

                        boolean punyaRekening = false;
                        for (int i = 0; i < totalRekeningGlobal; i++) {
                            if (bankDataPusat[i] != null && 
                                bankDataPusat[i].getNamaPemilik().equals(nasabahAktif.getNama())) {
                                bankDataPusat[i].tampilInfo();
                                punyaRekening = true;
                            }
                        }
                        if (!punyaRekening) {
                            System.out.println("  (Belum memiliki rekening)");
                        }
                    }
                    break;

                case 4: //blok menu 4: simulasi transaksi keuangan
                    if (nasabahAktif == null) { 
                        System.out.println("Belum ada nasabah terdaftar.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Anda: ");
                    String cariNo = scanner.nextLine();
                    
                    //memanfaatkan fungsi cariRekening yang sudah ada di dalam kelas Nasabah
                    Rekening rekTarget = nasabahAktif.cariRekening(cariNo);

                    if (rekTarget == null) {
                        System.out.println("Rekening tidak ditemukan di profil Anda!");
                        break;
                    }

                    System.out.print("Masukkan PIN: ");
                    String inputPin = scanner.nextLine();

                    //memanggil proses validasi
                    if (!rekTarget.verifikasiPin(inputPin)) {
                        System.out.println("PIN Salah! Transaksi ditolak.");
                        break;
                    }

                    System.out.println("1. Setor Tunai \n2. Tarik Tunai");
                    System.out.print("Pilih aksi: ");
                    int aksi = scanner.nextInt();
                    System.out.print("Masukkan Jumlah Uang: Rp");
                    double nominal = scanner.nextDouble();

                    if (aksi == 1) {
                        rekTarget.setor(nominal);
                    } else if (aksi == 2) {
                        rekTarget.tarik(nominal);
                    }
                    break;

                case 5: //blok menu 5: hubungi customer service
                    if (nasabahAktif == null) {
                        System.out.println("Belum ada nasabah terdaftar.");
                        break;
                    }
                    System.out.print("Masukkan Keluhan Anda: ");
                    String keluhan = scanner.nextLine();
                    nasabahAktif.hubungiCS(csPusat, keluhan);
                    break;

                case 6: //blok menu 6: keluar program dan masuk ke skenario akhir
                    berjalan = false;
                    System.out.println("\nExiting program...");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        //skenario penutupan akun 
        if (nasabahAktif != null) {
            System.out.println("Menghapus objek nasabahAktif dari memori sistem...");
            nasabahAktif = null; 
            System.out.println("Variabel 'nasabahAktif' telah di-set menjadi null.");

            /* 1. BUKTI AGREGASI (Loose-Coupling Lifecycle):
            Ketika profil 'nasabahAktif' dihapus atau dihancurkan secara paksa, objek Rekening yang berada di dalamnya tidak hilang dari sistem pusat.
            Terbukti di bawah ini, variabel 'dataPusatRekening1' yang menangkap referensi objek Rekening tersebut sejak awal masih berfungsi, valid, dan dapat diakses mandiri.
            
            2. BUKTI KOMPOSISI (Strict/Strongly-Coupled Lifecycle):
            Di sisi lain, objek 'BukuMutasi' yang terbungkus di dalam 'bankDataPusat'. ketika variabel 'bankDataPusat' di set ke null, maka objek 'BukuMutasi' yang diinstansiasi di dalam constructor nya akan otomatis ikut mati dan disapu oleh Garbage Collector tanpa sisa, karena ia tidak memiliki referensi eksternal independen di luar siklus hidup objek Rekening induknya.
            */

            if (totalRekeningGlobal > 0 && bankDataPusat[0] != null) {
                // Mengambil referensi dari array agar sesuai dengan nama variabel di komentar Anda
                Rekening dataPusatRekening1 = bankDataPusat[0];

                // Pembuktian prinsip Agregasi di terminal:
                if (dataPusatRekening1 != null) {
                    System.out.println("\n[Mengeksekusi Bukti Agregasi...]");
                    System.out.println("Meskipun Profil Nasabah telah dihapus dari memori, Rekening dengan nomor: " + dataPusatRekening1.getNoRek() + " tetap eksis di bank data pusat!");
                    System.out.println("Saldo aman tersimpan di server sebesar: Rp" + (long)dataPusatRekening1.getSaldo());
                }

                // Pembuktian prinsip Komposisi di terminal (Saran tambahan agar eksekusi lengkap):
                System.out.println("\n[Mengeksekusi Bukti Komposisi...]");
                dataPusatRekening1.tutupRekening(); 
                dataPusatRekening1 = null; 
                bankDataPusat[0] = null; // Menghapus tuntas dari sistem pusat
                System.out.println("-> Rekening dihancurkan. Perhatikan log di atas bahwa BukuMutasi ikut musnah otomatis.");
            } else {
                System.out.println("-> Rekening tidak ditemukan karena Anda belum membuatnya di Menu 2.");
            }
            System.out.println("===============================================================");
            } else {
            System.out.println("Simulasi dilewati karena tidak ada data nasabah yang diregistrasi.");
        }
        scanner.close();
    }
}