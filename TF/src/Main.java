import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Teste Tabuleiro");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 700);
                frame.setLayout(new BorderLayout());

                
        
                // Testando com dificuldade MÉDIO
                Dificuldade dificuldade = Dificuldade.MEDIO;
                Tabu tabuleiro = new Tabu(dificuldade);
                Choices Controle = new Choices(dificuldade.getCores());

                

                frame.add(tabuleiro, BorderLayout.WEST);
                frame.add(Controle.getPanel(), BorderLayout.SOUTH);
                frame.setVisible(true);
            }
        });
    }
}
