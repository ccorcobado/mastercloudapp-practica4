package mastermind.controllers;

import mastermind.types.StateView;
import mastermind.models.Session;
import mastermind.views.ResumeView;

public class ResumeController extends Controller {

    public ResumeController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        ResumeView view = (ResumeView) this.getView(StateView.RESUME);
        if (view.newGame()) {
            this.session.resume();
        } else 
            this.session.next();
    }
}
