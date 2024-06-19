import java.awt.FlowLayout;
import javax.swing.JPanel;

public class Choices{
    private int qntdPinos;
    private PinoColorido[] pinos;
    private String[] colors = {"RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "ORANGE"};
    private JPanel panel;

    public Choices(int qntdPinos){
        this.qntdPinos = qntdPinos;
        pinos = new PinoColorido[qntdPinos];
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        for (String color : colors) {
            PinoColorido pinos = new PinoColorido(Cores.getInstance().getCor(color));
            panel.add(pinos);
            
        }
    }
}
