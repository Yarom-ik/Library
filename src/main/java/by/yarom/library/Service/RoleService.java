package by.yarom.library.Service;

import by.yarom.library.Entity.Role;

import java.util.List;

public interface RoleService {

    public Role getRoleById(int id);

    public List<Role> listRole();
}
