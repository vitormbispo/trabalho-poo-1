package trabalhopoo1.dados;

import java.time.LocalDate;
import trabalhopoo1.entidades.Funcionario;
import trabalhopoo1.entidades.Venda;
import trabalhopoo1.entidades.Veiculo;
import trabalhopoo1.entidades.Cliente;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DadosVendas {
    private static final List<Venda> vendas = new ArrayList<>();

    public static void cadastrar(Venda venda) {
        vendas.add(venda);
        System.out.println("Venda cadastrada com sucesso!");
    }

    public static ArrayList<Venda> consultar(String cpfCliente, String nomeVeiculo) {
        ArrayList<Venda> encontradas = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getCliente().getCpf().equals(cpfCliente) && venda.getVeiculo().getNome().equalsIgnoreCase(nomeVeiculo)) {
                encontradas.add(venda);
            }
        }
        if(encontradas.isEmpty()) {
            System.out.println("Venda não encontrada.");
        }
        return encontradas;
    }

    public static void alterar(Venda venda, LocalDate data, double novoValor, Cliente novoCliente, Funcionario novoFuncionario, Veiculo novoVeiculo) {
        venda.setData(data);
        venda.setValor(novoValor);
        venda.setCliente(novoCliente);
        venda.setFuncionario(novoFuncionario);
        venda.setVeiculo(novoVeiculo);
        System.out.println("Venda alterada com sucesso!");
    }

    public static void remover(Venda venda) {
        vendas.remove(venda);
        System.out.println("Venda removida com sucesso!");
    }

    public static boolean semCadastros() {
        return vendas.isEmpty();
    }
    
    public static void listar() {
        System.out.println("================== Vendas ==================\n");
        if(vendas.size() == 0) {
            System.out.println("-- Nenhuma venda cadastrada --");
            return;
        }
        
        for(int i = 0; i < vendas.size(); i++) {
            System.out.printf("%s - %s\n",i+1,vendas.get(i).toString());
        }
    }
    
    public static boolean possuiVenda(Cliente cliente) {
        for(Venda venda : vendas) {
            if(venda.getCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean possuiVenda(Funcionario funcionario) {
        for(Venda venda : vendas) {
            if(venda.getFuncionario().equals(funcionario)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean possuiVenda(Veiculo veiculo) {
        for(Venda venda : vendas) {
            if(venda.getVeiculo().equals(veiculo)) {
                return true;
            }
        }
        return false;
    }
    
    public static void removerVendasAssociadas(Cliente cliente) {
        ArrayList<Venda> aDeletar = new ArrayList<>();
        for(Venda venda : vendas) {
            if(venda.getCliente().equals(cliente))
                aDeletar.add(venda);
        }
        
        for(Venda venda : aDeletar)
            vendas.remove(venda);
        
        System.out.printf("As vendas associadas ao cliente \"%s\" foram removidas.\n",cliente.getNome());
    }
    
    public static void removerVendasAssociadas(Funcionario funcionario) {
        ArrayList<Venda> aDeletar = new ArrayList<>();
        for(Venda venda : vendas) {
            if(venda.getFuncionario().equals(funcionario))
                aDeletar.add(venda);
        }
        
        for(Venda venda : aDeletar)
            vendas.remove(venda);
        
        System.out.printf("As vendas associadas ao fncionário \"%s\" foram removidas.\n",funcionario.getNome());
    }
    
    public static void removerVendasAssociadas(Veiculo veiculo) {
        ArrayList<Venda> aDeletar = new ArrayList<>();
        for(Venda venda : vendas) {
            if(venda.getVeiculo().equals(veiculo))
                aDeletar.add(venda);
        }
        
        for(Venda venda : aDeletar)
            vendas.remove(venda);
        
        System.out.printf("As vendas associadas ao veículo \"%s\" foram removidas.\n",veiculo.nomeComposto());
    }
}
