package mastermind.views.console;

import mastermind.types.Color;
import mastermind.utils.Console;

public class ColorConsoleView extends mastermind.views.ColorView {

    public ColorConsoleView(Color color) { 
        super(color);
    }
    
    public void write() {
        new Console().write(ColorConsoleView.INITIALS[color.ordinal()]);
    }
}
