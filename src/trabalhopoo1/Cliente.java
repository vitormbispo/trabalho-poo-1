package trabalhopoo1;

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
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s | RG: %s | CPF: %s | Telefone: %s | E-mail: %s |",nome,rg,cpf,telefone,email);
    }
    
    @Override
    public boolean equals(Object obj) {
        Cliente outro = (Cliente) obj;
        return this.cpf == outro.cpf;
    }
    
    
}
