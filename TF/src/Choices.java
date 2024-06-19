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
            panel.add(pinos[i]);   
            
            DragDrop();
        }
    }

    public void DragDrop(){
        for(int i = 0; i < qntdPinos; i++) {
            pinos[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    JComponent comp = (JComponent) evt.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, evt, TransferHandler.COPY);
                }
            });
        }
    }
}
