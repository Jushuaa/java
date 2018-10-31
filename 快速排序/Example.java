public class Example{
   public static int Partition(int []arr,int start,int end){
       int key=arr[start];
        while(start<end){
            while(arr[end]>=key&&start<end){
                end--;
                arr[start] = arr[end];
            }
            while(arr[start]<=key&&start<end){
                start++;
			    arr[end] = arr[start];
            }
        }
        arr[start]=key;
        return start;
   }
   public static void quickSort(int []arr,int start,int end){
        if(start<end){
            int index = Partition(arr, start, end);
			quickSort(arr, start, index - 1);
			quickSort(arr, index + 1, end);
        }
   }
    public static void main(String [] args){
        int []arr=new int[]{72,6,57,88,60,42,83,73,48,85};
        int start=0;
        int end=9;
        quickSort(arr,0, 9);
        for (int i = 0; i < 9; i++) {
            System.out.println(arr[i]);
        }
    }     
} 