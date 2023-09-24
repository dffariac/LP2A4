
import java.util.Scanner;

public class Main {

    private void menuEventos(Scanner scan) {
        Evento evento = new Evento();

        while (true) {
            System.out.print("""

                    ****** EVENTOS ******
                    1) Criar
                    2) Consultar
                    3) Excluir
                    4) Voltar para opções
                    Escolha um número:\s""");

            int resposta = scan.nextInt();

            switch (resposta) {
                case 1:
                    evento.criarEvento();
                    break;
                case 2:
                    evento.consultarEventos();
                    break;
                case 3:
                    evento.excluirEvento();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("DIGITE UM NÚMERO VÁLIDO");
            }
        }
    }

    private void menuLembretes(Scanner scan) {
        while (true) {
            System.out.print("""

                    1) Criar
                    2) Consultar
                    3) Excluir
                    4) Voltar para opções
                    Escolha um número:\s""");

            int resposta = scan.nextInt();

            switch (resposta) {
                case 1:
                   
                    break;
                case 2:
                  
                    break;
                case 3:
                 
                    break;
                case 4:
                    return;
                default:
                    System.out.println("DIGITE UM NÚMERO VÁLIDO");
            }
        }
    }

    private void menuTarefas(Scanner scan) {
        Tarefa tarefa = new Tarefa();

        while (true) {
            System.out.print("""

                    ****** TAREFAS ******
                    1) Criar
                    2) Consultar
                    3) Excluir
                    4) Voltar para opções
                    Escolha um número:\s""");

            int resposta = scan.nextInt();

            switch (resposta) {
                case 1:
                    tarefa.criarTarefa();
                    break;
                case 2:
                    tarefa.consultarTarefas();
                    break;
                case 3:
                    tarefa.excluirTarefa();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("DIGITE UM NÚMERO VÁLIDO");
            }
        }
    }

    public static void main(String[] args) {
        int resposta;
        Scanner scan = new Scanner(System.in);
        Main main = new Main();

        while (true) {
            System.out.print("""

                    ****** MENU PRINCIPAL ******
                    1) Eventos
                    2) Lembretes
                    3) Tarefas
                    4) Sair do programa
                    Escolha um número:\s""");

            resposta = scan.nextInt();

            switch (resposta) {
                case 1:
                    main.menuEventos(scan);
                    break;
                case 2:
                    main.menuLembretes(scan);
                    break;
                case 3:
                    main.menuTarefas(scan);
                    break;
                case 4:
                    scan.close();
                    return;
                default:
                    System.out.println("DIGITE UM NÚMERO VÁLIDO");
                    break;
            }
        }
    }
}

