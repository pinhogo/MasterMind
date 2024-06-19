import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public final class Choices{
    private final PinoColorido[] pinos;
    private final String[] colors = {"RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "ORANGE", "PINK", "CYAN"};
    private final JPanel panel;

    public Choices(int qntdPinos){
        pinos = new PinoColorido[qntdPinos];
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < qntdPinos; i++) {
            pinos[i] = PinoColorido.criaPinoColorido(colors[i]);
            pinos[i].setTransferHandler(new TransferHandler("background"));
            panel.add(pinos[i]);   
        }
        Drag();
    }

    public JPanel getPanel(){
        return panel;
    }

    public void Drag(){
        for(PinoColorido pino : pinos) {
            pino.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    JComponent comp = (JComponent) evt.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    if (handler != null) {
                        handler.exportAsDrag(comp, evt, TransferHandler.COPY);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        // Cria uma janela para testar a funcionalidade
        javax.swing.JFrame frame = new javax.swing.JFrame("Drag and Drop Example");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(1,2));
        Choices choices = new Choices(6);
        Attempts attempts = new Attempts(6);
        frame.add(choices.getPanel());
        frame.add(attempts.getPanel());
        frame.setVisible(true);
    }
}
