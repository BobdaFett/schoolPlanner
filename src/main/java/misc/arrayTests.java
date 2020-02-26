package misc;

public class arrayTests {

    public static int max(int[][] a) {
        int max = 0;
        for(int[] i : a)
            for(int j : i)
                max = (j < max) ? j: max;

        return max;
    }

    public static int rowSum(int[][] a, int x) {
        int sum = 0;
        for(int i : a[x])
            sum += i;
        return sum;
    }

    public static int columnSum(int[][] a, int x) {
        int sum = 0;
        for(int i = 0; i < a.length; i++) sum += a[i][x];
        return sum;
    }

    public static boolean isSquare(int[][] a) {
        int[] temp = a[0];
        for(int[] i : a)
            if(i.length != temp.length) return false;
        return true;
    }

    public static boolean isMagic(int[][] a) {
        if(!isSquare(a)) return false;

        int temp = rowSum(a, 0);
        for(int i = 0; i < a.length; i++)
            if(temp != rowSum(a, i)) return false;

        int tempC = columnSum(a, 0);
        for(int i = 0; i < a.length; i++)
            if(temp != columnSum(a, i)) return false;

        // TODO need to make a way to get the diagonal sums.

        return true;
    }

}
