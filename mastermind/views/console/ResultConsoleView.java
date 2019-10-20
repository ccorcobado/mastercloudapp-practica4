package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ResultConsoleView extends WithConsoleView {

    public ResultConsoleView() { }

    public void writeln(int blacks, int whites) {
        this.console.writeln(MessageView.RESULT.getMessage()
                .replaceFirst("#blacks", "" + blacks)
                .replaceFirst("#whites", "" + whites));
    }
}
