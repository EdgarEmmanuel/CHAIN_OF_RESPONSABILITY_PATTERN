package com.example.demo.chain;

public abstract class Middleware {
    private Middleware next;

    public Middleware linkNext(Middleware next){
        this.next = next;
        return this.next;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (this.next == null) {
            return true;
        }
        return this.next.check(email, password);
    }
}
