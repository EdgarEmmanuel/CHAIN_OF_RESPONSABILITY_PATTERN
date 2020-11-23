package com.example.demo.database;

import com.example.demo.chain.Middleware;

import java.util.HashMap;
import java.util.Map;

public class Server {

    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;


    public void setMiddleware(Middleware middleware) {

        this.middleware = middleware;
    }


    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            //System.out.println("Authorization have been successful!");
            return true;
        }
        return false;
    }

    public Server register(String email, String password) {
        users.put(email, password);
        return this;
    }

    public boolean hasEmail(String email) {
        try {
            return users.containsKey(email);
        }catch(Exception ex){
            return false;
        }

    }

    public boolean isValidPassword(String email, String password) {
        try {
            return this.users.get(email).equals(password);
        }catch(Exception ex){
            return false;
        }

    }



}
