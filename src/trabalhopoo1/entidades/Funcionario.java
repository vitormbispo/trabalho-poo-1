package trabalhopoo1.entidades;

/**
 * Classe para objetos do tipo Funcionario
 * @author Vitor Bispo
 */
public class Funcionario {
    private String nome;
    private final int numeroMatricula;
    private String qualificacao;
    private String descFuncao;
    private int cargaHoraria;

    public Funcionario(String nome, int numeroMatricula, String qualificacao, String descFuncao, int cargaHoraria) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.qualificacao = qualificacao;
        this.descFuncao = descFuncao;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() { return nome; }
    public int getNumeroMatricula() { return numeroMatricula; }
    public String getQualificacao() { return qualificacao; }
    public String getDescFuncao() { return descFuncao; }

    public void setNome(String nome) { this.nome = nome; }
    public void setQualificacao(String qualificacao) { this.qualificacao = qualificacao; }
    public void setDescFuncao(String descFuncao) { this.descFuncao = descFuncao; }
    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    
    @Override
    public String toString() {
        return String.format("Nome: %s | Nº Matrícula: %s | Qualificação: %s | Descrição da função: %s | Carga horária semanal: %s |",nome,numeroMatricula,qualificacao,descFuncao,cargaHoraria);
    }
    
    @Override
    public boolean equals(Object obj) {
        Funcionario outro = (Funcionario) obj;
        return this.numeroMatricula == outro.numeroMatricula;
    }
}
