import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TarefaEvento extends Lembrete {
    protected String nome;
    protected String descricao;
    protected LocalDate data;
    protected LocalTime horaInicio;

    public void criarTarefaEvento(Class<?> tipoTarefa) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome:");
        nome = scan.nextLine();

        System.out.println("Digite a descrição:");
        descricao = scan.nextLine();

        while (true) {
            try {
                System.out.println("Digite a data (no formato dd/MM/yyyy):");
                String dataString = scan.nextLine();
                DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                data = LocalDate.parse(dataString, formatterD);
                break;
            } catch (Exception e) {
                System.out.print("Insira uma data válida!\n");
            }
        }

        while (true) {
            try {
                System.out.println("Insira a hora do início: (HH:MM) ");
                String horaI_Input = scan.nextLine();
                DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("HH:mm");
                horaInicio = LocalTime.parse(horaI_Input, formatterT);
                break;
            } catch (Exception e) {
                System.out.print("Insira um horário válido!\n");
            }
        }
    }


//----------------------------------------------------------------------------------------------------------------------
    public void criarLembrete() {
        String resposta;
        Scanner scan = new Scanner(System.in);

        System.out.print("Insira um nome para o lembrete: ");
        setMensagem(scan.nextLine());

        while (true) {
            try {
                System.out.println("Insira uma data para receber uma notificação: (DD/MM/AAAA) ");
                String dataInput = scan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                data = LocalDate.parse(dataInput, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Informe uma data válida!\n");
            }
        }

        while (true) {
            try {
                System.out.println("Insira um horário: (HH:MM) ");
                String horaI_Input = scan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                horaInicio = LocalTime.parse(horaI_Input, formatter);
                break;
            } catch (Exception e) {
                System.out.print("Insira um horário válido!\n");
            }
        }

        System.out.println("Esse lembrete se repete? (S/N)");
        resposta = scan.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            setRepete(true);
        }
    }
}


