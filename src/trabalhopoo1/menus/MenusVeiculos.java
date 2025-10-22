
package trabalhopoo1.menus;

import java.util.ArrayList;
import trabalhopoo1.dados.DadosVeiculos;
import trabalhopoo1.entidades.Veiculo;
import static trabalhopoo1.menus.MenuPrincipal.lerInteiro;
import static trabalhopoo1.menus.MenuPrincipal.lerTexto;

/**
 * Menus para operações sobre veículos
 */
public class MenusVeiculos {
    
    /**
     * Menu para cadastro de veículo
     */
    protected static void menuCadastroVeiculo() {
        System.out.println("\n=== Cadastrar veículo ===\n");
        
        System.out.print("Nome: -> ");
        String nome = lerTexto();
        
        System.out.print("Marca: -> ");
        String marca = lerTexto();
        
        System.out.print("Ano (1900 +): -> ");
        int ano = lerInteiro(1900, Integer.MAX_VALUE);
        
        System.out.print("Cor: -> ");
        String cor = lerTexto();
        
        System.out.print("Número de marchas (1-20): -> ");
        int numMarchas = lerInteiro(1, 20);
        
        System.out.print("Número de portas (1-5): -> ");
        int numPortas = lerInteiro(1, 5);
        
        
        System.out.print("Nº Chassi: -> ");
        String chassi = lerTexto();
        
        while(DadosVeiculos.chassiExiste(chassi)) {
            System.out.println("/!\\ Esse chassi já foi cadastrado!");
            System.out.print("Nº Chassi: -> ");
            chassi = lerTexto();
        }
        
        Veiculo veiculo = new Veiculo(nome, cor, numMarchas, numPortas, marca, ano, chassi);
        DadosVeiculos.cadastrar(veiculo);
        
    }
    
    /**
     * Menu para a consulta de um veículo
     */
    protected static void menuConsultaVeiculo() {
        System.out.println("\n=== Consultar veículo ===\n");
        
        if(DadosVeiculos.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para consultar!");
            return;
        }
        
        System.out.print("Insira o nome ou chassi do veículo: -> ");
        String nome = lerTexto();
        
        if(!DadosVeiculos.veiculoExiste(nome) && !DadosVeiculos.chassiExiste(nome)) {
            System.out.println("/!\\ Esse veículo não existe!");
            return;
        }
        
        ArrayList<Veiculo> encontrados = DadosVeiculos.consultar(nome);
        
        System.out.println("-> Cadastro(s) encontrado(s):\n");
        for(int i = 0; i < encontrados.size(); i++) {
            Veiculo encontrado = encontrados.get(i);
            System.out.printf("%s) %s\n",i+1,encontrado.toString());
        }
        
    }
    
    /**
     * Menu para executar a alteração de um veículo.
     */
    protected static void menuAlteracaoVeiculo() {
        System.out.println("\n=== Alterar veículo ===\n");
        
        if(DadosVeiculos.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para alterar!");
            return;
        }
        
        System.out.print("Insira o nome ou chassi do veículo a ser alterado: -> ");
        String nome = lerTexto();
        
        if(!DadosVeiculos.veiculoExiste(nome) && !DadosVeiculos.chassiExiste(nome)) {
            System.out.println("/!\\ Esse veículo não existe!");
            return;
        }
        
        Veiculo veiculo = escolherVeiculo(nome);
        
        System.out.println("\nEditando: "+veiculo.toString()+"\n");
        System.out.println("Insira os novos dados: ");
        System.out.println("OBS: deixe o campo em branco para manter o valor original.");
        
        System.out.print("Nome: -> ");
        String novoNome = lerTexto(veiculo.getNome());
        
        System.out.print("Marca: -> ");
        String novaMarca = lerTexto(veiculo.getMarca());
        
        System.out.print("Ano: (1900 +) -> ");
        int novoAno = lerInteiro(1900,Integer.MAX_VALUE,veiculo.getAno());
        
        System.out.print("Cor: -> ");
        String novaCor = lerTexto(veiculo.getCor());
        
        System.out.print("Número de marchas: (1-20) -> ");
        int novoNumMarchas = lerInteiro(1,20,veiculo.getNumMarchas());
        
        System.out.print("Número de portas: (1-5) -> ");
        int novoNumPortas = lerInteiro(1,5,veiculo.getNumPortas());
        
        DadosVeiculos.alterar(veiculo, novoNome, novaCor, novoNumMarchas, novoNumPortas, novaMarca, novoAno);
        System.out.println("Dados cadastrais atualizados!");
        
    }
    
    /**
     * Menu para executar a remoção de um veículo.
     */
    protected static void menuRemocaoVeiculo() {
        System.out.println("\n=== Remover veículo ===\n");
        
        if(DadosVeiculos.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para remover!");
            return;
        }
        
        System.out.print("Insira o nome ou chassi do veículo a ser removido: -> ");
        String nome = lerTexto();
        
        if(!DadosVeiculos.veiculoExiste(nome) && !DadosVeiculos.chassiExiste(nome)) {
            System.out.println("/!\\ Esse veículo não existe!");
            return;
        }
        
        Veiculo veiculo = escolherVeiculo(nome);
        
        System.out.printf("/?\\ Deseja remover o veículo \"%s\"? (s/n) -> ",veiculo.nomeComposto());
        String entrada = lerTexto();
        if(entrada.equalsIgnoreCase("s"))
            DadosVeiculos.remover(veiculo);  
        else 
            System.out.println("Operação cancelada.");
        
    }
    
    /**
     * Escolha dentre as possíveis variações de um veículo com determinado nome. <br>
     * Se apenas uma variação existir, a retorna imediatamente.
     * @param nome Nome do veículo
     * @return Variação do veículo escolhida pelo usuário
     */
    protected static Veiculo escolherVeiculo(String nome) {
        ArrayList<Veiculo> encontrados = DadosVeiculos.consultar(nome);
        Veiculo veiculo = null;
                
        if(encontrados.size() > 1) {
            for(int i = 0; i < encontrados.size(); i++) {
                Veiculo encontrado = encontrados.get(i);
                System.out.printf("%s) %s\n",i+1,encontrado.toString());
            }
            System.out.print("Escolha a variação -> ");
            int escolha = lerInteiro(1,encontrados.size())-1;
            veiculo = encontrados.get(escolha);
        } else {
            veiculo = encontrados.get(0);
        }
        
        return veiculo;
    }
}
