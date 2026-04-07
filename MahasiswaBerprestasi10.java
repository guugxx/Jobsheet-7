public class MahasiswaBerprestasi10 {
 
    Mahasiswa10[] listMhs;   // array mahasiswa (ukuran dinamis)
    int idx = 0;           // indeks pengisian berikutnya
 
    // Konstruktor: ukuran array ditentukan saat pembuatan objek
    public MahasiswaBerprestasi10(int ukuran) {
        listMhs = new Mahasiswa10[ukuran];
    }
 
    // ----------------------------------------------------------------
    // Menambah objek Mahasiswa ke dalam array
    // ----------------------------------------------------------------
    public void tambah(Mahasiswa10 mhs) {
        if (idx < listMhs.length) {
            listMhs[idx] = mhs;
            idx++;
        } else {
            System.out.println("Array sudah penuh!");
        }
    }
 
    // ----------------------------------------------------------------
    // Menampilkan semua data mahasiswa
    // ----------------------------------------------------------------
    public void tampil() {
        for (int i = 0; i < idx; i++) {
            listMhs[i].tampilInformasi();
            System.out.println("--------------------------");
        }
    }
 
    // ----------------------------------------------------------------
    // SEQUENTIAL SEARCH  –  mencari berdasarkan IPK
    // Mengembalikan indeks pertama yang cocok, atau -1 jika tidak ada
    // ----------------------------------------------------------------
    public int sequentialSearching(double cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].ipk == cari) {
                posisi = j;
                break;          // berhenti di temuan pertama
            }
        }
        return posisi;
    }
 
    // ----------------------------------------------------------------
    // Menampilkan posisi / indeks hasil pencarian
    // ----------------------------------------------------------------
    public void tampilPoisisi(double x, int pos) {
        if (pos != -1) {
            System.out.println("data mahasiswa dengan IPK :" + x
                    + "  ditemukan pada indeks " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }
 
    // ----------------------------------------------------------------
    // Menampilkan detail data mahasiswa hasil pencarian
    // ----------------------------------------------------------------
    public void tampilDataSearch(double x, int pos) {
        if (pos != -1) {
            System.out.println("nim\t : " + listMhs[pos].nim);
            System.out.println("nama\t : " + listMhs[pos].nama);
            System.out.println("kelas\t : " + listMhs[pos].kelas);
            System.out.println("ipk\t : " + x);
        } else {
            System.out.println("Data mahasiswa dengan IPK " + x + " tidak ditemukan");
        }
    }
 
    // ----------------------------------------------------------------
    // BINARY SEARCH  –  rekursif, data HARUS sudah terurut ascending
    // Mengembalikan indeks elemen yang cocok, atau -1 jika tidak ada
    // ----------------------------------------------------------------
    public int findBinarySearch(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;           // DIVIDE: tentukan titik tengah
 
            if (cari == listMhs[mid].ipk) {     // CONQUER: data ditemukan
                return mid;
            } else if (listMhs[mid].ipk > cari) {
                // Cari di bagian kiri
                return findBinarySearch(cari, left, mid - 1);
            } else {
                // Cari di bagian kanan
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;  // data tidak ditemukan
    }
 
    // ----------------------------------------------------------------
    // Overload untuk Binary Search descending
    // Digunakan jika data dimasukkan dari terbesar ke terkecil
    // ----------------------------------------------------------------
    public int findBinarySearchDesc(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
 
            if (cari == listMhs[mid].ipk) {
                return mid;
            } else if (listMhs[mid].ipk < cari) {
                // Karena descending, nilai lebih besar ada di kiri
                return findBinarySearchDesc(cari, left, mid - 1);
            } else {
                return findBinarySearchDesc(cari, mid + 1, right);
            }
        }
        return -1;
    }
}