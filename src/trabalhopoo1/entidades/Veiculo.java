package trabalhopoo1.entidades;

public class Veiculo {
    private String nome;
    private String cor;
    private int numMarchas;
    private int numPortas;
    private String marca;
    private int ano;
    private final String chassi;

    public Veiculo(String nome, String cor, int numMarchas, int numPortas, String marca, int ano, String chassi) {
        this.nome = nome;
        this.cor = cor;
        this.numMarchas = numMarchas;
        this.numPortas = numPortas;
        this.marca = marca;
        this.ano = ano;
        this.chassi = chassi;
    }
    
    public Veiculo clone() {
        return new Veiculo(this.nome,this.cor,this.numMarchas,this.numPortas,this.marca,this.ano,this.chassi);
    }

    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public int getNumMarchas() { return numMarchas; }
    public int getNumPortas() { return numPortas; }
    public String getMarca() { return marca; }
    public int getAno() { return ano; }
    public String getChassi() { return chassi; };
    
    public void setNome(String nome) { this.nome = nome; }
    public void setCor(String cor) { this.cor = cor = cor; }
    public void setNumMarchas(int numMarchas) { this.numMarchas = numMarchas; }
    public void setNumPortas(int numPortas) { this.numPortas = numPortas; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setAno(int ano) { this.ano = ano; }

    public String nomeComposto() {
        return String.format("%s-%s-%s-%s",nome,cor,ano,chassi);
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s | Marca: %s | Ano: %s | Cor: %s | Marchas: %s | Portas: %s | Chassi: %s |",
                nome, marca, ano, cor, numMarchas, numPortas,chassi);
    }
    
    @Override
    public boolean equals(Object obj) {
        Veiculo outro = (Veiculo) obj;
        return (outro.getChassi().equalsIgnoreCase(this.chassi));
    }
}
