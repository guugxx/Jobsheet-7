public class MahasiswaBerprestasi_10 {
 
    Mahasiswa_10[] listMhs;
    int idx = 0;
 
    // Konstruktor: ukuran array ditentukan saat pembuatan objek
    public MahasiswaBerprestasi_10(int ukuran) {
        listMhs = new Mahasiswa_10[ukuran];
    }
 
   
    public void tambah(Mahasiswa_10 mhs) {
        if (idx < listMhs.length) {
            listMhs[idx] = mhs;
            idx++;
        } else {
            System.out.println("Array sudah penuh!");
        }
    }
 
    
    public void tampil() {
        for (int i = 0; i < idx; i++) {
            listMhs[i].tampilInformasi();
            System.out.println("--------------------------");
        }
    }
 
  
    public int sequentialSearching(double cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].ipk == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }
 
   
    public void tampilPoisisi(double x, int pos) {
        if (pos != -1) {
            System.out.println("data mahasiswa dengan IPK :" + x
                    + "  ditemukan pada indeks " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }
 
    
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
 
    
    public int findBinarySearch(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;           // DIVIDE
 
            if (cari == listMhs[mid].ipk) {     // CONQUER: ditemukan
                return mid;
            } else if (listMhs[mid].ipk > cari) {
                return findBinarySearch(cari, left, mid - 1);
            } else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }
 
   
    public int findBinarySearchDesc(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].ipk) {
                return mid;
            } else if (listMhs[mid].ipk < cari) {
                return findBinarySearchDesc(cari, left, mid - 1);
            } else {
                return findBinarySearchDesc(cari, mid + 1, right);
            }
        }
        return -1;
    }
}