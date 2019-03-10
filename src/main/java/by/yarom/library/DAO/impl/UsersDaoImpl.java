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

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public Users getUserByLogin(String login) {
        System.out.println("prohod " + login);

        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
        Root<Users> employeeRoot=criteria.from(Users.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("login"), login));
        Users users = currentSession().createQuery(criteria).uniqueResult();

        System.out.println("iz zaprosa "+currentSession().createQuery(criteria).uniqueResult());
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
