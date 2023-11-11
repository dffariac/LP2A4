// AtividadeDAO.java
package DAO;

import model.Atividade;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AtividadeDAO {
    private final Session session;

    public AtividadeDAO(Session session) {
        this.session = session;
    }

    public Atividade findById(int atividadeId) {
        return session.get(Atividade.class, atividadeId);
    }

    public void realizarInscricao(User user, Atividade atividade) {
        Transaction transaction = session.beginTransaction();
        atividade.realizarInscricao(user);
        // Salvar a atividade após realizar a inscrição
        session.saveOrUpdate(atividade);
        transaction.commit();
    }

    // Outros métodos para listar atividades, criar atividades, etc.
}
