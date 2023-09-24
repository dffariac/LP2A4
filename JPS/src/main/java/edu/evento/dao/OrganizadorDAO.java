package edu.evento.dao;

import edu.evento.model.Organizador;
import edu.evento.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrganizadorDAO {
        private Session session;

        public OrganizadorDAO(Session session) {
            this.session = session;
        }
        public void salvarOrganizador(Organizador organizador) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(organizador);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void atualizarOrganizador(Organizador organizador) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.update(organizador);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public void excluirOrganizador(int id) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                Organizador organizador = session.get(Organizador.class, id);
                if (organizador != null) {
                    session.delete(organizador);
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

        public Organizador getById(Long id) {
            return session.get(Organizador.class, id);
        }

        public List<Organizador> listar() {
            return session.createQuery("FROM Organizador", Organizador.class).list();
        }
}
