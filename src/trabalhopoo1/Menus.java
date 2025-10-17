package trabalhopoo1;

import java.util.Scanner;

public class Menus {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void menuPrincipal() {
        int entrada = 0;
        while(entrada != 5) {
            System.out.printf("""
                              \n
                              ======================== CONCESSIONÁRIA ========================

                              1) Cadastrar cliente
                              2) Exibir clientes
                              3) Consultar cliente
                              4) Alterar cliente
                              5) Sair
                              """);
            entrada = entradaNumerica(1,5,"Escolha uma operação");
            switch(entrada) {
                case 1 -> { menuCadastroCliente(); break; }
                case 2 -> { DadosClientes.listar(); break; }
                case 3 -> { menuConsultaCliente(); break; }
                case 4 -> { menuAlteracaoCliente(); break; }
                case 5 -> { System.out.println("Finalizando aplciação..."); break;}
            }
        }
    }
    
    private static int entradaNumerica(int min, int max, String titulo) {
        int entrada = 0;
        
        do {
            System.out.printf("%s (%s-%s): -> ",titulo,min,max);
            entrada = scanner.nextInt(); scanner.nextLine();
            if(entrada < min || entrada > max) {
                System.out.println("Entrada inválida!");
            }
        } while(entrada < min || entrada > max);
        
        return entrada;
    }
    
    private static void menuCadastroCliente() {
        System.out.println("\n=== Cadastrar cliente ===\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("RG: ");
        String rg = scanner.nextLine();
        
        Cliente cliente = new Cliente(nome,telefone,email,rg,cpf);
        DadosClientes.cadastrar(cliente);
    }
    
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
        System.out.print("Email: ");
        String novoEmail = scanner.nextLine();
        System.out.print("CPF: ");
        String novoCpf = scanner.nextLine();
        System.out.print("RG: ");
        String novoRg = scanner.nextLine();
        
        novoNome = novoNome.equals("") ? cliente.getNome() : novoNome;
        novoTelefone = novoTelefone.equals("") ? cliente.getTelefone() : novoTelefone;
        novoEmail = novoEmail.equals("") ? cliente.getEmail() : novoEmail;
        novoCpf = novoCpf.equals("") ? cliente.getCpf() : novoCpf;
        novoRg = novoRg.equals("") ? cliente.getRg() : novoRg;
        
        DadosClientes.alterar(cliente, novoNome, novoTelefone, novoEmail, novoRg, novoCpf);
        System.out.println("Dados cadastrais atualizados!");
    }
}
