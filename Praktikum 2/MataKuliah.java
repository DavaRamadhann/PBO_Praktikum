public class MataKuliah {
    private String NamaMataKuliah;
    private int JumlahSKS;

    public MataKuliah (String NamaMataKuliah, int JumlahSKS){
        this.NamaMataKuliah = NamaMataKuliah;
        this.JumlahSKS = JumlahSKS;
    }

    public String getNamaMataKuliah(){
        return NamaMataKuliah;
    }

    public int getJumlahSKS(){
        return JumlahSKS;
    }

    public void setNamaMataKuliah(String NamaMataKuliah){
        this.NamaMataKuliah = NamaMataKuliah;
    }

    public void setJumlahSKS(int JumlahSKS){
        this.JumlahSKS = JumlahSKS;
    }

    public void TampilkanMataKuliah(){
        System.out.println("Nama Mata Kuliah: " + NamaMataKuliah);
        System.out.println("Jumlah SKS: " + JumlahSKS);
    }
}
