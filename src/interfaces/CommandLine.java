package interfaces;

import CRUD.Aluno;
import CRUD.AlunoCrud;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLine {
    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        AlunoCrud alunoCrud = new AlunoCrud(); // Instancia a classe DAO para manipulação dos dados
        int idAluno = 0; // Variável para armazenar o ID do aluno

        while (true) {
            try {
                // Exibe o menu com as opções para o usuário
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Adicionar um aluno");
                System.out.println("2. Listar todos os alunos");
                System.out.println("3. Modificar um aluno");
                System.out.println("4. Remover um aluno");
                System.out.println("5. Sair");
                System.out.print("Opção: ");

                // Captura a opção escolhida pelo usuário
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer para evitar problemas

                switch (opcao) {
                    case 1:
                        // Adiciona um novo aluno
                        System.out.println("Digite o nome do aluno:");
                        String nome = scanner.nextLine(); // armazena o nome
                        System.out.println("Digite a idade do aluno:");
                        int idade = scanner.nextInt(); // armazena a idade
                         /* Utilizando a classe alunoCrud e seu método 'inserir' para atualizar os dados do aluno.
                           O método inserir recebe um objeto da classe 'Aluno' com o ID, nome e idade modificados,
                           e a classe 'AlunoCrud' gerencia a inserção dos dados no sistema,
                           garantindo que o aluno com o ID fornecido tenha suas informações inseridos.*/
                        alunoCrud.insere(new Aluno(idAluno++, nome, idade));
                        break;

                    case 2:
                        // Lista todos os alunos
                        alunoCrud.listarTodos(); // Método para listar todos os alunos
                        break;

                    case 3:
                        // Modifica um aluno
                        System.out.print("Digite o ID do aluno que deseja modificar: ");
                        int idModificar = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        System.out.print("Digite o novo nome do aluno: ");
                        String novoNome = scanner.nextLine(); // armazena o nome
                        System.out.print("Digite a nova idade do aluno: ");
                        int novaIdade = scanner.nextInt(); // armazena a idade

                        /* Utilizando a classe alunoCrud e seu método 'atualizar' para atualizar os dados do aluno.
                           O método atualizar recebe um objeto da classe 'Aluno' com o ID, nome e idade modificados,
                           e a classe 'AlunoCrud' gerencia a atualização dos dados no sistema,
                           garantindo que o aluno com o ID fornecido tenha suas informações atualizadas.*/

                        alunoCrud.atualizar(new Aluno(idModificar, novoNome, novaIdade));
                        break;

                    case 4:
                        // Remove um aluno
                        System.out.print("Digite o ID do aluno que deseja remover: ");
                        int idRemover = scanner.nextInt();
                        alunoCrud.deletar(idRemover); // Deleta o aluno pelo ID
                        break;

                    case 5:
                        // Sai do programa
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        // Caso o usuário digite uma opção inválida
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Se o usuário digitar algo errado (ex: uma letra quando se espera um número)
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }
}
