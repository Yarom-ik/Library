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
        currentSession().createQuery("DELETE Users where idUser =:idUser")
                .setParameter("idUser", id)
                .executeUpdate();
    }

    @Override
    public Users getUserByLogin(String login) {
        Users users = (Users) currentSession().createQuery("from Users u where u.login =:login")
                .setParameter("login",login)
                .uniqueResult();

        return users;
    }

    @Override
    public Users getUserByEmail(String email) {
        Users users = (Users) currentSession().createQuery("from Users u where u.email =:email")
                .setParameter("email",email)
                .uniqueResult();
        return users;
    }

    @Override
    public List<Users> listUsers(Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        List<Users> usersList = currentSession().createQuery("from Users")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return usersList;
    }

    @Override
    public Long countFindReader() {
        return (Long) currentSession().createQuery("select count (*) from Users").uniqueResult();
    }
}
