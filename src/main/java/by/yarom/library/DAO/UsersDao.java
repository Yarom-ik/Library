package by.yarom.library.DAO;

import by.yarom.library.Entity.Users;

import java.util.List;

public interface UsersDao {

     void addUser(Users user);

     void updateUser(Users user);

     void deleteUser(int id);

     Users getUserByLogin(String login);

     List<Users> listUsers();
}
