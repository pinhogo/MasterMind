import java.awt.FlowLayout;
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
        panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        

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
}
