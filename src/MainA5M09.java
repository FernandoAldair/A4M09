import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Scanner;

public class MainA5M09 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //1.1-----------------------------------------------------------
        System.out.println("1.1----------------------");

        KeyPair clave = Xifrar.randomGenerate(1024);
        System.out.printf("Introduce texto: ");
        String textoDeEjemplo = scanner.nextLine();

        System.out.println("Texto Cifrado");
        byte[] textoCifrado = Xifrar.encryptData(textoDeEjemplo.getBytes(StandardCharsets.UTF_8), clave.getPublic());
        String texto1 = new String(textoCifrado);
        System.out.println(texto1);
        System.out.println(clave.getPublic().toString());
        System.out.println();

        System.out.println("Texto Descifrado");
        byte[] textoDescifrado = Xifrar.decryptData(textoCifrado, clave.getPrivate());
        String texto2 = new String(textoDescifrado);
        System.out.println(texto2);
        System.out.println(clave.getPrivate().toString());
        System.out.println();

        //1.2----------------------------------------------------------------------

        //1.3----------------------------------------------------------------------

        //1.4----------------------------------------------------------------------

        //1.5-----------------------------------------------------------
        System.out.println("1.5----------------------");
        byte[] alda = "alda.ks".getBytes();
        PrivateKey privKey = clave.getPrivate();
        byte[] firma = Xifrar.signData(alda,privKey);
        System.out.println(new String(firma));

        //1.6-----------------------------------------------------------
        System.out.println("1.6----------------------");
        PublicKey publicKey = clave.getPublic();
        boolean verificado = Xifrar.validateSignature(alda,firma,publicKey);
        if(verificado == true) {
            System.out.println("Valida");
        }else System.out.println("No es valida");;

        //2.1----------------------------------------------------------------------

        //2.2----------------------------------------------------------------------
        System.out.println("2.2----------------------");
        byte [] TextoeDEjemplo = "Pollo".getBytes();
        KeyPair keypair = Xifrar.randomGenerate(1024);
        PrivateKey privatekey = keypair.getPrivate();
        PublicKey publickey = keypair.getPublic();
        byte [][] encWrappedData = Xifrar.encryptWrappedData(TextoeDEjemplo, publickey);

        System.out.println("Mensaje Encriptado: ");
        System.out.println(new String(encWrappedData[0]));

        System.out.println("Clave Encriptada: ");
        System.out.println(new String(encWrappedData[1]));

        byte [] decWrappedData = Xifrar.decryptWrappedData(encWrappedData, privatekey);
        System.out.println("Mensaje original desencriptado: ");
        System.out.println(new String(decWrappedData));
    }
}
