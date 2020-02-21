package app;

public class ianBrokeIt {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(findMine(arr, 8));
        System.out.println(binarySearch(arr, 8));
        
    }
    
    /**
     * This is Ian's attempt to sort. It seems to be stuck in some sort of infinite loop.
     * The to do comments are my suggestions.
     *
     * @param arr The Array to search through.
     * @param num The number to search for.
     * @return The index of the requested number.
     */
    public static int binarySearch(int[] arr, int num) {
        // TODO just for organisation, I like to have all of my ints initialized at once.
        int mid = (arr.length - 1) / 2;
        int end = arr.length - 1;

        // TODO This isn't the bottom index - this is the first value, in this case 1
        int start = arr[0];

        // This is the initialization fixed.
//      int mid = (arr.length - 1) / 2, end = arr.length - 1, start = 0;
        
        // TODO This boolean could be changed - I used a do while loop instead of using the if statement you used, but
        //  you would have to change the value of this as well to ensure there's not an infinite loop.
        boolean indexReturned = false;
        
        // TODO This looks like it's an infinite loop - its argument doesn't ever change.
        while (indexReturned != true) {

            if (num < arr[mid]) {
                end = mid - 1;
                mid = end / 2;
                
                // TODO Why is this if statement here? You should just put it at the end of this while loop.
                if (mid == num) return arr[mid];
            } else if (num > arr[mid]) {
                start = mid + 1;
                
                // TODO This will create an error - This wouldn't be the mid value. This would be below the min value,
                //  meaning that the max becomes unusable.
                mid = start / 2;
                
                // TODO Why is this if statement here? You should just put it at the end of this while loop.
                if (mid == num) return arr[mid];
            }
            
            // TODO This if statement was created as a template. the only problem is that it's not actually returning
            //  what you want. Pay attention to your return statements.
//          if (mid == num) return arr[mid];
        }
        
        // This will only happen if you don't find a number.
        // TODO This should always get some sort of number - why does this have to be here?
        return -1;
    }
    
    /**
     * Another variation of Ian's method. May not be the most productive way to do it, but it should work.
     * Takes the length of the array and divides sentinels by half each time. They will always end equal to each other,
     *  which is equal to the index of the requested number.
     *
     * This only works if the Array is sorted from least to greatest.
     *
     * @param e The Array to search through.
     * @param num The number to search for.
     * @return The index of the requested number.
     */
    public static int findMine(int[] e, int num) {
        // Create sentinel numbers - these will keep track of the the maximum length and the minimum length.
        int min = 0, max = e.length - 1, mid = e.length / 2;
        
        // This loop will only run while the indexes are not equal to each other - when they are equal, they will be the
        // closest they can get to the requested number. It will also check once before it evaluates the arguments,
        // meaning that it could eliminate areas before anything happens.
        do {
           if(e[mid] < num) {
               max = mid - 1;
               mid = max / 2;
           } if(e[mid] > num) {
               min = mid + 1;
               mid = (max - min) / 2;
           }
        } while(max != min);
        
        // Return the index of the number that is closest to the requested number.
        return max;
    }

}
