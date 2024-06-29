
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Senha extends ConjuntoPinos {
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

    public int getTamanho() {
        return qntdPinos;
    }

    @Override
    public String[] getColors() {
        return colors;
    }
    //  	                                                <<<<<<TESTESSS>>>>
    public static void main(String[] args) {
        //Cria uma janela para testar a funcionalidade
        Senha choices = new Senha(4);
        for(int i = 0; i < choices.getQntdPinos(); i++){
            System.out.println(choices.getColors()[i]);
        }
        javax.swing.JFrame frame = new javax.swing.JFrame("Drag and Drop Example");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(1,2));
        //Senha choices = new Senha(6);
        frame.add(choices.getPanel());
        frame.setVisible(true);
    }
}
