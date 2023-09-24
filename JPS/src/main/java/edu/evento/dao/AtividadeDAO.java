package edu.evento.dao;

import edu.evento.model.Atividade;
import edu.evento.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class AtividadeDAO {
    private Session session;

    public AtividadeDAO(Session session) {
        this.session = session;
    }
    public void salvarAtividade(Atividade atividade) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(atividade);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void atualizarAtividade(Atividade atividade) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(atividade);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void excluirAtividade(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Atividade atividade = session.get(Atividade.class, id);
            if (atividade != null) {
                session.delete(atividade);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Atividade getById(Long id) {
        return session.get(Atividade.class, id);
    }

    public List<Atividade> listarAtividade() {
        return session.createQuery("FROM Atividade", Atividade.class).list();
    }
}

