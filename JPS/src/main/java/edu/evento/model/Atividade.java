package edu.evento.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "atividade")
@Entity(name = "atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private String data;
    @ManyToMany(mappedBy = "atividades", cascade = CascadeType.ALL)
    @JoinTable(name = "atividade_participante", joinColumns = @JoinColumn(name = "atividade_id"), inverseJoinColumns = @JoinColumn(name = "participante_id")) // interagindo com uma tabela intermediária
    private List<Participante> participantes;
}
