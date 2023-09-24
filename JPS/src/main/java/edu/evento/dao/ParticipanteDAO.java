package edu.evento.dao;

import edu.evento.model.Participante;
import edu.evento.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ParticipanteDAO {
        private Session session;

        public ParticipanteDAO(Session session) {
            this.session = session;
        }
        public void salvarParticipante(Participante participante) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(participante);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void atualizarParticipante(Participante participante) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.update(participante);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void excluirParticipante(int id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                Participante participante = session.get(Participante.class, id);
                if (participante != null) {
                    session.delete(participante);
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public Participante getById(Long id) {
            return session.get(Participante.class, id);
        }

        public List<Participante> listar() {
            return session.createQuery("FROM Participante", Participante.class).list();
        }
}
