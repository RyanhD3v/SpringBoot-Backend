package com.edteam.curso.controllers;

import com.edteam.curso.models.Role;
import com.edteam.curso.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    //Obtener todos los roles
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Role> getAll(){
        return roleService.getAll();
    }

    //Obtener rol por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role getById(@PathVariable long id){
        return roleService.getById(id);
    }

    //Registrar rol
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Role register(@RequestBody Role role){
        return roleService.register(role);
    }

    //Actualizar rol
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Role update(@RequestBody Role role){
        return roleService.update(role);
    }

    //Eliminar rol
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        roleService.delete(id);

    }
}
