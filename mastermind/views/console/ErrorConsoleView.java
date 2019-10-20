package mastermind.views.console;

import mastermind.types.Error;
import mastermind.utils.Console;

public class ErrorConsoleView extends mastermind.views.ErrorView {

    public ErrorConsoleView(Error error) {
        super(error);
    }

    public void writeln() {
        new Console().writeln(ErrorConsoleView.MESSAGES[this.error.ordinal()]);
    }
}
