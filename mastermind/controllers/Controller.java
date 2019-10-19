package mastermind.controllers;

import mastermind.models.Session;

public abstract class Controller {
    
    protected final Session session;

    protected Controller(Session session) {
        this.session = session;
    }

    public abstract void control();
}