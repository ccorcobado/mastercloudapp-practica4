package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.utils.YesNoDialog;
import mastermind.views.MessageView;

public class ResumeView extends WithConsoleView {
    public ResumeView() {}
    
    public boolean newGame() {
        return new YesNoDialog().read(MessageView.RESUME.getMessage());
    }
}
