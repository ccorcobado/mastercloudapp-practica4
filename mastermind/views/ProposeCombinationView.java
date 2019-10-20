package mastermind.views;

import java.util.List;
import mastermind.models.Session;
import mastermind.types.Color;

public interface ProposeCombinationView extends View {
    public List<Color> readProposeCombination();
    public void write(Session session);
}
