import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainA4M09 {
    public static void main(String[] args) throws IOException {
        Xifrar xifrar = new Xifrar();

        Path ruta = Paths.get("/home/dam2a/Escriptori/A4/clausA4.txt");
        byte[] textamagat = Files.readAllBytes(ruta);

        File claves = new File("/home/dam2a/Escriptori/A4/clausA4.txt");
        FileReader fileReader = new FileReader(claves);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String string = bufferedReader.readLine();

        System.out.println("5:------------------");



//        while (string != null){
//            try {
//                //SecretKey clave =
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//

    }
}
