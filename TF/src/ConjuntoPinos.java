import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;

public abstract class ConjuntoPinos{
    public final PinoColorido[] pinos;
    public final String[] colors;
    public final JPanel panel;
    public final int qntdPinos;

    public ConjuntoPinos(int qntdPinos) {
        this.qntdPinos = qntdPinos;
        pinos = new PinoColorido[qntdPinos];
        panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.colors = new String[]{"RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "ORANGE", "PINK", "CYAN"};
    }

    public PinoColorido[] getPinos() {
        return this.pinos;
    }


    public String[] getColors() {
        return this.colors;
    }


    public JPanel getPanel() {
        return this.panel;
    }


    public int getQntdPinos() {
        return this.qntdPinos;
    }

    public String[] GerarSenha(){
        String[] password = new String[qntdPinos];
        List<String> colors = new ArrayList<>();
        for (String color : colors) {
            colors.add(color);
        }
        Collections.shuffle(colors); // Embaralha as cores
        for (int i = 0; i < qntdPinos; i++) {
            password[i] = colors.get(i);
        }
        return password;
    }

    }

