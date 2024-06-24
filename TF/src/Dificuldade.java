
public enum Dificuldade {
    FACIL(10, 4, 4),
    MEDIO(10, 4, 6),
    DIFICIL(10, 4, 8);
    
    private final int tentativas;
    private final int pinos;
    private final int cores;
    
    private Dificuldade(int tentativas, int pinos, int cores) {
        this.tentativas = tentativas;
        this.pinos = pinos;
        this.cores = cores;
    }
    
    public int getTentativas() {
        return tentativas;
    }
    
    public int getPinos() {
        return pinos;
    }
    
    public int getCores() {
        return cores;
    }
}
