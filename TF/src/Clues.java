import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clues {
    private final Senha senha;
    private final Attempts attempts;
    private final JLabel messageLabel;
    private final JPanel panel;

    public Clues(Senha senha, Attempts attempts) {
        this.senha = senha;
        this.attempts = attempts;
        this.messageLabel = new JLabel();
        this.panel = new JPanel();
        panel.add(messageLabel);
    }

    public boolean verificar() {
        PinoColorido[] senhaPinos = senha.getPinos();
        PinoPB[] attemptPinos = attempts.getPinos();

        for (int i = 0; i < senhaPinos.length; i++) {
            Color corSenha = senhaPinos[i].getBackground();
            Color corAttempt = attemptPinos[i].getBackground();
            if (!corSenha.equals(corAttempt)) {
                messageLabel.setText("Errou");
                return false; // Encontra uma discrepância
            }
        }
        messageLabel.setText("Acertou");
        return true; // Todos os pinos estão corretos
    }

    public JPanel getPanel() {
        return panel;
    }
}
