public class Mahasiswa {
    private String Nama;
    private String NIM;
    private String Jurusan;

    public Mahasiswa(String Nama, String NIM, String Jurusan){
        this.Nama = Nama;
        this.NIM = NIM;
        this.Jurusan = Jurusan;
    }

    public String getNama (){
        return Nama;
    }

    public String getNIM (){
        return NIM;
    }

    public String getJurusan (){
        return Jurusan;
    }

    public void setNama (String Nama){
        this.Nama = Nama;
    }

    public void setNIM (String NIM){
        this.NIM = NIM;
    }

    public void setJurusan (String Jurusan){
        this.Jurusan = Jurusan;
    }

    public void TampilkanMahasiswa(){
        System.out.println("Nama: " + Nama);
        System.out.println("NIM: " + NIM);
        System.out.println("Jurusan: " + Jurusan);
    }
}




