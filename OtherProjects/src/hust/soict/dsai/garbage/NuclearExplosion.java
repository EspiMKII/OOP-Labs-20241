/*
We are told to read the fat line of garbage in supergarbage.txt into a string in this program
and measure the time it takes to do so
=> we can use BufferedReader (and FileReader) to read the file
=> we can use System.currentTimeMillis() to measure the time
=> This assignment is kinda indirectly telling my computer to kill itself that's why im calling this program NuclearExplosion instead of NoGarbage (as required by the lab assignment)
=> For the sake of me still being able to game on this craptop supergarbage.txt has "only" 1e8 characters
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NuclearExplosion {
    public static void main(String[] args) {
        String directory = "C:\\Users\\name\\OneDrive\\Máy tính\\OOP-Labs-20241\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\supergarbage.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(directory))) {
            String s = "";
            char c;

            long start = System.currentTimeMillis();
            System.out.println("Reading the file...");
            /* with + operator (warning: Nuclear Explosion) */
            // while ((c = (char) br.read()) != ' ') {
            //     s += c;
            // } 
            // System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

            /* with StringBuilder */
            // start = System.currentTimeMillis();
            // StringBuilder sb = new StringBuilder();
            // while ((c = (char) br.read()) == ' ') {
            //     sb.append(c);
            // }
            // s = sb.toString();
            // System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

            /* with StringBuffer */
            start = System.currentTimeMillis();
            StringBuffer sbf = new StringBuffer();
            while ((c = (char) br.read()) == ' ') {
                sbf.append(c);
            }
            s = sbf.toString();
            System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

        } catch (IOException e) {
        e.printStackTrace();
        }   
    }
}