package trabalhopoo1;

import java.util.Scanner;
import static trabalhopoo1.DadosClientes.validarCpf;
import static trabalhopoo1.DadosClientes.validarEmail;
import static trabalhopoo1.DadosClientes.validarRg;
import static trabalhopoo1.DadosClientes.validarTelefone;

/**
 * Classe para a exibição de menus.
 * Utiliza apenas métodos estáticos.
 */
public class Menus {
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Menu de operações principais.
     */
    public static void menuPrincipal() {
        int entrada = 0;
        while(entrada != 6) {
            System.out.printf("""
                              \n
                              ======================== CONCESSIONÁRIA ========================

                              1) Cadastrar cliente
                              2) Consultar cliente
                              3) Alterar cliente
                              4) Remover cliente
                              5) Listar clientes
                              6) Sair
                              """);
            entrada = entradaNumerica(1,6,"Escolha uma operação");
            switch(entrada) {
                case 1 -> { menuCadastroCliente(); break; }
                case 2 -> { menuConsultaCliente(); break; }
                case 3 -> { menuAlteracaoCliente(); break; }
                case 4 -> { menuRemocaoCliente(); break; }
                case 5 -> { DadosClientes.listar(); break; }
                case 6 -> { System.out.println("Finalizando aplciação..."); break;}
            }
        }
    }
    
    /**
     * Colhe uma entrada numérica do usuário dentro de determinado intervalo.
     * @param min Valor mínimo do intervalo
     * @param max Valor máximo do intervalo
     * @param descricao Descrição da entrada
     * @return Um número inteiro escolhido pelo usuário
     */
    private static int entradaNumerica(int min, int max, String descricao) {
        int entrada = 0;
        
        do {
            System.out.printf("%s (%s-%s): -> ",descricao,min,max);
            entrada = scanner.nextInt(); scanner.nextLine();
            if(entrada < min || entrada > max) {
                System.out.println("Entrada inválida!");
            }
        } while(entrada < min || entrada > max);
        
        return entrada;
    }
    
    /**
     * Menu para cadastro de clientes
     */
    private static void menuCadastroCliente() {
        System.out.println("\n=== Cadastrar cliente ===\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        while(!validarTelefone(telefone)) {
            System.out.print("Telefone: ");
            telefone = scanner.nextLine();
        }
        
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        
        while(!validarEmail(email)) {
            System.out.print("E-mail: ");
            email = scanner.nextLine();
        }
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        while(!validarCpf(cpf)) {
            System.out.print("CPF: ");
            cpf = scanner.nextLine();
        }

        System.out.print("RG: ");
        String rg = scanner.nextLine();
        
        while(!validarRg(rg)) {
            System.out.print("RG: ");
            rg = scanner.nextLine();
        }
        
        Cliente cliente = new Cliente(nome,telefone,email,rg,cpf);
        DadosClientes.cadastrar(cliente);
    }
    
    /**
     * Menu para a consulta de um cliente
     */
    private static void menuConsultaCliente() {
        System.out.println("\n=== Consultar cliente ===\n");
        System.out.print("Insira o CPF do cliente: -> ");
        String cpf = scanner.nextLine();
        Cliente cliente = DadosClientes.consultar(cpf);
        
        if(cliente == null) return;
        
        System.out.printf("""
                          -> Cadastro encontrado:
                          %s
                          """,cliente.toString());
    }
    
    /**
     * Menu para executar a alteração de um cliente.
     */
    private static void menuAlteracaoCliente() {
        System.out.println("\n=== Alterar cliente ===\n");
        System.out.print("Insira o CPF do cliente a ser alterado: -> ");
        
        String cpf = scanner.nextLine();
        Cliente cliente = DadosClientes.consultar(cpf);
        System.out.println("\nEditando: "+cliente.toString()+"\n");
        System.out.println("Insira os novos dados: ");
        System.out.println("OBS: deixe o campo em branco para manter o valor original.");
        
        System.out.print("Nome: ");
        String novoNome = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String novoTelefone = scanner.nextLine();
        
        while(novoTelefone != "" && !validarTelefone(novoTelefone)) {
            System.out.print("Telefone: ");
            novoTelefone = scanner.nextLine();
        }
        
        System.out.print("Email: ");
        String novoEmail = scanner.nextLine();
        
        while(novoEmail != "" && !validarEmail(novoEmail)) {
            System.out.print("E-mail: ");
            novoEmail = scanner.nextLine();
        }
        
        System.out.print("CPF: ");
        String novoCpf = scanner.nextLine();
        
        while(novoCpf != "" && !validarCpf(novoCpf)) {
            System.out.print("CPF: ");
            novoCpf = scanner.nextLine();
        }
        
        System.out.print("RG: ");
        String novoRg = scanner.nextLine();
        
        while(novoRg != "" && !validarRg(novoRg)) {
            System.out.print("RG: ");
            novoRg = scanner.nextLine();
        }
        
        novoNome = novoNome.equals("") ? cliente.getNome() : novoNome;
        novoTelefone = novoTelefone.equals("") ? cliente.getTelefone() : novoTelefone;
        novoEmail = novoEmail.equals("") ? cliente.getEmail() : novoEmail;
        novoCpf = novoCpf.equals("") ? cliente.getCpf() : novoCpf;
        novoRg = novoRg.equals("") ? cliente.getRg() : novoRg;
        
        DadosClientes.alterar(cliente, novoNome, novoTelefone, novoEmail, novoRg, novoCpf);
        System.out.println("Dados cadastrais atualizados!");
    }
    
    /**
     * Menu para executar a remoção de um cliente.
     */
    private static void menuRemocaoCliente() {
        System.out.println("\n=== Remover cliente ===\n");
        System.out.print("Insira o CPF do cliente a ser removido: -> ");
        String cpf = scanner.nextLine();
        Cliente cliente = DadosClientes.consultar(cpf);
        
        if(cliente == null) return;
        
        System.out.printf("Deseja remover o cliente\"%s?\" (s/n) -> ",cliente.getNome());
        String entrada = scanner.nextLine();
        if(entrada.equalsIgnoreCase("s")) 
            DadosClientes.remover(cliente);
        else 
            System.out.println("Operação cancelada.");
    }
}
