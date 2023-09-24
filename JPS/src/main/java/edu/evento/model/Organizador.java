package edu.evento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizador")
@Entity(name = "organizador")
public class Organizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
