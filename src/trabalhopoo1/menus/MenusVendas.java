package trabalhopoo1.menus;

import java.time.LocalDate;
import java.util.ArrayList;
import trabalhopoo1.dados.DadosClientes;
import trabalhopoo1.dados.DadosFuncionarios;
import trabalhopoo1.dados.DadosVeiculos;
import trabalhopoo1.dados.DadosVendas;
import trabalhopoo1.entidades.Cliente;
import trabalhopoo1.entidades.Funcionario;
import trabalhopoo1.entidades.Veiculo;
import trabalhopoo1.entidades.Venda;
import static trabalhopoo1.menus.MenuPrincipal.lerTexto;
import static trabalhopoo1.menus.MenuPrincipal.lerDouble;
import static trabalhopoo1.menus.MenuPrincipal.lerInteiro;
import static trabalhopoo1.menus.MenusVeiculos.escolherVeiculo;

/**
 * Menus para operações sobre vendas
 */
public class MenusVendas {
    /**
     * Menu para cadastro de venda
     */
    protected static void menuCadastroVenda() {
        System.out.println("\n=== Cadastrar venda ===\n");
        
        if(DadosClientes.semCadastros()) {
            System.out.println("/!\\ Nenhum cliente cadastrado! Não é possível cadastrar uma venda.");
            return;
        }
        
        if(DadosFuncionarios.semCadastros()) {
            System.out.println("/!\\ Nenhum funcionário cadastrado! Não é possível cadastrar uma venda.");
            return;
        }
        
        if(DadosVeiculos.semCadastros()) {
            System.out.println("/!\\ Nenhum veículo cadastrado! Não é possível cadastrar uma venda.");
            return;
        }
        
        System.out.print("CPF do cliente: -> ");
        String cpfCliente = lerTexto();
        
        while(!DadosClientes.cpfExiste(cpfCliente)) {
            System.out.println("/!\\ Cliente não encontrado! Tente novamente");
            System.out.println("/?\\ Digite \"cancelar\" para cancelar a venda.");
            System.out.print("CPF do cliente: -> ");
            cpfCliente = lerTexto();
            if(!DadosClientes.cpfExiste(cpfCliente) && cpfCliente.equalsIgnoreCase("cancelar")) {
                System.out.println("Cancelando venda...");
                return;
            }
        }
        
        System.out.print("Número de matrícula do funcionário: -> ");
        int matriculaFuncionario = lerInteiro(0, Integer.MAX_VALUE);
        
        while (!DadosFuncionarios.matriculaExiste(matriculaFuncionario)) {
            System.out.println("/!\\ Funcionário não encontrado! Tente novamente.");
            System.out.println("/?\\ Digite \"cancelar\" para cancelar a venda.");
            System.out.print("Número de matrícula do funcionário: -> ");
            
            String entrada = lerTexto();
            
            if(entrada.equalsIgnoreCase("cancelar")) {
                System.out.println("Cancelando venda...");
                return;
            }
            
            try {
                matriculaFuncionario = Integer.parseInt(entrada);
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Entrada inválida!");
            }
        }
              
        System.out.print("Nome do veículo: -> ");
        String nomeVeiculo = lerTexto();
        
        while (!DadosVeiculos.veiculoExiste(nomeVeiculo)) {
            System.out.println("/!\\ Veículo não encontrado! Tente novamente");
            System.out.println("/?\\ Digite \"cancelar\" para cancelar a venda.");
            System.out.print("Nome do veículo: -> ");
            nomeVeiculo = lerTexto();

            if(!DadosVeiculos.veiculoExiste(nomeVeiculo) && cpfCliente.equalsIgnoreCase("cancelar")) {
                System.out.println("Cancelando venda...");
                return;
            }
        }
        Veiculo veiculo = escolherVeiculo(nomeVeiculo);
        
        System.out.print("Valor da venda: -> ");
        double valor = lerDouble(0.0, Double.MAX_VALUE);
        
        Cliente cliente = DadosClientes.consultar(cpfCliente);
        Funcionario funcionario = DadosFuncionarios.consultar(matriculaFuncionario);

        Venda venda = new Venda(java.time.LocalDate.now(), valor, cliente, funcionario, veiculo);
        DadosVendas.cadastrar(venda);
        
    }
    
