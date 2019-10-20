package mastermind.views.console;

import java.util.List;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.utils.WithConsoleView;

public class StateConsoleView extends WithConsoleView {

    public StateConsoleView() { }

    public void write(Session session) {
        new AttemptsConsoleView().writeln(session.getAttempts());
        new SecretCombinationConsoleView().writeln(session.getGameWidth());
        for (int i = 0; i < session.getAttempts(); i++) {
            this.writeColors(session.getColors(i));
            new ResultConsoleView().writeln(session.getBlacks(i), session.getWhites(i));
        }
    }
    
    private void writeColors(List<Color> colors) {
        for (Color color : colors)
            new ColorConsoleView(color).write();
    }
}