package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.utils.YesNoDialog;
import mastermind.views.MessageView;
import mastermind.views.ResumeView;
import mastermind.views.View;

public class ResumeConsoleView extends WithConsoleView implements ResumeView {
    
    public ResumeConsoleView() {}
    
    @Override
    public boolean newGame() {
        return new YesNoDialog().read(MessageView.RESUME.getMessage());
    }
    
    @Override
    public View replicate() {
        return new ResumeConsoleView();
    }
}
