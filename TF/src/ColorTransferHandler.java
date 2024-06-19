import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

class ColorTransferHandler extends TransferHandler {
    private static final DataFlavor colorFlavor = new DataFlavor(Cor.class, "A Color Object");

    @Override
    protected Transferable createTransferable(JComponent c) {
        if (c instanceof PinoColorido) {
            PinoColorido pino = (PinoColorido) c;
            return new ColorTransferable(pino.getCor());
        }
        return null;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY;
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        return support.isDataFlavorSupported(colorFlavor);
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
        if (!canImport(support)) {
            return false;
        }
        try {
            Cor cor = (Cor) support.getTransferable().getTransferData(colorFlavor);
            JComponent comp = (JComponent) support.getComponent();
            if (comp instanceof PinoColorido) {
                ((PinoColorido) comp).setCor(cor);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static class ColorTransferable implements Transferable {
        private final Cor cor;

        public ColorTransferable(Cor cor) {
            this.cor = cor;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{colorFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return colorFlavor.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) {
            if (!isDataFlavorSupported(flavor)) {
                return null;
            }
            return cor;
        }
    }
}
