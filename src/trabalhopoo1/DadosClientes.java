package trabalhopoo1;

import java.util.ArrayList;

public class DadosClientes {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    
    public static void cadastrar(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }
    
    public static Cliente consultar(String nome) {
        for(int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if(cliente.getNome() == nome) {
                System.out.println(cliente.toString());
                return cliente;
            }
        }
        
        System.out.println("Cliente não encontrado!");
        return null;
    }
    
    public static void alterar(Cliente cliente, String nome, String telefone, String email, String rg, String cpf) {
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setRg(rg);
        cliente.setCpf(cpf);
        System.out.println("Alteração do cliente aplicada!");
    }
    
    public static void remover(Cliente cliente) {
        if(clientes.remove(cliente)) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado!.");
        }
    }
    
    public static void listar() {
        System.out.println("================== Clientes ==================\n");
        for(int i = 0; i < clientes.size(); i++) {
            System.out.printf("%s - %s\n",i+1,clientes.get(i).toString());
        }
    }
   
}
