import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        // test the processing time to construct a random string using + operator, StringBuffer and StringBuilder. 
        Random r = new Random(123);
        
        // + operator
        System.out.println("Using + operator:");
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i += 1) {
            s += r.nextInt(2);
        }
        System.out.println( "Time taken: " + (System.currentTimeMillis() - start) + "ms" );

        // StringBuilder
        System.out.println("Using StringBuilder:");
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i += 1) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println( "Time taken: " + (System.currentTimeMillis() - start) + "ms" );

        // StringBuffer
        System.out.println("Using StringBuffer:");
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 65536; i += 1) {
            sbf.append(r.nextInt(2));
        }
        s = sbf.toString();
        System.out.println( "Time taken: " + (System.currentTimeMillis() - start) + "ms" );
    }

    /*
    Results:
    + operator: ~340 ms
    StringBuilder: 2 ms
    StringBuffer: 2 ms
    => Using StringBuilder and StringBuffer is much faster than using + operator for large amounts of concatenation.
     */
}
