package trabalhopoo1.menus;

import java.util.Scanner;

import trabalhopoo1.dados.DadosClientes;
import trabalhopoo1.dados.DadosFuncionarios;
import trabalhopoo1.dados.DadosVeiculos;
import trabalhopoo1.dados.DadosVendas;

import static trabalhopoo1.menus.MenusClientes.*;
import static trabalhopoo1.menus.MenusFuncionarios.*;
import static trabalhopoo1.menus.MenusVeiculos.*;
import static trabalhopoo1.menus.MenusVendas.*;

/**
 * Classe para a exibição de menus.
 * Utiliza apenas métodos estáticos.
 */
public class MenuPrincipal {
    protected static Scanner scanner = new Scanner(System.in);
    
    /**
     * Menu de operações principais.
     */
    public static void menuPrincipal() {
        while(true) {
            System.out.printf("""
                              \n
                              ======================== CONCESSIONÁRIA ========================
                              
                              -- Clientes --
                              1) Cadastrar cliente
                              2) Consultar cliente
                              3) Alterar cliente
                              4) Remover cliente
                              
                              -- Funcionários --
                              5) Cadastrar funcionário
                              6) Consultar funcionário
                              7) Alterar funcionário
                              8) Remover funcionário
                              
                              -- Veículos --
                              9) Cadastrar veículo
                              10) Consultar veículo
                              11) Alterar veículo
                              12) Remover veículo
                              
                              -- Vendas --
                              13) Cadastrar venda
                              14) Consultar venda
                              15) Alterar venda
                              16) Remover venda
                              
                              -- Relatórios --
                              17) Relatório de clientes
                              18) Relatório de funcionários
                              19) Relatório de veículos
                              20) Relatório de vendas
                              21) Sair
                              """);
            System.out.print("Escolha uma opção (1-21): -> ");
            int entrada = lerInteiro(1, 21);
            
            switch(entrada) {
                case 1 -> { menuCadastroCliente(); pausa(); }
                case 2 -> { menuConsultaCliente(); pausa(); }
                case 3 -> { menuAlteracaoCliente(); pausa(); }
                case 4 -> { menuRemocaoCliente(); pausa(); }
                
                case 5 -> { menuCadastroFuncionario(); pausa(); }
                case 6 -> { menuConsultaFuncionario(); pausa(); }
                case 7 -> { menuAlteracaoFuncionario(); pausa(); }
                case 8 -> { menuRemocaoFuncionario(); pausa(); }
                
                case 9 -> { menuCadastroVeiculo(); pausa(); }
                case 10 -> { menuConsultaVeiculo(); pausa(); }
                case 11 -> { menuAlteracaoVeiculo(); pausa(); }
                case 12 -> { menuRemocaoVeiculo(); pausa(); }
                
                case 13 -> { menuCadastroVenda(); pausa(); }
                case 14 -> { menuConsultaVenda(); pausa(); }
                case 15 -> { menuAlteracaoVenda(); pausa(); }
                case 16 -> { menuRemocaoVenda(); pausa(); }
                
                case 17 -> { DadosClientes.listar(); pausa(); }
                case 18 -> { DadosFuncionarios.listar(); pausa(); }
                case 19 -> { DadosVeiculos.listar(); pausa(); }
                case 20 -> { DadosVendas.listar(); pausa(); }
                case 21 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
            }
        }
    }
    
    /**
     * Lê uma entrada de texto do usuário
     * @return Texto inserido pelo usuário
     */
    protected static String lerTexto() {
        return scanner.nextLine();
    }
    
    /**
     * Lê uma entrad de texto do usuário com um valor padrão
     * @param padrao Valor padrão
     * @return Texto inserido pelo usuário
     */
    protected static String lerTexto(String padrao) {
        String entrada = scanner.nextLine();
        if(entrada.isEmpty())
            return padrao;
        return entrada;
    }
    
    /**
     * Colhe uma entrada de um número inteiro do usuário
     * @return Um número inteiro escolhido pelo usuário
     */
    protected static int lerInteiro() {
        int escolhido = scanner.nextInt();
        scanner.nextLine();
        return escolhido;
    }
    /**
     * Colhe uma entrada numérica do usuário dentro de determinado intervalo.
     * @param min Valor mínimo do intervalo
     * @param max Valor máximo do intervalo
     * @return Um número inteiro escolhido pelo usuário
     */
    protected static int lerInteiro(int min, int max) {
        int escolhido = -1;
        do {
            try {
                escolhido = scanner.nextInt(); 
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.print("/!\\ Por favor, insira um número inteiro -> ");
                scanner.nextLine(); // Limpa o buffer
                continue;
            }
            if(escolhido < min || escolhido > max) {
                System.out.print("/!\\ Entrada inválida! Tente novamente -> ");
            }
        } while(escolhido < min || escolhido > max);
        
        return escolhido;
    }
    
    /**
     * Colhe uma entrada numérica do usuário dentro de determinado intervalo com uma entrada padrão.
     * @param min Valor mínimo do intervalo
     * @param max Valor máximo do intervalo
     * @param padrao Valor padrão
     * @return Um número inteiro escolhido pelo usuário
     */
    protected static int lerInteiro(int min,int max, int padrao) {
        int escolhido = padrao;
        
        do {
            String entrada = scanner.nextLine();
            if(entrada.isEmpty())
                break;
            
            try {
                escolhido = Integer.parseInt(entrada);
            }
            catch (java.lang.NumberFormatException e) {
                System.out.print("/!\\ Digite um número inteiro! -> ");
                scanner.nextLine(); // Limpa o buffer
                continue;
            }
            
            if(escolhido < min || escolhido > max) {
                System.out.print("/!\\ Entrada inválida! Tente novamente -> ");
            }
        } while(escolhido < min || escolhido > max);
        
        return escolhido;
    }
    
    /**
     * Colhe uma entrada numérica (double) do usuário dentro de determinado intervalo com um valor padrão caso nenhum valor seja inserido.
     * @param min Valor mínimo do intervalo
     * @param max Valor máximo do intervalo
     * @param padrao Valor padrão
     * @return Um número double escolhido pelo usuário
     */
    protected static double lerDouble(double min, double max) {
        double entrada = -1.0;
        do {
            try {
                entrada = scanner.nextDouble();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.print("/!\\ Entrada inválida! Por favor, insira um número -> ");
                scanner.nextLine(); // Limpa o buffer
                continue;
            }
            if(entrada < min || entrada > max) {
                System.out.print("/!\\ Entrada inválida! Tente novamente -> ");
            }
        } while(entrada < min || entrada > max);
        
        return entrada;
    }
    
    /**
     * Colhe uma entrada numérica (double) do usuário dentro de determinado intervalo com um valor padrão caso nenhum valor seja inserido.
     * @param min Valor mínimo do intervalo
     * @param max Valor máximo do intervalo
     * @param padrao Valor padrão
     * @return Um número double escolhido pelo usuário
     */
    protected static double lerDouble(double min, double max, double padrao) {
        double escolhido = padrao;
        
        do {
            String entrada = scanner.nextLine();
            if(entrada.isEmpty())
                break;
            
            try {
                escolhido = Double.parseDouble(entrada);
            }
            catch (java.lang.NumberFormatException e) {
                System.out.print("/!\\ Digite um número inteiro! -> ");
                scanner.nextLine(); // Limpa o buffer
                continue;
            }
            
            if(escolhido < min || escolhido > max) {
                System.out.print("/!\\ Entrada inválida! Tente novamente -> ");
            }
        } while(escolhido < min || escolhido > max);
        
        return escolhido;
    }
    
    protected static void pausa() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}
