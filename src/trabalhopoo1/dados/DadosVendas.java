package trabalhopoo1.dados;

import java.time.LocalDate;
import trabalhopoo1.entidades.Funcionario;
import trabalhopoo1.entidades.Venda;
import trabalhopoo1.entidades.Veiculo;
import trabalhopoo1.entidades.Cliente;
import java.util.ArrayList;
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
    
    public static boolean clientePossuiVenda(String cpfCliente) {
        for(Venda venda : vendas) {
            if(venda.getCliente().getCpf().equals(cpfCliente)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean funcionarioPossuiVenda(int matricula) {
        for(Venda venda : vendas) {
            if(venda.getFuncionario().getNumeroMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean veiculoPossuiVenda(Veiculo veiculo) {
        for(Venda venda : vendas) {
            if(venda.getVeiculo().equals(veiculo)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean veiculoPossuiVenda(String nome) {
        for(Venda venda : vendas) {
            if(venda.getVeiculo().getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Redireciona todas as referências das vendas a um determinado cliente para outro.
     * @param antigo Referência substituída
     * @param novo Nova referência
     */
    public static void redirecionarReferencias(Cliente antigo, Cliente novo) {
        ArrayList<Venda> aDeletar = new ArrayList<>();
        for(Venda venda : vendas) {
            if(venda.getCliente().equals(antigo))
                venda.setCliente(novo);
        }
    }
    
    /**
     * Redireciona todas as referências das vendas a um determinado funcionário para outro.
     * @param antigo Referência substituída
     * @param novo Nova referência
     */
    public static void redirecionarReferencias(Funcionario antigo, Funcionario novo) {
        ArrayList<Venda> aDeletar = new ArrayList<>();
        for(Venda venda : vendas) {
            if(venda.getFuncionario().equals(antigo))
                venda.setFuncionario(novo);
        }
    }
    
    /**
     * Redireciona todas as referências das vendas a um determinado veículo para outro.
     * @param antigo Referência substituída
     * @param novo Nova referência
     */
    public static void redirecionarReferencias(Veiculo antigo,Veiculo novo) {
        ArrayList<Venda> aDeletar = new ArrayList<>();
        for(Venda venda : vendas) {
            if(venda.getVeiculo().equals(antigo))
                venda.setVeiculo(novo);
        }
    }
}
