import java.awt.GridLayout;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Cria uma janela para testar a funcionalidade
        JFrame frame = new JFrame("Drag and Drop Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(3, 1));

        Senha senha = new Senha(4);
        Attempts attempts = new Attempts(4);
        Clues clues = new Clues(senha, attempts);

        frame.add(senha.getPanel());
        frame.add(attempts.getPanel());
        frame.add(clues.getPanel());

        frame.setVisible(true);

        // Adiciona funcionalidade para verificar a correspondência após o drop
        for (PinoPB pino : attempts.getPinos()) {
            pino.addPropertyChangeListener("background", evt -> clues.verificar());
        }
    }
}
