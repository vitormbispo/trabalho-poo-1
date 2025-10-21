package trabalhopoo1.entidades;

/**
 * Classe para objetos do tipo Cliente
 */
public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String rg;
    private String cpf;

    public Cliente(String nome, String telefone, String email, String rg, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
    }
    
    public Cliente clone() {
        return new Cliente(this.nome,this.telefone,this.email,this.rg,this.cpf);
    }
    
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public String getRg() { return rg; }
    public String getCpf() { return cpf; }
    
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEmail(String email) { this.email = email; }
    public void setRg(String rg) { this.rg = rg; }
    public void setCpf(String cpf) {this.cpf = cpf; }
    
    @Override
    public String toString() {
        return String.format("Nome: %s | Telefone: %s | E-mail: %s | CPF: %s | RG: %s |",
                nome,telefone,email,cpf,rg);
    }
    
    @Override
    public boolean equals(Object obj) {
        Cliente outro = (Cliente) obj;
        return this.cpf.equals(outro.cpf);
    }
}
