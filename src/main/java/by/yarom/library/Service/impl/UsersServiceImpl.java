package by.yarom.library.Service.impl;

import by.yarom.library.DAO.RoleDao;
import by.yarom.library.DAO.UsersDao;
import by.yarom.library.Entity.Users;
import by.yarom.library.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;


    @Override
    public void addUser(Users user) {

        usersDao.addUser(user);

    }

    @Override
    public void updateUser(Users user) {
        usersDao.updateUser(user);

    }

    @Override
    public void deleteUser(int id) {
        usersDao.deleteUser(id);

    }

    @Override
    public Users getUserByLogin(String login) {
        return usersDao.getUserByLogin(login);
    }

    @Override
    public Users getUserByEmail(String email) {
        return usersDao.getUserByEmail(email);
    }

    @Override
    public List<Users> listUsers() {
        return usersDao.listUsers();
    }
}
