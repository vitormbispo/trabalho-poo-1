package trabalhopoo1.dados;

import trabalhopoo1.entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class DadosFuncionarios {
    private static final List<Funcionario> funcionarios = new ArrayList<>();

    public static void cadastrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public static Funcionario consultar(int matricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNumeroMatricula() == matricula) {
                return funcionario;
            }
        }
        System.out.println("Funcionário não encontrado.");
        return null;
    }

    public static void alterar(Funcionario funcionario, String novoNome, String novaQualificacao, String novaDescricaoFuncao, int novaCargaHoraria) {
        funcionario.setNome(novoNome);
        funcionario.setQualificacao(novaQualificacao);
        funcionario.setDescFuncao(novaDescricaoFuncao);
        funcionario.setCargaHoraria(novaCargaHoraria);
        System.out.println("Funcionário alterado com sucesso!");
    }

    public static void remover(Funcionario funcionario) {
        funcionarios.remove(funcionario);
        System.out.println("Funcionário removido com sucesso!");
    }

    public static boolean semCadastros() {
        return funcionarios.isEmpty();
    }
    
    public static void listar() {
        System.out.println("================== Funcionários ==================\n");
        if(funcionarios.size() == 0) {
            System.out.println("-- Nenhum funcionário cadastrado --");
            return;
        }
        
        for(int i = 0; i < funcionarios.size(); i++) {
            System.out.printf("%s - %s\n",i+1,funcionarios.get(i).toString());
        }
    }
    
    public static boolean matriculaExiste(int matricula) {
        for(Funcionario funcionario : funcionarios) {
            if(funcionario.getNumeroMatricula() == matricula)
                return true;
        }
        return false;
    }
}
