import java.awt.*;
import javax.swing.*;

public class Clues {
    private final Senha senha;
    private final Attempts attempts;
    private final JPanel panel;
    public final JPanel panelButton;
    public final JButton verificarButton;
    private int correctPositionAndColor;
    private int correctColorWrongPosition;

    public Clues(Senha senha, Attempts attempts) {
        this.correctPositionAndColor = 0;
        this.correctColorWrongPosition = 0;
        this.senha = senha;
        this.attempts = attempts;
        this.panel = new JPanel(new FlowLayout());
        this.verificarButton = new JButton("Verificar");
        this.verificarButton.setEnabled(false);
        this.verificarButton.setSize(100, 50);

        // Adicionando o botão verificar ao painel
        this.panelButton = new JPanel(new FlowLayout());
        panelButton.add(verificarButton);
    }

    public void verificar() {
        PinoColorido[] senhaPinos = senha.getPinos();
        PinoPB[] attemptPinos = attempts.getPinos();
        Color[] corAtt = attemptPinos(attemptPinos);
        Color[] corPass = inicializarCores(senhaPinos);

        correctPositionAndColor = verificarPosicaoCorreta(corAtt, corPass);
        correctColorWrongPosition = verificarPosicaoErrada(corAtt, corPass);

        atualizarPainel(senhaPinos, correctPositionAndColor, correctColorWrongPosition);
    }

    private Color[] attemptPinos(PinoPB[] attemptPinos) {
        Color[] cores = new Color[attemptPinos.length];
        for (int i = 0; i < attemptPinos.length; i++) {
            cores[i] = attemptPinos[i].getBackground();
        }
        return cores;
    }

    private Color[] inicializarCores(PinoColorido[] pinos) {
        Color[] cores = new Color[pinos.length];
        for (int i = 0; i < pinos.length; i++) {
            cores[i] = pinos[i].getBackground();
        }
        return cores;
    }

    private int verificarPosicaoCorreta(Color[] corAtt, Color[] corPass) {
        int count = 0;
        for (int i = 0; i < corAtt.length; i++) {
            if (corAtt[i] != null && corAtt[i].equals(corPass[i])) {
                count++;
                corAtt[i] = null; // Marca como processado
                corPass[i] = null; // Marca como processado
            }
        }
        return count;
    }

    private int verificarPosicaoErrada(Color[] corAtt, Color[] corPass) {
        int count = 0;
        for (int i = 0; i < corPass.length; i++) {
            if (corPass[i] != null) { // Se ainda não foi processado
                for (int j = 0; j < corAtt.length; j++) {
                    if (corAtt[j] != null && corAtt[j].equals(corPass[i])) {
                        count++;
                        corAtt[j] = null; // Marca como processado
                        break;
                    }
                }
            }
        }
        return count;
    }

    private void atualizarPainel(PinoColorido[] senhaPinos, int correctPositionAndColor, int correctColorWrongPosition) {
        // Limpar o painel de dicas antes de adicionar novas dicas, exceto o botão "Verificar"
        panel.removeAll();
         // Re-adiciona o botão "Verificar" após limpar o painel

        // Adicionar pinos pretos e brancos no painel de dicas
        for (int i = 0; i < correctPositionAndColor; i++) {
            panel.add(PinoPB.criaPinoPreto());
        }
        for (int i = 0; i < correctColorWrongPosition; i++) {
            panel.add(PinoPB.criaPinoBranco());
        }
        // Adicionar pinos vazios para preencher o restante
        int totalDicas = correctPositionAndColor + correctColorWrongPosition;
        for (int i = totalDicas; i < senhaPinos.length; i++) {
            panel.add(PinoPB.criaPinoVazio());
        }

        // Atualizar o painel para refletir as mudanças
        panel.revalidate();
        panel.repaint();
    }
    

    public JPanel getPanel() {
        return panel;
    }

    public boolean Venceu() {
        return correctPositionAndColor == senha.getPinos().length;
    }

    public int getPinosPretos() {
        return correctPositionAndColor;
    }
    public int getPinosBrancos() {
        return correctColorWrongPosition;
    }
}
