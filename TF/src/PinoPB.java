import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.TransferHandler;

public class PinoPB extends Pino{
    private Color cor;

    protected PinoPB(Cor cor) {
        super(cor);
        this.cor = cor.getCor();
        this.setOpaque(true); // Necessário para que a cor de fundo seja aplicada
        this.setBackground(this.cor); // Aplica a cor de fundo inicial
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adiciona uma borda para visualização
        this.setPreferredSize(new java.awt.Dimension(50, 50)); // Define o tamanho do componente
        this.setTransferHandler(new TransferHandler("background"));
    }

    public static PinoPB criaPinoPreto(){ // cor certa na posicao certa
        return new PinoPB(new Cor("BLACK",Color.BLACK));
    }

    public static PinoPB criaPinoBranco(){ // cor certa na posicao errada
        return new PinoPB(new Cor("WHITE",Color.WHITE));
    }

    public static PinoPB criaPinoVazio(){
        return new PinoPB(new Cor("GRAY",Color.GRAY));
    }

    public void setCor(Color cor) {
        this.cor = cor;
        this.setBackground(cor);
    }

    // @Override
    // protected void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     Graphics2D g2d = (Graphics2D) g.create();
    //     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    //     int diameter = Math.min(getWidth(), getHeight());
    //     int x = (getWidth() - diameter) / 2;
    //     int y = (getHeight() - diameter) / 2;

    //     // Desenha o círculo preenchido com a cor atual
    //     g2d.setColor(cor);
    //     g2d.fillOval(x, y, diameter, diameter);

    //     // Desenha a borda do círculo
    //     g2d.setColor(Color.BLACK);
    //     g2d.drawOval(x, y, diameter, diameter);

    //     g2d.dispose();
    // }

}
