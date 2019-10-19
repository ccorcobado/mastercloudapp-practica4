package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposeCombinationView extends WithConsoleView {

    public ProposeCombinationView() { }

    public String read() {
        return (this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage()));
    }

    public void writeln() {
        this.console.writeln();
    }

    public void writeln(String message) {
        this.console.writeln(message);
    }
}