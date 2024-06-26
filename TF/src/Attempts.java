
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class Attempts {

    private final JPanel panel;
    private final PinoPB[] vazio;
    private final int qntdPinos;

    public Attempts(int qntdPinos) {
        vazio = new PinoPB[qntdPinos];
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.qntdPinos = qntdPinos;
        //CriarPinos();
    }

    public void CriarPinos() {
        panel.setTransferHandler(new ColorTransferHandler() {
            @Override
            public int getSourceActions(JComponent c) { // apenas recebe o drop
                return NONE;
            }
        });
        for (int i = 0; i < qntdPinos; i++) {
            vazio[i] = PinoPB.criaPinoBranco();
            vazio[i].setTransferHandler(new TransferHandler("cor"));
            panel.add(vazio[i]);
        }
        Drop();
    }

    public JPanel getPanel() {
        return panel;
    }

    public PinoPB[] getPinos() {
        return vazio;
    }

    public void Drop() {
        for (PinoPB pino : vazio) {
            pino.setTransferHandler(new TransferHandler("background"));
        }
    }

    public void desativarDrop() {
        for (PinoPB pino : vazio) {
            pino.setTransferHandler(null);
        }
    }
}
