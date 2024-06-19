import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MasterMind extends JFrame {
    private JTextField[][] attemptFields;
    private JTextField[] feedbackFields;
    private JTextField scoreField;
    private String[] colors = { "RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "ORANGE", "GRAY", "PINK" };
    private Color[] secretCode;
    private int currentAttempt;

    public MasterMind() {
        setTitle("Master Mind");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Inicializa o código secreto
       // generateSecretCode();

        // Configuração do painel principal
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Painel das tentativas
        JPanel attemptsPanel = new JPanel(new GridLayout(8, 1));
        attemptFields = new JTextField[8][4];
        for (int i = 0; i < 8; i++) {
            JPanel row = new JPanel(new GridLayout(1, 4));
            for (int j = 0; j < 4; j++) {
                attemptFields[i][j] = new JTextField();
                attemptFields[i][j].setEditable(false);
                attemptFields[i][j].setTransferHandler(new TransferHandler("background"));
                row.add(attemptFields[i][j]);

                int rowIdx = i;
                int colIdx = j;
                attemptFields[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        JComponent comp = (JComponent) evt.getSource();
                        TransferHandler handler = comp.getTransferHandler();
                        handler.exportAsDrag(comp, evt, TransferHandler.COPY);
                    }
                });
            }
            attemptsPanel.add(row);
        }

        // Painel de feedback (tentativas corretas)
        JPanel feedbackPanel = new JPanel(new GridLayout(8, 1));
        feedbackFields = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            feedbackFields[i] = new JTextField();
            feedbackFields[i].setEditable(false);
            feedbackPanel.add(feedbackFields[i]);
        }

        mainPanel.add(attemptsPanel);
        mainPanel.add(feedbackPanel);

        // Painel inferior com botões coloridos e campo de pontuação
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Painel de botões coloridos
        Choices choices = new Choices(4);

        // Campo de pontuação
        JPanel scorePanel = new JPanel(new FlowLayout());
        scorePanel.add(new JLabel("Score:"));
        scoreField = new JTextField(10);
        scoreField.setEditable(false);
        scorePanel.add(scoreField);

        bottomPanel.add(choices.getPanel(), BorderLayout.NORTH);
        bottomPanel.add(scorePanel, BorderLayout.SOUTH);

        // Botão de configuração
        JButton settingsButton = new JButton("Configurações");
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSettingsDialog();
            }
        });
        bottomPanel.add(settingsButton, BorderLayout.CENTER);

        // Botão para validar a tentativa
        JButton validateButton = new JButton("Validar Tentativa");
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAttempt();
            }
        });
        bottomPanel.add(validateButton, BorderLayout.EAST);

        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // private void generateSecretCode() {
    //     Random random = new Random();
    //     secretCode = new Color[4];
    //     for (int i = 0; i < 4; i++) {
    //         secretCode[i] = colors[random.nextInt(colors.length)];
    //     }
    // }

    private void validateAttempt() {
        if (currentAttempt >= 8) {
            JOptionPane.showMessageDialog(this, "Você esgotou todas as tentativas!");
            return;
        }

        int correctColorAndPosition = 0;
        int correctColorWrongPosition = 0;
        boolean[] usedInSecret = new boolean[4];
        boolean[] usedInAttempt = new boolean[4];

        for (int i = 0; i < 4; i++) {
            if (attemptFields[currentAttempt][i].getBackground().equals(secretCode[i])) {
                correctColorAndPosition++;
                usedInSecret[i] = true;
                usedInAttempt[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!usedInAttempt[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!usedInSecret[j] && attemptFields[currentAttempt][i].getBackground().equals(secretCode[j])) {
                        correctColorWrongPosition++;
                        usedInSecret[j] = true;
                        usedInAttempt[i] = true;
                        break;
                    }
                }
            }
        }

        feedbackFields[currentAttempt].setText("Pos: " + correctColorAndPosition + ", Cor: " + correctColorWrongPosition);
        currentAttempt++;

        if (correctColorAndPosition == 4) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você acertou o código!");
        }
    }

    private void showSettingsDialog() {
        JDialog settingsDialog = new JDialog(this, "Configurações", true);
        settingsDialog.setSize(300, 200);
        settingsDialog.setLayout(new BorderLayout());
        settingsDialog.setLocationRelativeTo(null);

        // Conteúdo da janela de configurações
        JPanel panel = new JPanel();
        panel.add(new JLabel("Configurações do jogo"));

        settingsDialog.add(panel, BorderLayout.CENTER);
        settingsDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MasterMind().setVisible(true);
        });
    }
}
