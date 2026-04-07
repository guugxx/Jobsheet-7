import java.util.Scanner;
 
public class MahasiswaDemo_10 {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        // ============================================================
        // Pertanyaan 6.3.3 no.7 : jumlah mahasiswa dari keyboard
        // ============================================================
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = sc.nextInt();
        sc.nextLine(); // buang newline sisa
 
        MahasiswaBerprestasi_10 list = new MahasiswaBerprestasi_10(jumMhs);
 
        // ------------------------------------------------------------
        // Input data mahasiswa
        // ------------------------------------------------------------
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            String ip = sc.nextLine();
            double ipk = Double.parseDouble(ip);
            System.out.println("------------------------------");
            list.tambah(new Mahasiswa_10(nim, nama, kelas, ipk));
        }
 
        // Tampilkan semua data
        list.tampil();
 
        // ============================================================
        // SEQUENTIAL SEARCH
        // ============================================================
        System.out.println("----------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("----------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = sc.nextDouble();
 
        System.out.println("menggunakan sequential searching");
        int pss = list.sequentialSearching(cari);
        list.tampilPoisisi(cari, pss);
        list.tampilDataSearch(cari, pss);
 
        // ============================================================
        // BINARY SEARCH
        // ============================================================
        System.out.println("----------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("----------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari2 = sc.nextDouble();
 
        System.out.println("------------------------------");
        System.out.println("menggunakan binary search");
        System.out.println("------------------------------");
 
        // Binary search membutuhkan data terurut ascending (0 s/d jumMhs-1)
        int pss2 = list.findBinarySearch(cari2, 0, jumMhs - 1);
        list.tampilPoisisi(cari2, pss2);
        list.tampilDataSearch(cari2, pss2);
 
        sc.close();
    }
}