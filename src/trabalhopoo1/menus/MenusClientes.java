package trabalhopoo1.menus;

import trabalhopoo1.dados.DadosClientes;
import static trabalhopoo1.dados.DadosClientes.validarCpf;
import static trabalhopoo1.dados.DadosClientes.validarEmail;
import static trabalhopoo1.dados.DadosClientes.validarRg;
import static trabalhopoo1.dados.DadosClientes.validarTelefone;
import static trabalhopoo1.menus.MenuPrincipal.lerTexto;
import trabalhopoo1.entidades.Cliente;

/**
 * Menus para operações sobre clientes
 */
public class MenusClientes {
    
    /**
     * Menu para cadastro de clientes
     */
    protected static void menuCadastroCliente() {
        System.out.println("\n=== Cadastrar cliente ===\n");
        System.out.print("Nome: -> ");
        String nome = lerTexto();
        
        System.out.print("Telefone: -> ");
        String telefone = lerTexto();
        
        while(!validarTelefone(telefone)) {
            System.out.print("Telefone: -> ");
            telefone = lerTexto();
        }
        
        System.out.print("E-mail: -> ");
        String email = lerTexto();
        
        while(!validarEmail(email)) {
            System.out.print("E-mail: -> ");
            email = lerTexto();
        }
        
        System.out.print("CPF: -> ");
        String cpf = lerTexto();
        
        while(!validarCpf(cpf)) {
            System.out.print("CPF: -> ");
            cpf = lerTexto();
        }

        System.out.print("RG: -> ");
        String rg = lerTexto();
        
        while(!validarRg(rg)) {
            System.out.print("RG: -> ");
            rg = lerTexto();
        }
        
        Cliente cliente = new Cliente(nome,telefone,email,rg,cpf);
        DadosClientes.cadastrar(cliente);
    }
    
    /**
     * Menu para a consulta de um cliente
     */
    protected static void menuConsultaCliente() {
        System.out.println("\n=== Consultar cliente ===\n");
        if(DadosClientes.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para consultar!");
            return;
        } 
        
        System.out.print("Insira o CPF do cliente a ser consultado: -> ");
        String cpf = lerTexto();
        
        if(!DadosClientes.cpfExiste(cpf)) {
            System.out.println("/!\\ Esse cliente não existe! ");
            return;
        }
        
        Cliente cliente = DadosClientes.consultar(cpf);
        
        System.out.printf("""
                          -> Cadastro encontrado:
                          %s
                          """,cliente.toString());
    }
    
    /**
     * Menu para executar a alteração de um cliente.
     */
    protected static void menuAlteracaoCliente() {
        System.out.println("\n=== Alterar cliente ===\n");
        
        if(DadosClientes.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para alterar!");
            return;
        } 
        
        System.out.print("Insira o CPF do cliente a ser alterado: -> ");
        String cpf = lerTexto();
        
        if(!DadosClientes.cpfExiste(cpf)) {
            System.out.println("/!\\ Esse cliente não existe!");
            return;
        }
        
        Cliente cliente = DadosClientes.consultar(cpf);
        System.out.println("\nEditando: "+cliente.toString()+"\n");
        System.out.println("Insira os novos dados: ");
        System.out.println("OBS: deixe o campo em branco para manter o valor original.");
        
        System.out.print("Nome: -> ");
        String novoNome = lerTexto(cliente.getNome());
        
        System.out.print("Telefone: -> ");
        String novoTelefone = lerTexto(cliente.getTelefone());
        
        while(!novoTelefone.equals(cliente.getTelefone()) && !validarTelefone(novoTelefone)) {
            System.out.print("Telefone: -> ");
            novoTelefone = lerTexto(cliente.getTelefone());
        }
        
        System.out.print("Email: -> ");
        String novoEmail = lerTexto(cliente.getEmail());
        
        while(!novoEmail.equals(cliente.getEmail()) && !validarEmail(novoEmail)) {
            System.out.print("E-mail: -> ");
            novoEmail = lerTexto(cliente.getEmail());
        }
        
        System.out.print("CPF: -> ");
        String novoCpf = lerTexto(cliente.getCpf());
        
        while(!novoCpf.equals(cliente.getCpf()) && !validarCpf(novoCpf)) {
            System.out.print("CPF: -> ");
            novoCpf = lerTexto(cliente.getCpf());
        }
        
        System.out.print("RG: -> ");
        String novoRg = lerTexto(cliente.getRg());
        
        while(!novoRg.equals(cliente.getRg()) && !validarRg(novoRg)) {
            System.out.print("RG: -> ");
            novoRg = lerTexto(cliente.getRg());
        }
        
        DadosClientes.alterar(cliente, novoNome, novoTelefone, novoEmail, novoRg, novoCpf);
        System.out.println("Dados cadastrais atualizados!");
    }
    
    /**
     * Menu para executar a remoção de um cliente.
     */
    protected static void menuRemocaoCliente() {
        System.out.println("\n=== Remover cliente ===\n");
        
        if(DadosClientes.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para remover!");
            return;
        } 
        
        System.out.print("Insira o CPF do cliente a ser removido: -> ");
        String cpf = lerTexto();
        
        if(!DadosClientes.cpfExiste(cpf)) {
            System.out.println("/!\\ Esse cliente não existe!");
            return;
        }
        
        Cliente cliente = DadosClientes.consultar(cpf);
        
        if(cliente == null) return;
        
        System.out.printf("/?\\ Deseja remover o cliente \"%s?\" (s/n) -> ",cliente.getNome());
        String entrada = lerTexto();
        
        if(entrada.equalsIgnoreCase("s"))
           DadosClientes.remover(cliente);
        else 
            System.out.println("Operação cancelada.");
    }
}
