package utils;

public class Utils {
    public Utils(){

    }

    public int getMinIndex(int[] arr){
        int min = arr[0];
        int index = 0;
        for(int i=1; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
