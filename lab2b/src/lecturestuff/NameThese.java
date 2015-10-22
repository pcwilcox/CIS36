package lect51;
public class NameThese {

    
    
    
    public static int ___1____(int[] values) {
        int rtn = values[0];
        int k = 1;
        while (k < values.length) {
            if (rtn < values[k]) {
                rtn = values[k];
            }
            k++;
        }
        return rtn;
    }
    
    public static int ____foreach1___ (int[] values) {
        int rtn = values[0];
        for (int v : values) {
            if (rtn < v) {
                rtn = v;
            }
        }
        return rtn;
    }

    
    
    
    
    
    public static void ___2____(int[] values) {
        int k = 0;
        while (k < values.length / 2) {
            int temp = values[k];
            values[k] = values[values.length - 1 - k];
            values[values.length - 1 - k] = temp;
            k = k + 1;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    private static boolean ___3____(int[] values) {
        int k = 0;
        while (k < values.length - 1) {
            if (values[k] > values[k + 1]) {
                return false;
            }
            k = k + 1;
        }
        return true;
    }

    
    
    
    
    
    
    private static int ___4____(int[] values, int a) {
        int k = 0;
        int n = 0;
        while (k < values.length) {
            if (values[k] == a) {
                n++;
            }
            k++;
        }
        return n;
    }

}
