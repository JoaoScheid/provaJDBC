public class Brincadeira {

    private int codigo;
    private String nome;
    private int divertimento;
    private int energia;
    private int fome;
    private int sede;
    private int sujeira;

    public Brincadeira(int codigo, String nome, int divertimento, int energia , int fome, int sede, int sujeira) {
        this.codigo = codigo;
        this.nome = nome;
        this.divertimento = divertimento;
        this.energia = energia;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
    }

    public Brincadeira(String nome, int divertimento, int energia, int fome, int sede, int sujeira) {
        this.nome = nome;
        this.divertimento = divertimento;
        this.energia = energia;
        this.fome = fome;
        this.sede = sede;
        this.sujeira = sujeira;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
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

    public int getDivertimento() {
        return divertimento;
    }

    public void setDivertimento(int divertimento) {
        this.divertimento = divertimento;
    }



    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getSujeira() {
        return sujeira;
    }

    public void setSujeira(int sujeira) {
        this.sujeira = sujeira;
    }

    @Override
    public String toString() {
        return "Brincadeira{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", divertimento=" + divertimento +
                ", fome=" + fome +
                ", sede=" + sede +
                ", sujeira=" + sujeira +
                '}';
    }
}


