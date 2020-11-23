package com.example.demo.controllers;

import com.example.demo.database.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
    @Autowired
    private ModelAndView mv ;

    @Autowired
    private Server server;


    @PostMapping(value={"/login"})
    public String verifyUser(HttpServletRequest req, Model model){
        //fetch data from the form
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        //login in the database
        Boolean succes = server.logIn(login,password);


        if(succes){
            //return the view when success
            return "/Home";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping(value={"/Home"})
    public ModelAndView HomePage(){
        this.mv.setViewName("Home");
        return this.mv;
    }

    @GetMapping(value={"/"})
    public ModelAndView getHomePage(){
        this.mv.setViewName("Login");
        return this.mv;
    }
}
