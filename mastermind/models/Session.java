package mastermind.models;

import mastermind.types.TypeView;
import mastermind.types.StateValue;
import java.util.List;
import mastermind.types.Color;

public class Session  {

    private final State state;
    private final Game game;
    private final TypeView typeView;

    public Session(TypeView typeView) {
        this.state = new State();
        this.game = new Game();
        this.typeView = typeView;
    }
    
    public TypeView getTypeView() {
        return this.typeView;
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
    }
    
    public void next() {
        this.state.next();
    }

    public StateValue getStateValue() {
        return this.state.getValueState();
    }

    public void addProposeCombination(List<Color> colors){
        this.game.addProposedCombination(colors);
    }

    public int getAttempts() { return this.game.getAttempts(); }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }
    
    public int getGameWidth() {
        return this.game.getWidth();
    }
}