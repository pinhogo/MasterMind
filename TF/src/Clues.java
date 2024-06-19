import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class Clues {
    private final Senha senha;
    private final Attempts attempts;
    private final JPanel panel;

    public Clues(Senha senha, Attempts attempts) {
        this.senha = senha;
        this.attempts = attempts;
        this.panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    }

    public boolean verificar() {
        PinoColorido[] senhaPinos = senha.getPinos();
        PinoPB[] attemptPinos = attempts.getPinos();
        Color[] corAtt = new Color[senhaPinos.length];
        Color[] corPass = new Color[senhaPinos.length];

        int correctPositionAndColor = 0;
        int correctColorWrongPosition = 0;

        // Inicializar arrays com as cores das tentativas e da senha
        for (int i = 0; i < senhaPinos.length; i++) {
            corAtt[i] = attemptPinos[i].getBackground();
            corPass[i] = senhaPinos[i].getBackground();
        }

        // Verificar cores corretas na posição correta
        for (int i = 0; i < senhaPinos.length; i++) {
            if (corAtt[i] != null && corAtt[i].equals(corPass[i])) {
                correctPositionAndColor++;
                corAtt[i] = null; // Marca como processado
                corPass[i] = null; // Marca como processado
            }
        }

        // Verificar cores corretas na posição errada
        for (int i = 0; i < senhaPinos.length; i++) {
            if (corPass[i] != null) { // Se ainda não foi processado
                for (int j = 0; j < attemptPinos.length; j++) {
                    if (corAtt[j] != null && corAtt[j].equals(corPass[i])) {
                        correctColorWrongPosition++;
                        corAtt[j] = null; // Marca como processado
                        break;
                    }
                }
            }
        }

        // Limpar o painel de dicas antes de adicionar novas dicas
        panel.removeAll();

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

        // Retornar se todos os pinos estão corretos
        return correctPositionAndColor == senhaPinos.length;
    }

    public JPanel getPanel() {
        return panel;
    }
}
