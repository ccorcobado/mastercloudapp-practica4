package mastermind.views;

import java.util.HashMap;
import java.util.Map;
import mastermind.types.StateValue;
import mastermind.types.TypeView;
import static mastermind.types.TypeView.CONSOLE;
import mastermind.views.console.ProposeCombinationConsoleView;
import mastermind.views.console.ResumeConsoleView;
import mastermind.views.console.StartConsoleView;

public class ViewManager {

    private static ViewManager myself;
    private Map<StateValue, View> viewsMap = new HashMap<>();

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

    private Map<StateValue, View> loadConsoleViews() {
        Map<StateValue, View> viewsConsoleMap = new HashMap<>();
        
        viewsConsoleMap.put(StateValue.INITIAL, new StartConsoleView());
        viewsConsoleMap.put(StateValue.IN_GAME, new ProposeCombinationConsoleView());
        viewsConsoleMap.put(StateValue.FINAL, new ResumeConsoleView());
        
        return viewsConsoleMap;
    }

    public View get(StateValue stateValue) {
        return (View) this.viewsMap.get(stateValue).replicate();
    }
}