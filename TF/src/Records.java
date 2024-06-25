import java.io.*;

public class Records {
    
    private static final String ARQUIVO_DE_RECORDES = "records.txt";
    
    public static void salvarRecordes(int score) {
        try (FileWriter fw = new FileWriter(ARQUIVO_DE_RECORDES, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Recorde: " + score + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void lerRecordes() {
        try (FileReader fr = new FileReader(ARQUIVO_DE_RECORDES);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de recordes não encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
