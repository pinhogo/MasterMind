import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestePinos {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste Pinos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new FlowLayout());
        PinoColorido[] pinos = new PinoColorido[4];
        pinos[0] = PinoColorido.criaPinoColorido("BLUE");
        pinos[1] = PinoColorido.criaPinoColorido("GREEN");
        pinos[2] = PinoColorido.criaPinoColorido("RED");
        pinos[3] = PinoColorido.criaPinoColorido("YELLOW");

        for(int i = 0; i < 4; i++) {
            // Adiciona o pino ao painel, que é o container
            panel.add(pinos[i]);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}

