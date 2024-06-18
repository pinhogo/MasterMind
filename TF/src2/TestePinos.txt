import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

public class TestePinos {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste Pinos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new FlowLayout());
        for (Color color : new Color[]{Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE}) {
            Pinos button = new Pinos("");
            button.setBackground(color);
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}
