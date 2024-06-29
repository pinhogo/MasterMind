import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }
}

class MenuInicial extends JFrame {
    public MenuInicial() {
        setTitle("Menu Inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));

        JButton btnFacil = new JButton("Fácil");
        JButton btnMedio = new JButton("Médio");
        JButton btnDificil = new JButton("Difícil");
        JButton btnRecords = new JButton("Records");

        btnFacil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(Dificuldade.FACIL);
            }
        });

        btnMedio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(Dificuldade.MEDIO);
            }
        });

        btnDificil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(Dificuldade.DIFICIL);
            }
        });

        btnRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRecords();
            }
        });

        add(btnFacil);
        add(btnMedio);
        add(btnDificil);
        add(btnRecords);

        setLocationRelativeTo(null);
    }

    private void iniciarJogo(Dificuldade dificuldade) {
        new TabuleiroFrame(dificuldade).setVisible(true);
        dispose(); 
    }

    private void mostrarRecords() {
        
        JOptionPane.showMessageDialog(this, "Recordes ainda não implementados.");
    }
}

class TabuleiroFrame extends JFrame {
    public TabuleiroFrame(Dificuldade dificuldade) {
        setTitle("Teste Tabuleiro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLayout(new BorderLayout());

        Tabuleiro tabuleiro = new Tabuleiro(dificuldade);

        add(tabuleiro, BorderLayout.WEST);
        //add(tabuleiro.pass.getPanel(), BorderLayout.EAST);
        setLocationRelativeTo(null);
    }
}
