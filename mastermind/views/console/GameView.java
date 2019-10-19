package mastermind.views.console;

import java.util.List;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.utils.WithConsoleView;

public class GameView extends WithConsoleView {

    public GameView() { }

    public void writeGame(Session session) {
        new AttemptsView().writeln(session.getAttempts());
        new SecretCombinationView().writeln(session.getGameWidth());
        for (int i = 0; i < session.getAttempts(); i++) {
            this.writeColors(session.getColors(i));
            new ResultView().writeln(session.getBlacks(i), session.getWhites(i));
        }
    }
    
    private void writeColors(List<Color> colors) {
        for (Color color : colors)
            new ColorView(color).write();
    }
}