import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evento extends TarefaEvento {
    private String local;
    private LocalTime horaFim;
    private static List<Evento> listaEventos = new ArrayList<>();

    public Evento() {
    }


//----------------------------------------------------------------------------------------------------------------------
    public void criarEvento() {
        super.criarTarefaEvento(Evento.class);
        Scanner scan = new Scanner(System.in);
        String resposta;

        System.out.println("Digite o local:");
        local = scan.nextLine();

        while (true) {
            try {
                System.out.println("Gostaria de inserir uma hora final? (S/N)");
                resposta = scan.nextLine();

                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("Insira a hora final: (HH:MM)");
                    String horaF_Input = scan.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    horaFim = LocalTime.parse(horaF_Input, formatter);
                }
                break;
            } catch (Exception e) {
                System.out.println("Insira um horário válido!");
            }
        }

        System.out.println("Gostaria de criar um lembrete para o seu evento? (S/N)");
        resposta = scan.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            super.criarLembrete();
            System.out.println("Lembrete criado e evento salvo!");
        } else {
            System.out.println("Tudo bem! Evento salvo com sucesso :)");
        }
        listaEventos.add(this);
    }

    public static List<Evento> getListaEventos() {
        return listaEventos;
    }

//----------------------------------------------------------------------------------------------------------------------
    void consultarEventos() {
        List<Evento> listaEventos = Evento.getListaEventos();

        if (listaEventos.isEmpty()) {
            System.out.println("Não há eventos cadastrados.");
            return;
        }

        System.out.println("\n****** EVENTOS CADASTRADOS ******");

        for (int i = 0; i < listaEventos.size(); i++) {
            Evento evento = listaEventos.get(i);
            System.out.println((i + 1) + ") Evento: " + evento.getNome());
            System.out.println("   Descrição: " + evento.getDescricao());
            System.out.println("   Local: " + evento.getLocal());
            System.out.println("   Data: " + evento.getData());

            if (evento.getHoraFim() != null) {
                System.out.println("   Hora: " + evento.getHoraInicio());
            } else {
                System.out.println("   Hora: " + evento.getHoraInicio() + "-" + evento.getHoraFim());
            }
        }
    }

    void excluirEvento() {
        Scanner scan = new Scanner(System.in);
        List<Evento> listaEvento = Evento.getListaEventos();

        if (listaEventos.isEmpty()) {
            System.out.println("Não há eventos cadastradas para excluir.");
            return;
        }

        System.out.println("\n****** EXCLUSÃO DE EVENTOS ******");

        for (int i = 0; i < listaEventos.size(); i++) {
            Evento evento = listaEventos.get(i);
            System.out.println((i + 1) + ") Evento: " + evento.getNome());
            System.out.println("   Descrição: " + evento.getDescricao());
            System.out.println("   Data: " + evento.getData());
        }

        System.out.print("Digite o número da evento que deseja excluir (digite 0 para cancelar): ");
        int indiceEvento = scan.nextInt();

        if (indiceEvento == 0) {
            return;
        }

        if (indiceEvento < 1 || indiceEvento > listaEventos.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Evento eventoExcluir = listaEventos.get(indiceEvento - 1);
        listaEventos.remove(eventoExcluir);
        System.out.println("Tarefa excluída com sucesso!");
    }

// Getters & Setters-----------------------------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

}

