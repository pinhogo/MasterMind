import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App extends JFrame {
    private int senha = 4;  // quantidade de pinos
    private int cores = 8;  // quantidade de cores
   
    public App() {
        setTitle("Master Mind");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(2, 2));

        Choices choices = new Choices(cores);
        Senha codigo = new Senha(senha);
        Attempts attempts = new Attempts(senha);  // corrigido para usar a quantidade correta de pinos
        Clues clues = new Clues(codigo, attempts);

        mainPanel.add(attempts.getPanel());
        mainPanel.add(choices.getPanel());
        mainPanel.add(clues.getPanel());
        mainPanel.add(codigo.getPanel());

        add(mainPanel, BorderLayout.CENTER);

        for (PinoPB pino : attempts.getPinos()) {
            pino.addPropertyChangeListener("background", evt -> clues.verificar());
        }
    }

    private void criaJanelaPrincipal() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App app = new App();
                app.criaJanelaPrincipal();
            }
        });
    }
}
