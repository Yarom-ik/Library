package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.RoleDao;
import by.yarom.library.Entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleDao")
public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public Role getRoleById(int id) {
        return (Role) currentSession().get(Role.class, id);
    }

    @Override
    public List<Role> listRole() {
        List<Role> roleList = currentSession().createQuery("from Role ").list();
        return roleList;
    }
}
