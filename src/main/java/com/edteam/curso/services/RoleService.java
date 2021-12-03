package com.edteam.curso.services;

import com.edteam.curso.dao.RoleDao;
import com.edteam.curso.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public List<Role> getAll(){
        return roleDao.getAll();
    }

    public Role getById(long id){
        return roleDao.get(id);
    }

    public Role register(Role role){ return roleDao.register(role);}

    public Role update(Role role){
        return roleDao.update(role);
    }

    public void delete(long id){
        roleDao.delete(id);
    }
}
