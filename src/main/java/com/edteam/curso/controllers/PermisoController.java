package com.edteam.curso.controllers;

import com.edteam.curso.models.Permiso;
import com.edteam.curso.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")
public class PermisoController {

    @Autowired
    PermisoService permisoService;

    //Obtener todos los permisos
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll(){
        return permisoService.getAll();
    }

    //Obtener permisos por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso getById(@PathVariable long id){
        return permisoService.getById(id);

    }

    //Registrar permisos
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso register(@RequestBody Permiso permiso){
        return permisoService.register(permiso);
    }

    //Actualizar permisos
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permiso update(@RequestBody Permiso permiso){
        return permisoService.update(permiso);
    }

    //Eliminar permisos
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        permisoService.delete(id);

    }

}