    /**
     * Menu para a consulta de uma venda
     */
    protected static void menuConsultaVenda() {
        System.out.println("\n=== Consultar venda ===\n");
        
        if(DadosVendas.semCadastros()) {
            System.out.println("-- Nenhuma venda cadastrada --");
            return;
        }
        
        System.out.print("CPF do cliente da venda: -> ");
        String cpfCliente = lerTexto();
        
        if(!DadosVendas.clientePossuiVenda(cpfCliente)) {
            System.out.println("-- Esse cliente não tem vendas registradas --");
            return;
        }
        
        System.out.print("Nome do veículo da venda: -> ");
        String nomeVeiculo = lerTexto();
        
        if(!DadosVendas.veiculoPossuiVenda(nomeVeiculo)) {
            System.out.println("-- Esse veículo não tem vendas cadastradas --");
            return;
        }
        
        ArrayList<Venda> vendas = DadosVendas.consultar(cpfCliente, nomeVeiculo);
        
        if(vendas.isEmpty()) return;
        
        System.out.printf("\n-> Venda(s) encontrada(s):\n");
        for(Venda venda : vendas) {
            System.out.println(venda.toString());
        }
    }
    
    /**
     * Menu para executar a alteração de uma venda.
     */
    protected static void menuAlteracaoVenda() {
        System.out.println("\n=== Alterar venda ===\n");
        
        if(DadosVendas.semCadastros()) {
            System.out.println("-- Nenhuma venda cadastrada --");
            return;
        }
        
        System.out.print("CPF do cliente da venda: -> ");
        String cpfCliente = lerTexto();
        
        if(!DadosVendas.clientePossuiVenda(cpfCliente)) {
            System.out.println("/!\\ Esse cliente não possui vendas!");
            return;
        }
        
        System.out.print("Nome do veículo da venda: -> ");
        String nomeVeiculo = lerTexto();
        
        if(!DadosVendas.veiculoPossuiVenda(nomeVeiculo)) {
            System.out.println("/!\\ Esse veículo não possui vendas!");
            return;
        }
        
        ArrayList<Venda> vendas = DadosVendas.consultar(cpfCliente, nomeVeiculo);
        if(vendas.isEmpty()) return;
        
        Venda venda = escolherVenda(vendas);
       
        System.out.println("\nEditando: "+venda.toString()+"\n");
        System.out.println("Insira os novos dados: ");
        System.out.println("/?\\ OBS: deixe o campo em branco para manter o valor original.");
        
        System.out.print("Novo valor da venda: ");
        double novoValor = lerDouble(0,Double.MAX_VALUE,venda.getValor());
        
        System.out.print("Novo CPF do cliente: ");
        String novoCpfCliente = lerTexto(venda.getCliente().getCpf());
        
        while(!DadosClientes.cpfExiste(novoCpfCliente)) {
            System.out.println("/!\\ Esse cliente não existe! Tente novamente.");
            System.out.print("Novo CPF do cliente: ");
            novoCpfCliente = lerTexto(venda.getCliente().getCpf());
        }
        
        Cliente novoCliente = DadosClientes.consultar(novoCpfCliente);
        
        System.out.print("Nova matrícula do funcionário: ");
        int novaMatricula = lerInteiro(0,Integer.MAX_VALUE,venda.getFuncionario().getNumeroMatricula());
        
        while (!DadosFuncionarios.matriculaExiste(novaMatricula)) {
            System.out.println("/!\\ Esse funcionário não existe! Tente novamente.");
            System.out.print("Nova matrícula do funcionário: ");
            novaMatricula = lerInteiro(0,Integer.MAX_VALUE,venda.getFuncionario().getNumeroMatricula());
        }
        
        Funcionario novoFuncionario = DadosFuncionarios.consultar(novaMatricula);
        
        System.out.print("Novo nome do veículo: ");
        String novoNomeVeiculo = lerTexto(venda.getVeiculo().getNome());
        
        while(!DadosVeiculos.veiculoExiste(novoNomeVeiculo)) {
            System.out.println("/!\\ Esse veículo não existe! Tente novamente.");
            System.out.print("Novo nome do veículo: ");
            novoNomeVeiculo = lerTexto(venda.getVeiculo().getNome());
        }
        
        Veiculo novoVeiculo = escolherVeiculo(novoNomeVeiculo);
        
        LocalDate novaData = null;
        
        while(novaData == null) {
            System.out.print("Novo dia: ");
            int novoDia = lerInteiro(1,31,venda.getData().getDayOfMonth());
            System.out.print("Novo mês: ");
            int novoMes = lerInteiro(1,12,venda.getData().getMonthValue());
            System.out.print("Novo ano: ");
            int novoAno = lerInteiro(1900,Integer.MAX_VALUE,venda.getData().getYear());
            try {
                novaData = LocalDate.of(novoAno,novoMes,novoDia);
            } catch(java.time.DateTimeException e) {
                System.out.println("/!\\ Essa data não é válida!");
            }
            
        }
        
        DadosVendas.alterar(venda, novaData, novoValor, novoCliente, novoFuncionario, novoVeiculo);
        System.out.println("Venda atualizada!");
    }
    
