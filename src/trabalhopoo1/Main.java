/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopoo1;

import java.util.Scanner;

/**
 *
 * @author vitorbispo
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true) {
            System.out.printf("""
                              \n
                              ======================== CONCESSIONÁRIA ========================

                              1) Cadastrar cliente
                              2) Exibir clientes
                              """);
            int entrada = entradaNumerica(1,2,"Escolha uma operação");
            switch(entrada) {
                case 1 -> { menuCadastroCliente(); break; }
                case 2 -> { DadosClientes.listar(); break; }
            }
        }
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
        
        Cliente cliente = new Cliente(nome,telefone,email,cpf,rg);
        DadosClientes.cadastrar(cliente);
    }
    
    private static int entradaNumerica(int min, int max, String titulo) {
        int entrada = 0;
        
        do {
            System.out.printf("%s (%s-%s): ",titulo,min,max);
            entrada = scanner.nextInt(); scanner.nextLine();
            if(entrada < min || entrada > max) {
                System.out.println("Entrada inválida!");
            }
        } while(entrada < min || entrada > max);
        
        return entrada;
    }
}
