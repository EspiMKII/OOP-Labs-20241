import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\name\\OneDrive\\Máy tính\\OOP-Labs-20241\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\supergarbage.txt"))) {
            Random rand = new Random();
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            char c;
            for (int i = 0; i < 1e8; i += 1) {
                c = alphabet.charAt(rand.nextInt(alphabet.length()));
                bw.write(c);
            }
            bw.write(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
