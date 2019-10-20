package mastermind.controllers;

import java.util.List;
import mastermind.types.StateView;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.views.ProposeCombinationView;

public class ProposeController extends Controller {

    public ProposeController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        ProposeCombinationView view = (ProposeCombinationView) this.getView(StateView.PROPOSE);
        List<Color> colors = view.readProposeCombination();
        this.session.addProposeCombination(colors);
        view.write(this.session);
        
        if (this.session.isWinner() || this.session.isLooser())
            this.session.next();
    }    
}