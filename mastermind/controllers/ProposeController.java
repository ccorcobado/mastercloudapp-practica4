package mastermind.controllers;

import java.util.ArrayList;
import java.util.List;
import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.ColorView;
import mastermind.views.console.ErrorView;
import mastermind.views.MessageView;
import mastermind.views.console.GameView;
import mastermind.views.console.ProposeCombinationView;

public class ProposeController extends Controller {

    private final ProposeCombinationView proposeCombinationView;

    public ProposeController(Session session) {
        super(session);
        this.proposeCombinationView = new ProposeCombinationView();
    }

    @Override
    public void control() {
        List<Color> colors = this.readProposeCombination();
        this.session.addProposeCombination(colors);
        this.proposeCombinationView.writeln();
        new GameView().writeGame(this.session);
        this.checkGame();
    }

    private List<Color> readProposeCombination() {
        List<Color> colors;
        Error error;
        do {
            String characters = this.proposeCombinationView.read();
            colors = new ArrayList<>();
            for (int i = 0; i < characters.length(); i++) {
                colors.add(ColorView.getInstance(characters.charAt(i)));
            }
            error = this.checkProposeCombination(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        
        return colors;
    }
    
    private void checkGame() {
        if (this.session.isWinner()) {
            this.proposeCombinationView.writeln(MessageView.WINNER.getMessage());
            this.session.next();
        } else if (this.session.isLooser()) {
            this.proposeCombinationView.writeln(MessageView.LOOSER.getMessage());
            this.session.next();
        }
    }

    private Error checkProposeCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i + 1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }
            }
        }
        return error;
    }
}