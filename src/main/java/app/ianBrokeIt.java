package app;

public class ianBrokeIt {

    public static int binarySearch(int[] arr, int num) {
        int mid = (arr.length - 1) / 2;
        int end = arr.length - 1;
        int start = arr[0];
        boolean indexReturned = false;

        while (indexReturned != true) {

            if (num < arr[mid]) {
                end = mid - 1;
                mid = end / 2;
                if (mid == num) return arr[mid];
            }

            else if (num > arr[mid])
            {
                start = mid + 1;
                mid = start / 2;
                if (mid == num) return arr[mid];
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.print(binarySearch(arr, 8));

    }

}
