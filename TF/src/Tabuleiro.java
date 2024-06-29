
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Tabuleiro extends JPanel {

    private final Dificuldade dificuldade;
    private int score;
    private final JLabel scoreLabel;
    private final Attempts[] Tentativas;
    private final Clues[] Dicas;
    public final Senha pass;
    public final Choices Controle;
    private int linhaAtual = 0;
    private int count = 0;

    public Tabuleiro(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        scoreLabel = new JLabel("Pontuação: " + score);
        Tentativas = new Attempts[dificuldade.getTentativas()];
        Dicas = new Clues[dificuldade.getTentativas()];
        pass = new Senha(dificuldade.getCores());
        this.Controle = new Choices(dificuldade.getCores());    
        Controle.CriarPinos(pass.getColors());
        

        score = 1000;
        setLayout(new BorderLayout());

        Inicializar();
    }

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public void Inicializar() {
        JPanel pTentativas = new JPanel(new GridLayout(dificuldade.getTentativas(), 1));
        JPanel pDicas = new JPanel(new GridLayout(dificuldade.getTentativas(), 2));

        add(pTentativas, BorderLayout.WEST);
        add(pDicas, BorderLayout.EAST);
        add(scoreLabel, BorderLayout.NORTH);
        add(Controle.getPanel(), BorderLayout.SOUTH);

        for (int i = 0; i < dificuldade.getTentativas(); i++) {
            Tentativas[i] = new Attempts(dificuldade.getPinos());
            pTentativas.add(Tentativas[i].getPanel());
            Dicas[i] = new Clues(pass, Tentativas[i]);

            int finalI = i;
            Dicas[i].verificarButton.addActionListener((ActionEvent e) -> {
                try {
                Dicas[finalI].verificar();
                linhaAtual++;
                
                Tentativas[Dicas.length - 1 - linhaAtual].CriarPinos(); // ativa o primeiro drop
                Dicas[Dicas.length - 1 - linhaAtual].verificarButton.setEnabled(true); // ativa o de cima
                Dicas[Dicas.length - 1 - linhaAtual + 1].verificarButton.setEnabled(false); // desativa o de baixo
                Tentativas[finalI].desativarDrop();
                VerificarVitoria();
                
                count++;
            
                CalculateScore(dificuldade);

                if (linhaAtual == dificuldade.getTentativas()) {

                    JOptionPane.showMessageDialog(null, "Game Over.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {

                JOptionPane.showMessageDialog(null, "Game Over.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
            });
            
            pDicas.add(Dicas[i].panelButton);
            pDicas.add(Dicas[i].getPanel());
        }
        Dicas[Dicas.length - 1].verificarButton.setEnabled(true); // ativa o primeiro
        Tentativas[Dicas.length - 1].CriarPinos(); // ativa o primeiro drop
    }

    /**
     * @param dificuldade
     * @return
     */
    private int CalculateScore(Dificuldade dificuldade) {
        if (dificuldade == Dificuldade.FACIL) {
            score -= 100;
            scoreLabel.setText("Pontuação: " + score);
        }
        if (dificuldade == Dificuldade.MEDIO) {
            score -= 100;
            scoreLabel.setText("Pontuação: " + score*100);
        }
        if (dificuldade == Dificuldade.DIFICIL) {
            score -= 100;
            scoreLabel.setText("Pontuação: " + score*1000);
        }

        setScore(score);
        return score;
    }

    private void VerificarVitoria(){
        for(int i = 0; i < dificuldade.getTentativas(); i++){
            if(Dicas[i].Venceu() == true){
                JOptionPane.showMessageDialog(null, "Você venceu!", "Vitória", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void ConfigurarDificuldade(){

    }

}