    /**
     * Menu para executar a remoção de uma venda.
     */
    protected static void menuRemocaoVenda() {
        System.out.println("\n=== Remover venda ===\n");
        if(DadosVendas.semCadastros()) {
            System.out.println("-- Nenhuma venda cadastrada --");
            return;
        }
        
        System.out.print("CPF do cliente da venda: -> ");
        String cpfCliente = lerTexto();
        
        if(!DadosVendas.clientePossuiVenda(cpfCliente)) {
            System.out.println("/!\\ Esse cliente não possui vendas!");
            return;
        }
        
        System.out.print("Nome do veículo da venda: -> ");
        String nomeVeiculo = lerTexto();
        
        if(!DadosVendas.veiculoPossuiVenda(nomeVeiculo)) {
            System.out.println("/!\\ Esse veículo não possui vendas!");
            return;
        }
        
        ArrayList<Venda> vendas = DadosVendas.consultar(cpfCliente, nomeVeiculo);
        
        if(vendas.isEmpty()) return;
        
        Venda venda = escolherVenda(vendas);
        
        System.out.printf("/?\\ Deseja remover a venda do cliente \"%s\" e veículo \"%s\"? (s/n) -> ",venda.getCliente().getNome(), venda.getVeiculo().nomeComposto());
        String entrada = lerTexto();
        if(entrada.equalsIgnoreCase("s")) 
            DadosVendas.remover(venda);
        else 
            System.out.println("Operação cancelada.");
    }
    
    /**
     * Escolha entre as vendas encontradas em determinada lista
     * @param vendas Lista de vendas
     * @return Venda escolhida
     */
    private static Venda escolherVenda(ArrayList<Venda> vendas) {
        Venda venda = null;
        if(vendas.size() > 1) {
            for(int i = 0; i < vendas.size();i++) {
                Venda v = vendas.get(i);
                System.out.printf("%s) %s\n",i+1,v.toString());
            }
            System.out.print("\n Escolha uma venda para alterar: -> ");
            int escolha = lerInteiro(1,vendas.size())-1;
            venda = vendas.get(escolha);
        }
        else {
            venda = vendas.get(0);
        }
        return venda;
    }
}