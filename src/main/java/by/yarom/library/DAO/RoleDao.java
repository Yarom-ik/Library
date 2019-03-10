package by.yarom.library.DAO;

import by.yarom.library.Entity.Role;

import java.util.List;

public interface RoleDao {


     Role getRoleById(int id);

     List<Role> listRole();
}
