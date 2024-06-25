
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class Tabuleiro extends JPanel {
    private final Dificuldade dificuldade;
    private final int score;
    private final Attempts[] Tentativas;
    private final Clues[] Dicas;
    private final Senha pass;
    private int linhaAtual = 0;

    public Tabuleiro(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        Tentativas = new Attempts[dificuldade.getTentativas()];
        Dicas = new Clues[dificuldade.getTentativas()];
        pass = new Senha(dificuldade.getPinos());
        score = 1000;
        setLayout(new BorderLayout());

        Inicializar();
    }
        

    public void Inicializar() {
        JPanel pTentativas = new JPanel(new GridLayout(dificuldade.getTentativas(), 1));
        JPanel pDicas = new JPanel(new GridLayout(dificuldade.getTentativas(), 2));
        
        add(pTentativas, BorderLayout.WEST);
        add(pDicas, BorderLayout.EAST);

        for (int i = 0; i < dificuldade.getTentativas(); i++) {
            Tentativas[i] = new Attempts(dificuldade.getPinos());
            pTentativas.add(Tentativas[i].getPanel());
            Dicas[i] = new Clues(pass, Tentativas[i]);

            int finalI = i;
            Dicas[i].verificarButton.addActionListener((ActionEvent e) -> {
                Dicas[finalI].verificar();
                linhaAtual++;

                Dicas[Dicas.length - 1 - linhaAtual].verificarButton.setEnabled(true);
                Dicas[Dicas.length - 1 - linhaAtual + 1].verificarButton.setEnabled(false);
                Tentativas[finalI].desativarDrop();

            });
            pDicas.add(Dicas[i].panelButton);
            pDicas.add(Dicas[i].getPanel());
        }
        Dicas[Dicas.length - 1].verificarButton.setEnabled(true);
    }

}

