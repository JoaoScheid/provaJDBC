public class Pet {

    private int codigo;
    private String nome;
    private boolean vivo;
    private boolean acordado;
    private int sede;
    private int fome;
    private int energia;
    private int diversao;
    private int higiene;
    private int vontadeBanheiro;

    public Pet(int codigo, String nome, boolean vivo, boolean acordado, int sede, int fome, int energia, int diversao, int higiene, int vontadeBanheiro) {
        this.codigo = codigo;
        this.nome = nome;
        this.vivo = true;
        this.acordado = true;
        this.sede = sede;
        this.fome = fome;
        this.energia = energia;
        this.diversao = diversao;
        this.higiene = higiene;
        this.vontadeBanheiro = vontadeBanheiro;
    }

    public Pet(String nome, boolean vivo, boolean acordado, int sede, int fome, int energia, int diversao, int higiene, int vontadeBanheiro) {
        this.nome = nome;
        this.vivo = vivo;
        this.acordado = acordado;
        this.sede = sede;
        this.fome = fome;
        this.energia = energia;
        this.diversao = diversao;
        this.higiene = higiene;
        this.vontadeBanheiro = vontadeBanheiro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean isAcordado() {
        return acordado;
    }

    public void setAcordado(boolean acordado) {
        this.acordado = acordado;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getDiversao() {
        return diversao;
    }

    public void setDiversao(int diversao) {
        this.diversao = diversao;
    }

    public int getHigiene() {
        return higiene;
    }

    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }

    public int getVontadeBanheiro() {
        return vontadeBanheiro;
    }

    public void setVontadeBanheiro(int vontadeBanheiro) {
        this.vontadeBanheiro = vontadeBanheiro;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", vivo=" + vivo +
                ", acordado=" + acordado +
                ", sede=" + sede +
                ", fome=" + fome +
                ", energia=" + energia +
                ", diversao=" + diversao +
                ", higiene=" + higiene +
                ", vontadeBanheiro=" + vontadeBanheiro +
                '}';
    }
}


