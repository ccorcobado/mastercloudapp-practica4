package mastermind.controllers;

import mastermind.types.StateView;
import mastermind.models.Session;
import mastermind.views.StartView;

public class StartController extends Controller {
    
    public StartController(Session session) {
        super(session);
    }
    
    @Override
    public void control(){
        StartView view = (StartView) this.getView(StateView.START);
        view.writeIntro(this.session.getGameWidth());
        this.session.next();
    }
}