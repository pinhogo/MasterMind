import javax.swing.JPanel;

public class Senha extends ConjuntoPinos{
    // private final PinoColorido[] pinos;
    // private final JPanel panel;
    // private final int qntdPinos = 0;

    public Senha(int qntdPinos) {
        super(qntdPinos);

        CriarPinos();
    }

    public void CriarPinos() {

        String[] cores = GerarSenha();

        for (int i = 0; i < qntdPinos; i++) {
            pinos[i] = PinoColorido.criaPinoColorido(cores[i]);
            panel.add(pinos[i]);
        }
    }
    
    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public PinoColorido[] getPinos() {
        return pinos;
    }

    public int getTamanho(){
        return qntdPinos;
    }

}
