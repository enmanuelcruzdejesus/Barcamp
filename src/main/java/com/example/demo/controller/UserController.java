package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Value("${server.port}")
    private int puerto;

    @GetMapping(path = "/ejemplo-peticion")
    public String pruebaPeticion(){
        return "<h3>Spring Boot - Servidor escuchando en el puerto: "+puerto+"</h3>";
    }

    @GetMapping(path = "/contador-sesion")
    public String contadorSesion(HttpSession session){

        //
       // return String.format("<h3>Spring Boot - Usted ha visitado %d veces - Puerto: %d - ID Sesion: %s </h3>", contador, puerto, idSesion);
        return "";
    }


    @GetMapping("/")
    public String home(Model model, HttpSession session){
        Integer contador = (Integer) session.getAttribute("contador");
        if(contador == null){
            contador = 0;
        }
        contador++;
        session.setAttribute("contador", contador);
        //
        String idSesion = session.getId();

        User user = (User) session.getAttribute("user");

        model.addAttribute("user",user);
        model.addAttribute("sessionId",session.getId());
        model.addAttribute("contador",contador);
        model.addAttribute("puerto",puerto);
        return "index";
    }

    @RequestMapping(path="user/getAll",method = RequestMethod.GET)
    public List<User> getUsers(HttpServletRequest request){

        List<User> Users = new ArrayList<User>();

        Users = service.fetchUsers();
        return Users;

    }

    @GetMapping("user/getById/{id}")
    public User getUserById(@PathVariable int id){
        return service.getUserById(id).get();
    }

    @RequestMapping(path="user/save",method = RequestMethod.POST)
    public  User saveUser (@RequestBody User User){
        return  service.saveUser(User);
    }

    @RequestMapping(path="user/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user, HttpSession session){

        User usr = (User) session.getAttribute("user");

        if(usr == null){

            usr = this.service.login(user.getUsername(),user.getPassword());
            if(usr == null){
                return new ResponseEntity("invalid credentials", HttpStatus.UNAUTHORIZED);
            }
            else{
                session.setAttribute("user",usr);
                return new ResponseEntity(usr, HttpStatus.OK);
            }

        }

        return new ResponseEntity(usr, HttpStatus.OK);

    }

    @GetMapping(path = "user/session", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserSession(HttpSession session){
         String id =  session.getId();
         return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/destroy")
    public String destroy(HttpSession session){
        session.invalidate();
        return "the session has been destroy";
    }


}
