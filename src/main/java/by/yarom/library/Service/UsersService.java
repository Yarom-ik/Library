package by.yarom.library.Service;

import by.yarom.library.Entity.Users;

import java.util.List;

public interface UsersService {

     void addUser(Users user);

     void updateUser(Users user);

     void deleteUser(int id);

     Users getUserByLogin(String login);

     List<Users> listUsers();
}
