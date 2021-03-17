public class Jogador {

    private String nome;
    private int pontuacao = 0;

    public Jogador(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPontuacao() {
        return pontuacao;
    }
    public void adicionaPonto() {
        this.pontuacao = this.pontuacao + 1;
    }
    @Override
    public String toString() {
        return "Jogador " + nome + " está com " + pontuacao + " pontos.";
    }
}