package mastermind;

import java.util.HashMap;
import java.util.Map;
import mastermind.controllers.Controller;
import mastermind.controllers.ProposeController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.types.TypeView;
import mastermind.types.StateValue;

public class Mastermind {

    private final Session session;
    private final Map<StateValue, Controller> controllers;

    private Mastermind(TypeView typeView) {
        this.session = new Session(typeView);
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.session));
        this.controllers.put(StateValue.IN_GAME, new ProposeController(this.session));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.session));
        this.controllers.put(StateValue.EXIT, null);
    }

    private void play() {
        Controller controller;
        do {
            controller = this.controllers.get(this.session.getStateValue());
            if (controller != null) {
                controller.control();
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind(TypeView.CONSOLE).play();
    }
}
