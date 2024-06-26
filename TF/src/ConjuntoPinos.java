import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;

public abstract class ConjuntoPinos {

    public final PinoColorido[] pinos;
    public final String[] colors;
    public final JPanel panel;
    public final int qntdPinos;

    public ConjuntoPinos(int qntdPinos) {
        this.qntdPinos = qntdPinos;
        this.colors = Cores.getInstance().getNomeCores();
        this.pinos = new PinoColorido[qntdPinos];
        this.panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
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

    public String[] GerarSenha() {
        String[] password = new String[qntdPinos];
        List<String> cSenha = new ArrayList<>(Arrays.asList(colors));
        Collections.shuffle(cSenha); // Embaralha as cores
        for (int i = 0; i < qntdPinos; i++) {
            password[i] = cSenha.get(i);
        }
        return password;
    }
}
