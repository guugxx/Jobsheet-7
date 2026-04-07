public class Mahasiswa_10 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa_10() {}
 
    public Mahasiswa_10(String nm, String name, String kls, double ip) {
        this.nim   = nm;
        this.nama  = name;
        this.kelas = kls;
        this.ipk   = ip;
    }
 
    public void tampilInformasi() {
        System.out.println("Nama: "  + nama);
        System.out.println("NIM: "   + nim);
        System.out.println("Kelas: " + kelas);
        System.out.println("IPK: "   + ipk);
    }
}
 