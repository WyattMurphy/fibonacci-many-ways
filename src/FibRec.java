/*
 * recursive fibonacci 
 * @author wyttm
 */

public class FibRec {

    /*
     * method that returns the nth fibonacci number
     */
    public static int fib_recursive(int n_fib) {
        // base case
        if (n_fib < 2) {
            return n_fib;
        }
        // recursive step
        else {
            return fib_recursive(n_fib - 1) + fib_recursive(n_fib - 2);
        }
    }

    public static void main(String[] args) {
        // get integers from string array args
        int[] values = { 5, 13, 21, 30, 45 };
        for (int i = 0; i < values.length; i++) {
            Integer n = values[i];
            // start watch
            long begin = System.currentTimeMillis();
            // method call
            int nfib = fib_recursive(n);
            // end watch
            long end = System.currentTimeMillis();
            // calculate diff
            long time = end - begin;
            // print
            System.out.println("Fib Number " + n + " = " + nfib + "( " + time + "ms)");
        }
    }
}