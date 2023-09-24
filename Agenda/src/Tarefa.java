
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarefa extends TarefaEvento {
    private boolean concluida = false;
    private static List<Tarefa> listaTarefas = new ArrayList<>();

    public Tarefa() {
    }

//----------------------------------------------------------------------------------------------------------------------

    public void criarTarefa() {
        criarTarefaEvento(Tarefa.class);
        Scanner scan = new Scanner(System.in);
        String resposta;

        try {
            System.out.println("Essa tarefa foi concluída? (S/N)");
            resposta = scan.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                concluida = true;
            } else if (resposta.equalsIgnoreCase("n")) {
                concluida = false;
            } else {
                System.out.println("Insira um valor válido!\n");
                return;
            }
        } catch (Exception e) {
            System.out.print("Insira um valor válido!\n");
            return;
        }

        System.out.println("Gostaria de criar um lembrete para o seu evento? (S/N)");
        resposta = scan.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            super.criarLembrete();
            System.out.println("Lembrete criado e evento salvo!");
        } else {
            System.out.println("Tudo bem! Evento salvo com sucesso :)");
        }

        listaTarefas.add(this);
    }

    public static List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

//----------------------------------------------------------------------------------------------------------------------
    void consultarTarefas() {
        List<Tarefa> listaTarefas = Tarefa.getListaTarefas();

        if (listaTarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas.");
            return;
        }

        System.out.println("\n****** TAREFAS CADASTRADAS ******");

        for (int i = 0; i < listaTarefas.size(); i++) {
            Tarefa tarefa = listaTarefas.get(i);
            System.out.println((i + 1) + ") Tarefa: " + tarefa.getNome());
            System.out.println("   Descrição: " + tarefa.getDescricao());
            System.out.println("   Data: " + tarefa.getData());
            System.out.println("   Hora: " + tarefa.getHoraInicio());
            System.out.println("   Concluído: " + tarefa.isConcluida() + "\n");
        }
    }

     void excluirTarefa() {
        Scanner scan = new Scanner(System.in);
        List<Tarefa> listaTarefas = Tarefa.getListaTarefas();

        if (listaTarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas para excluir.");
            return;
        }

        System.out.println("\n****** EXCLUSÃO DE TAREFAS ******");

        for (int i = 0; i < listaTarefas.size(); i++) {
            Tarefa tarefa = listaTarefas.get(i);
            System.out.println((i + 1) + ") Tarefa: " + tarefa.getNome());
            System.out.println("   Descrição: " + tarefa.getDescricao());
            System.out.println("   Concluído: " + tarefa.isConcluida() + "\n");
        }

        System.out.print("Digite o número da tarefa que deseja excluir (digite 0 para cancelar): ");
        int indiceTarefa = scan.nextInt();

        if (indiceTarefa == 0) {
            return;
        }

        if (indiceTarefa < 1 || indiceTarefa > listaTarefas.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Tarefa tarefaExcluir = listaTarefas.get(indiceTarefa - 1);
        listaTarefas.remove(tarefaExcluir);
        System.out.println("Tarefa excluída com sucesso!");
    }

// Getters & Setters-----------------------------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isConcluida() {
        return concluida;
    }


    public LocalTime getHoraInicio() {
        return horaInicio;
    }

}

