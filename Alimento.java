public class Alimento {

    private int codigo;
    private String nome;
    private int nutricao;

    public Alimento(int codigo, String nome, int nutricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.nutricao = nutricao;
    }

    public Alimento(String nome, int nutricao) {
        this.nome = nome;
        this.nutricao = nutricao;
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

    public int getNutricao() {
        return nutricao;
    }

    public void setNutricao(int nutricao) {
        this.nutricao = nutricao;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", nutricao='" + nutricao + '\'' +
                '}';
    }
}
