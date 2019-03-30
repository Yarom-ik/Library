package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.UsersDao;
import by.yarom.library.Entity.Role;
import by.yarom.library.Entity.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("UsersDao")
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(Users user) {
        currentSession().save(user);

    }

    @Override
    public void updateUser(Users user) {
        currentSession().update(user);
    }

    @Override
    public void deleteUser(int id) {
    }

    @Override
    public Users getUserByLogin(String login) {
        Users users = (Users) currentSession().createQuery("from Users u where u.login =:login")
                .setParameter("login",login)
                .uniqueResult();

        return users;


       // System.out.println((Users) currentSession().createQuery("from Users where id = 7").uniqueResult());
        //return (Users) userCriteria.uniqueResult();
    }

    @Override
    public List<Users> listUsers() {
        List<Users> usersList = currentSession().createQuery("from Users").list();
        return usersList;
    }
}
