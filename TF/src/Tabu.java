import java.awt.*;
import javax.swing.JPanel;

public class Tabu extends JPanel {
    private final int score;
    private final Attempts[] Tentativas;
    private final Dificuldade dificuldade;

    public Tabu(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        Tentativas = new Attempts[dificuldade.getTentativas()];
        score = 1000;

        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(dificuldade.getTentativas(), 1));
        add(mainPanel, BorderLayout.CENTER);

        for (int i = 0; i < dificuldade.getTentativas(); i++) {
            Tentativas[i] = new Attempts(dificuldade.getPinos());
            mainPanel.add(Tentativas[i].getPanel());
        }
    }

    // public Attempts[] totalTentativas(Dificuldade dificuldade){
    //     JPanel panel = new JPanel(new GridLayout(dificuldade.getTentativas(), 0));
    //     Attempts[] tentativas = new Attempts[dificuldade.getTentativas()];
    //     for (int i = 0; i < dificuldade.getTentativas(); i++) {
    //         tentativas[i] = Tentativas;
    //     }
    //     return tentativas;

    // }
    
}
