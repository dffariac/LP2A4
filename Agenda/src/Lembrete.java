import java.time.LocalDate;
import java.time.LocalTime;

public class Lembrete {
    private String mensagem;
    private LocalDate data;
    private LocalTime hora;
    private Boolean repete = false;


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate dia) {
        this.data = data;
    }

    public Boolean getRepete() {
        return repete;
    }

    public void setRepete(Boolean repete) {
        this.repete = repete;
    }

}
