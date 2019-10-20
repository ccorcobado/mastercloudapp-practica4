package mastermind.controllers;

import mastermind.models.Session;
import mastermind.types.StateView;
import mastermind.views.View;
import mastermind.views.ViewManager;

public abstract class Controller {
    
    protected final Session session;

    protected Controller(Session session) {
        this.session = session;
    }
    
    protected View getView(StateView stateView) {
        return ViewManager
            .getInstance(this.session.getTypeView())
            .get(stateView);
    }

    public abstract void control();
}