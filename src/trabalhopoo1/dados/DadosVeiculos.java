package trabalhopoo1.dados;

import trabalhopoo1.entidades.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class DadosVeiculos {
    private static final List<Veiculo> veiculos = new ArrayList<>();

    public static void cadastrar(Veiculo veiculo) {
        if(veiculoExiste(veiculo)) {
            System.out.println("/!\\ Esse veículo estava cadastrado!");
            return;
        }
        veiculos.add(veiculo);
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
        veiculo.setNome(novoNome);
        veiculo.setCor(novaCor);
        veiculo.setNumMarchas(novoNumMarchas);
        veiculo.setNumPortas(novoNumPortas);
        veiculo.setMarca(novaMarca);
        veiculo.setAno(novoAno);
        System.out.println("Veículo alterado com sucesso!");
    }

    public static void remover(Veiculo veiculo) {
        veiculos.remove(veiculo);
        System.out.println("Veículo removido com sucesso!");
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
    
    
    public static boolean validarPlaca(String placa) {
        String regexAntiga = "\\[A-Z]{3}[-]{1}[0-9]{4}";
        String regexMercosul = "\\[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}";
        return placa.matches(regexAntiga) || placa.matches(regexMercosul);
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
