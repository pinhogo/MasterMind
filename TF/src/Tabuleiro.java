import java.awt.*;
import javax.swing.JPanel;

public class Tabuleiro {
    private final int score;
    private final Attempts Tentativas;
    private final Dificuldade dificuldade;

    public Tabuleiro(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        Tentativas = new Attempts(dificuldade.getPinos());
        score = 1000;
    }

    public Attempts[] totalTentativas(Dificuldade dificuldade){
        JPanel panel = new JPanel(new GridLayout(dificuldade.getTentativas(), 0));
        Attempts[] tentativas = new Attempts[dificuldade.getTentativas()];
        for (int i = 0; i < dificuldade.getTentativas(); i++) {
            tentativas[i] = Tentativas;
        }
        return tentativas;

    }

    
}
