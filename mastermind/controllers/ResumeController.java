package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.ResumeView;

public class ResumeController extends Controller {

    public ResumeController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        ResumeView view = (ResumeView) this.getView();
        if (view.newGame()) {
            this.session.resume();
        } else 
            this.session.next();
    }
}