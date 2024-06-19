import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;

public final class Senha {
    private final PinoColorido[] pinos;
    private final JPanel panel;
    private final int qntdPinos = 0;
    
    public Senha(int qntdPinos) {
        String[] baseColors = {"RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "ORANGE", "PINK", "CYAN"};
        List<String> colors = new ArrayList<>();
        for (String color : baseColors) {
            colors.add(color);
        }
        Collections.shuffle(colors); // Embaralha as cores

        pinos = new PinoColorido[qntdPinos];
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < qntdPinos; i++) {
            pinos[i] = PinoColorido.criaPinoColorido(colors.get(i));
            panel.add(pinos[i]);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public PinoColorido[] getPinos() {
        return pinos;
    }

    public int getTamanho(){
        return qntdPinos;
    }

}
