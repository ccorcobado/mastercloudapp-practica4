package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.View;
import mastermind.views.ViewManager;

public abstract class Controller {
    
    protected final Session session;

    protected Controller(Session session) {
        this.session = session;
    }
    
    protected View getView() {
        return ViewManager
            .getInstance(this.session.getTypeView())
            .get(this.session.getStateValue());
    }

    public abstract void control();
}