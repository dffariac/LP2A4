package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "atividades")
@Table(name = "atividades")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private Date data;
    @Column
    private String hora;
    @Column
    private String local;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "inscricoes",
            joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @Fetch(FetchMode.SELECT)
    private List<User> inscritos;

    public void realizarInscricao(User user) {
        if (inscritos == null) {
            inscritos = new ArrayList<>();
        }
        if (!inscritos.contains(user)) {
            inscritos.add(user);
        }
    }

    public Atividade(String nome, String descricao, Date data, String hora, String local, List<User> inscritos) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.inscritos = inscritos;
    }


}
