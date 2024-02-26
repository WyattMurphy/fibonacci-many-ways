import java.util.LinkedHashMap;
import java.util.Map;
/*
 * Memoized Fibonacci using LinkedHashMap Cache
 * @author wyttm
 */
public class FibMemo {
    // global map to store previously calculated sequence elements
    public static Map<Integer, Long> theMap;

    public static long fibMemo(Integer n_fib) {
        // base case
        if (n_fib <= 1) {
            return n_fib;
        }
        // checking cache for computed value
        else if (theMap.containsKey(n_fib)) {
            return theMap.get(n_fib);
        }
        Long result = fibMemo(n_fib - 1) + fibMemo(n_fib - 2);
        theMap.put(n_fib, result);

        return result;
    }

    public static void main(String[] args) {
        // build cache
        theMap = new LinkedHashMap<Integer, Long>() {
            private static final int MAX_ENTRIES = 15;

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Long> eldest) {
                return size() > MAX_ENTRIES;
            }
        };

        int[] values = { 5, 13, 21, 30, 45 };
        for (int i = 0; i < values.length; i++) {
            Integer n = Integer.valueOf(values[i]);
            // start watch
            long begin = System.currentTimeMillis();
            // method call
            long nfib = fibMemo(n);
            // end watch
            long end = System.currentTimeMillis();
            // calculate diff
            long time = end - begin;
            // print
            System.out.println("Fib Number " + n + " = " + nfib + "( " + time + "ms)");
        }
    }

}
