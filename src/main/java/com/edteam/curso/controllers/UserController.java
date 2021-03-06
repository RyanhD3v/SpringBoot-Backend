package com.edteam.curso.controllers;

import com.edteam.curso.models.User;
import com.edteam.curso.services.UserService;
import com.edteam.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    //Obtener todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll(){
        return userService.getAll();
    }

    //Obtener usuario por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getById(@PathVariable long id){
        return userService.getById(id);
    }

    //Registrar Usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    void register(@RequestBody User user){
        userService.register(user);
    }

    //Actualizar Usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@RequestBody User user){
        return userService.update(user);
    }

    //Eliminar Usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        userService.delete(id);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User dto){
        User user = userService.login(dto);

        Map<String, Object> result = new HashMap<>();
        if (user != null){
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }
        return result;
    }

}
