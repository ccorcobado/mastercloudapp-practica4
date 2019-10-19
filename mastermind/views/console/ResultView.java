package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ResultView extends WithConsoleView {

    public ResultView() { }

    public void writeln(int blacks, int whites) {
        this.console.writeln(MessageView.RESULT.getMessage()
                .replaceFirst("#blacks", "" + blacks)
                .replaceFirst("#whites", "" + whites));
    }
}
