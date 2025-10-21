package trabalhopoo1.menus;

import trabalhopoo1.dados.DadosFuncionarios;
import trabalhopoo1.entidades.Funcionario;
import static trabalhopoo1.menus.MenuPrincipal.lerInteiro;
import static trabalhopoo1.menus.MenuPrincipal.lerTexto;

/**
 * Menus de operações sobre funcionários
 */
public class MenusFuncionarios {
    /**
     * Menu para cadastro de funcionário
     */
    protected static void menuCadastroFuncionario() {
        System.out.println("\n=== Cadastrar funcionário ===\n");
        System.out.print("Nome: -> ");
        String nome = lerTexto();
        
        System.out.print("Número de matrícula: -> ");
        int matricula = lerInteiro(0, Integer.MAX_VALUE);
        
        while(DadosFuncionarios.matriculaExiste(matricula)) {
            System.out.print("/!\\ Essa matrícula já existe! Tente novamente -> ");
            matricula = lerInteiro(0, Integer.MAX_VALUE);
        }
        
        System.out.print("Qualificação: -> ");
        String qualificacao = lerTexto();
        
        System.out.print("Descrição da função: -> ");
        String descricaoFuncao = lerTexto();
        
        System.out.print("Carga horária semanal (1-44): -> ");
        int cargaHoraria = lerInteiro(1, 44);
        
        Funcionario funcionario = new Funcionario(nome, matricula, qualificacao, descricaoFuncao, cargaHoraria);
        DadosFuncionarios.cadastrar(funcionario);
    }
    
    /**
     * Menu para a consulta de um funcionário
     */
    protected static void menuConsultaFuncionario() {
        System.out.println("\n=== Consultar funcionário ===\n");
        
        if(DadosFuncionarios.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para consultar!");
            return;
        } 
        
        System.out.print("Insira o número de matrícula do funcionário a ser consultado: -> ");
        int matricula = lerInteiro(0, Integer.MAX_VALUE);
        
        if(!DadosFuncionarios.matriculaExiste(matricula)) {
            System.out.println("/!\\ Esse funcionário não existe!");
            return;
        }
        
        Funcionario funcionario = DadosFuncionarios.consultar(matricula);
        
        System.out.printf("""
                          -> Cadastro encontrado:
                          %s
                          """,funcionario.toString());
    }
    
    /**
     * Menu para executar a alteração de um funcionário.
     */
    protected static void menuAlteracaoFuncionario() {
        System.out.println("\n=== Alterar funcionário ===\n");
        
        if(DadosFuncionarios.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para alterar!");
            return;
        }
        
        System.out.print("Insira o número de matrícula do funcionário a ser alterado: -> ");
        int matricula = lerInteiro(0, Integer.MAX_VALUE);
        
        if(!DadosFuncionarios.matriculaExiste(matricula)) {
            System.out.println("/!\\ Esse funcionário não existe!");
            return;
        }
        
        Funcionario funcionario = DadosFuncionarios.consultar(matricula);
        
        System.out.println("\nEditando: "+funcionario.toString()+"\n");
        System.out.println("Insira os novos dados: ");
        System.out.println("OBS: deixe o campo em branco para manter o valor original.");
        
        System.out.print("Nome: -> ");
        String novoNome = lerTexto(funcionario.getNome());
        
        System.out.print("Qualificação: -> ");
        String novaQualificacao = lerTexto(funcionario.getQualificacao());
        
        System.out.print("Descrição da função: -> ");
        String novaDescricaoFuncao = lerTexto(funcionario.getDescFuncao());
        
        System.out.print("Carga horária semanal (1-44): -> ");
        int novaCargaHoraria = lerInteiro(1,44,funcionario.getCargaHoraria());
        
        DadosFuncionarios.alterar(funcionario, novoNome, novaQualificacao, novaDescricaoFuncao, novaCargaHoraria);
    }
    
    /**
     * Menu para executar a remoção de um funcionário.
     */
    protected static void menuRemocaoFuncionario() {
        System.out.println("\n=== Remover funcionário ===\n");
        
        if(DadosFuncionarios.semCadastros()) {
            System.out.println("/!\\ Nenhum cadastro para remover!");
            return;
        }
        
        System.out.print("Insira o número de matrícula do funcionário a ser removido: -> ");
        int matricula = lerInteiro(0, Integer.MAX_VALUE);
        
        if(!DadosFuncionarios.matriculaExiste(matricula)) {
            System.out.println("/!\\ Esse funcionário não existe!");
            return;
        }
        
        Funcionario funcionario = DadosFuncionarios.consultar(matricula);
        
        System.out.printf("/?\\ Deseja remover o funcionário \"%s\"? (s/n) -> ",funcionario.getNome());
        String entrada = lerTexto();
        if(entrada.equalsIgnoreCase("s")) {
            DadosFuncionarios.remover(funcionario);
        } 
        else 
            System.out.println("Operação cancelada.");
    }
}
