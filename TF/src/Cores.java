
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cores {

    private Map<String, Cor> cores;
    private static Cores instancia = null;

    public static Cores getInstance() {
        if (instancia == null) {
            instancia = new Cores();
        }
        return instancia;
    }

    private Cores() {
        cores = new HashMap<>();
        cores.put("RED", new Cor("RED", Color.RED));
        cores.put("GREEN", new Cor("GREEN", Color.GREEN));
        cores.put("YELLOW", new Cor("YELLOW", Color.YELLOW));
        cores.put("BLUE", new Cor("BLUE", Color.BLUE));
        cores.put("MAGENTA", new Cor("MAGENTA", Color.MAGENTA));
        cores.put("ORANGE", new Cor("ORANGE", Color.ORANGE));
        cores.put("GRAY", new Cor("GRAY", Color.GRAY));
        cores.put("PINK", new Cor("PINK", Color.PINK));
        cores.put("CYAN", new Cor("CYAN", Color.CYAN));
    }

    public Cor getCor(String key) {
        return cores.get(key);
    }

    public String[] getNomeCores() {
        Set<String> keys = cores.keySet();
        return keys.toArray(new String[0]);
    }
}
