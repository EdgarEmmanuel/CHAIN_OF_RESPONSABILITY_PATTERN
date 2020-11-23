package com.example.demo.chain;

import com.example.demo.database.Server;

public class EmailExistMiddleware extends Middleware {
    private Server server;

    public EmailExistMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!this.server.hasEmail(email)) {
            //System.out.println("Cet email n'est pas reconnu");
            return false;
        }
        return checkNext(email, password);
    }
}
