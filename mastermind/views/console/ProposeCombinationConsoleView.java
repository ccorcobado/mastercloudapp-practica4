package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;
import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.utils.WithConsoleView;
import mastermind.views.ColorView;
import mastermind.views.MessageView;
import mastermind.views.ProposeCombinationView;
import mastermind.views.View;

public class ProposeCombinationConsoleView 
    extends WithConsoleView implements ProposeCombinationView {

    public ProposeCombinationConsoleView() { }

    public String read() {
        return (this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage()));
    }

    private void writeln() {
        this.console.writeln();
    }

    private void writeln(String message) {
        this.console.writeln(message);
    }
    
    @Override
    public void write(Session session) {
        this.writeln();
        new StateConsoleView().write(session);
        
        if (session.isWinner()) {
            this.writeln(MessageView.WINNER.getMessage());
        } else if (session.isLooser()) {
            this.writeln(MessageView.LOOSER.getMessage());
        }
    }
    
    @Override
    public List<Color> readProposeCombination() {
        List<Color> colors;
        Error error;
        do {
            String characters = this.read();
            colors = new ArrayList<>();
            for (int i = 0; i < characters.length(); i++) {
                colors.add(ColorView.getInstance(characters.charAt(i)));
            }
            error = this.checkProposeCombination(colors);
            if (error != null) {
                new ErrorConsoleView(error).writeln();
            }
        } while (error != null);
        
        return colors;
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
    
    @Override
    public View replicate() {
        return new ProposeCombinationConsoleView();
    }
}