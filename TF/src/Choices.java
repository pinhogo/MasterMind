import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public final class Choices{
    private final int qntdPinos;
    private PinoColorido[] pinos;
    private String[] colors = {"RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "ORANGE"};
    private JPanel panel;

    public Choices(int qntdPinos){
        this.qntdPinos = qntdPinos;
        pinos = new PinoColorido[qntdPinos];
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < qntdPinos; i++) {
            pinos[i] = PinoColorido.criaPinoColorido(colors[i]);
            pinos[i].setTransferHandler(new TransferHandler("cor"));
            panel.add(pinos[i]);   
        }
        DragDrop();
    }

    public JPanel getPanel(){
        return panel;
    }

    public void DragDrop(){
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

    // public static void main(String[] args) {
    //     // Cria uma janela para testar a funcionalidade
    //     javax.swing.JFrame frame = new javax.swing.JFrame("Drag and Drop Example");
    //     frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(400, 200);

    //     Choices choices = new Choices(6);
    //     frame.add(choices.getPanel());
    //     frame.setVisible(true);
    // }
}
