package mastermind.views;

import java.util.HashMap;
import java.util.Map;
import mastermind.types.StateView;
import mastermind.types.TypeView;
import static mastermind.types.TypeView.CONSOLE;
import mastermind.views.console.ProposeCombinationConsoleView;
import mastermind.views.console.ResumeConsoleView;
import mastermind.views.console.StartConsoleView;

public class ViewManager {

    private static ViewManager myself;
    private Map<StateView, View> viewsMap = new HashMap<>();

    private ViewManager(TypeView viewType) {
        switch (viewType) {
            case CONSOLE:
            default:
                this.viewsMap.putAll(this.loadConsoleViews());
                break;
        }
    }
    
    public static ViewManager getInstance(TypeView viewType) {
        if (myself == null) {
            myself = new ViewManager(viewType);
        }
        return myself;
    }

    private Map<StateView, View> loadConsoleViews() {
        Map<StateView, View> viewsConsoleMap = new HashMap<>();
        
        viewsConsoleMap.put(StateView.START, new StartConsoleView());
        viewsConsoleMap.put(StateView.PROPOSE, new ProposeCombinationConsoleView());
        viewsConsoleMap.put(StateView.RESUME, new ResumeConsoleView());
        
        return viewsConsoleMap;
    }

    public View get(StateView viewGameType) {
        return (View) this.viewsMap.get(viewGameType).replicate();
    }
}