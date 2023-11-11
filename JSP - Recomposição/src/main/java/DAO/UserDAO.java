package DAO;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.User;
import org.hibernate.Session;

public class UserDAO {
    private static Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public User findByUsername(String username) {
        TypedQuery<User> query = session.createQuery("FROM users WHERE username = :username", User.class);
        query.setParameter("username", username);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }




    public User getUserById(int id) {
        return session.get(User.class, id);
    }
}

