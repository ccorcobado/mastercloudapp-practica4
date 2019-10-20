package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;
import mastermind.views.StartView;
import mastermind.views.View;

public class StartConsoleView extends WithConsoleView implements StartView {

    public StartConsoleView(){ }

    @Override
    public void writeIntro(int lengthCombination) {
        this.console.writeln(MessageView.TITLE.getMessage());
        new SecretCombinationConsoleView().writeln(lengthCombination);
    }
    
    @Override
    public View replicate() {
        return new StartConsoleView();
    }
}