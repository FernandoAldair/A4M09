import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainA4M09 {
    public static void main(String[] args) throws IOException {
        Xifrar xifrar = new Xifrar();

        // Ejercicio 1.5
        System.out.println("1.5:------------------------");
        String textoDejemplo1 = "Pollo";
        SecretKey secretKey1 = xifrar.keygenKeyGeneration(256);

        byte[] textoCifrado1 = xifrar.encryptData(textoDejemplo1.getBytes(), secretKey1);
        System.out.println("Texto cifrado:");
        System.out.println(textoCifrado1);

        byte[] textoDescifrado = xifrar.decryptData(textoCifrado1, secretKey1);
        String texto = new String(textoDescifrado);
        System.out.println("Texto descifrado:");
        System.out.println(texto);
        System.out.println();

        //Ejercicio 1.6
        System.out.println("1.6:------------------------");
        String textoDejemplo2 = "Pescado";
        String contra = "Aldair";

        SecretKey secretKey2 = xifrar.passwordKeyGeneration(contra, 256);

        System.out.println("Texto cifrado:");
        byte[] textocifrado2 = xifrar.encryptData(textoDejemplo2.getBytes(), secretKey2);
        System.out.println(textocifrado2);

        System.out.println("Texto descifrado:");
        byte[] textoDescifrado2 = xifrar.decryptData(textocifrado2, secretKey2);

        String texto2 = new String(textoDescifrado2);
        System.out.println(texto2);
        System.out.println();

        //Ejercicio 1.8
//        System.out.println("1.8:------------------------");
//        String contra2 = "Fernando";
//
//        SecretKey secretKey3 = xifrar.passwordKeyGeneration(contra2, 256);
//
//        try{
//            byte[] textoDescifrado3 = xifrar.decryptData(textocifrado2, secretKey3);
//
//            String texto3 = new String(textoDescifrado3);
//            System.out.println(texto3);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Contraseña incorrecta");
//            System.out.println();
//        }

        //Ejercicio 2
        Path textocifrado = Paths.get("textamagat");
        Path claves = Paths.get("clausA4.txt");

        byte[] textoenbytes = Files.readAllBytes(textocifrado);
        List<String> claus = Files.readAllLines(claves);

        int i = 0;
        boolean correcta = false;

        while (!correcta){
            try {
                SecretKey cp = xifrar.passwordKeyGeneration(claus.get(i), 128);
                byte[] result = xifrar.decryptData(textoenbytes, cp);
                System.out.println(result.toString());

                System.out.println(claus.get(i));
                System.out.println(new String(xifrar.decryptData(textoenbytes, cp)));
                correcta = true;

            }catch (Exception e){
                i++;
                System.out.println("contrasenya incorrecta");
            }
        }
    }
}
