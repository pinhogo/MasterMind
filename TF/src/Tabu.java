
import java.awt.*;
import javax.swing.*;

public class Tabu extends JPanel {

    private final int score;
    private final Attempts[] Tentativas;
    private final Clues[] Dicas;
    private final Senha pass;
    
    public Tabu(Dificuldade dificuldade) {
        Tentativas = new Attempts[dificuldade.getTentativas()];
        Dicas = new Clues[dificuldade.getTentativas()];
        pass = new Senha(dificuldade.getPinos());
        score = 1000;

        setLayout(new BorderLayout());

        JPanel pTentativas = new JPanel(new GridLayout(dificuldade.getTentativas(), 1));
        JPanel pDicas = new JPanel(new GridLayout(dificuldade.getTentativas(), 1));
        add(pTentativas, BorderLayout.WEST);
        add(pDicas, BorderLayout.EAST);

        for (int i = 0; i < dificuldade.getTentativas(); i++) {
            Tentativas[i] = new Attempts(dificuldade.getPinos());
            pTentativas.add(Tentativas[i].getPanel());
            Dicas[i] = new Clues(pass,Tentativas[i]);
            pDicas.add(Dicas[i].getPanel());
        }
    }
}
