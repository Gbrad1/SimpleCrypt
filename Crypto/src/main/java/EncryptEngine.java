import java.io.*;
import java.util.Scanner;

public class EncryptEngine {

    public EncryptEngine() {}

    public static void main(String[] args) throws IOException {
       File file = new File("/Users/gbradford/Documents/Projects/SimpleCrypt/Crypto/src/resources/sonnet18.txt");
       Scanner scan = new Scanner(file);
       BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/gbradford/Documents/Projects/SimpleCrypt/Crypto/src/resources/sonnet18.enc"));

       ROT13 encryptionTool = new ROT13();

       String encryptedFile = "";
       while (scan.hasNextLine()) {
           String line = scan.nextLine();
           String encryptedLine = encryptionTool.encrypt(line);
           encryptedFile += encryptedLine + "\n";
           System.out.println(encryptedLine);
       }
       writer.write(encryptedFile);
       writer.close();
    }
}
