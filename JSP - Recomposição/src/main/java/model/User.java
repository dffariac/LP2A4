package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column
        private String username;
        @Column
        private String password;
        private boolean organizador;
        @Column
        @ManyToMany(mappedBy = "inscritos")
        private List<Atividade> atividades;


        public User(String username, String password, boolean organizador, List<Atividade> atividades) {
                this.username = username;
                this.password = password;
                this.organizador = organizador;
                this.atividades = atividades;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public boolean isOrganizador() {
                return organizador;
        }

        public void setOrganizador(boolean organizador) {
                this.organizador = organizador;
        }

        public List<Atividade> getAtividades() {
                return atividades;
        }

        public void setAtividades(List<Atividade> atividades) {
                this.atividades = atividades;
        }
}
