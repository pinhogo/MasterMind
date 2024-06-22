import java.awt.*;
import javax.swing.*;


public class MasterMind extends JFrame {
    private Attempts Tentativas;
    private Clues Dicas;
    private Choices Controle;
    private Senha Password;
    private int pinos = 4;
    private int cores = 8;

    public MasterMind() {
        setTitle("Master Mind");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        Password = new Senha(pinos);
        //add(Password.getPanel(), BorderLayout.NORTH);

        Controle = new Choices(cores);
        add(Controle.getPanel(), BorderLayout.SOUTH);

        Tentativas = new Attempts(pinos);
        add(Tentativas.getPanel(), BorderLayout.WEST);

        Dicas = new Clues(Password, Tentativas);
        add(Dicas.getPanel(), BorderLayout.NORTH);

        for (PinoPB pino : Tentativas.getPinos()) {
            pino.addPropertyChangeListener("background", evt -> Dicas.verificar());
        }
    }

  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MasterMind app = new MasterMind();
                app.setVisible(true);
            }
        });
    }
}
