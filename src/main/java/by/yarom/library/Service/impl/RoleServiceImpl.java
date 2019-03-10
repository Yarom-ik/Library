package by.yarom.library.Service.impl;

import by.yarom.library.DAO.RoleDao;
import by.yarom.library.Entity.Role;
import by.yarom.library.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public List<Role> listRole() {
        return roleDao.listRole();
    }
}
