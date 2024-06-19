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

    public static PinoPB criaPinoPreto(){
        return new PinoPB(new Cor("BLACK",Color.BLACK));
    }

    public static PinoPB criaPinoBranco(){
        return new PinoPB(new Cor("WHITE",Color.WHITE));
    }

    public static PinoPB criaPinoVazio(){
        return new PinoPB(new Cor("GRAY",Color.WHITE));
    }

    public void setCor(Color cor) {
        this.cor = cor;
        this.setBackground(cor);
    }

}
