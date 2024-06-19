
public class PinoColorido extends Pino{

    protected PinoColorido(Cor cor) {
        super(cor);
        //setTransferHandler(new ColorTransferHandler());
    }

    public static PinoColorido criaPinoColorido(String nomeCor){
        Cor cor = Cores.getInstance().getCor(nomeCor);
        if (cor == null){
            throw new IllegalArgumentException("Cor invalida: "+nomeCor);
        }
        return new PinoColorido(cor);
    }
}