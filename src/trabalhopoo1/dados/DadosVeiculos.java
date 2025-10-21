package trabalhopoo1.dados;

import trabalhopoo1.entidades.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class DadosVeiculos {
    private static final List<Veiculo> veiculos = new ArrayList<>();

    public static void cadastrar(Veiculo veiculo) {
        if(veiculoExiste(veiculo)) {
            System.out.println("/!\\ Esse veículo já estava cadastrado!");
            return;
        }
        veiculos.add(veiculo);
        DadosVendas.redirecionarReferencias(veiculo, veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public static ArrayList<Veiculo> consultar(String nome) {  
        ArrayList<Veiculo> encontrados = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(veiculo);
            }
        }
        if(encontrados.isEmpty()) {
            System.out.println("Nenhum veículo encontrado.");
        }

        return encontrados;
    }

    public static void alterar(Veiculo veiculo, String novoNome, String novaCor, int novoNumMarchas, int novoNumPortas, String novaMarca, int novoAno) {
        Veiculo checagem = new Veiculo(novoNome,novaCor,novoNumMarchas,novoNumPortas,novaMarca,novoAno);
        if(veiculoExiste(checagem)) {
            System.out.println("/!\\ Esse veículo já estava cadastrado!");
            return;
        }
        veiculo.setNome(novoNome);
        veiculo.setCor(novaCor);
        veiculo.setNumMarchas(novoNumMarchas);
        veiculo.setNumPortas(novoNumPortas);
        veiculo.setMarca(novaMarca);
        veiculo.setAno(novoAno);
        DadosVendas.redirecionarReferencias(veiculo, veiculo);
    }

    public static void remover(Veiculo veiculo) {
        if(veiculos.contains(veiculo)) {
            DadosVendas.redirecionarReferencias(veiculo, veiculo.clone());
            veiculos.remove(veiculo);
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }
    
    public static void listar() {
        System.out.println("================== Veículos ==================\n");
        if(veiculos.size() == 0) {
            System.out.println("-- Nenhum veículo cadastrado --");
            return;
        }
        
        for(int i = 0; i < veiculos.size(); i++) {
            System.out.printf("%s - %s\n",i+1,veiculos.get(i).toString());
        }
    }
    
    public static boolean semCadastros() {
        return veiculos.isEmpty();
    }
    
    public static boolean veiculoExiste(Veiculo veiculo) {
        for(Veiculo v : veiculos) {
            if(veiculo.equals(v))
                return true;
        }
        return false;
    }
    
    public static boolean veiculoExiste(String nome) {
        for(Veiculo veiculo : veiculos) {
            if(veiculo.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
}
