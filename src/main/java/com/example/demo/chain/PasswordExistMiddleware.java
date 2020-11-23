package com.example.demo.chain;

import com.example.demo.database.Server;

public class PasswordExistMiddleware extends Middleware {
    private Server server;

    public PasswordExistMiddleware(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!this.server.isValidPassword(email, password)) {
            //System.out.println("Mot de Passe Faux");
            return false;
        }
        return checkNext(email,password);
    }
}
