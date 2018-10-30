public class number {
    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            int sum=0;
            for(int j=1;j<i;j++){
                if(i%j==0){
                    sum=sum+j;
                }
            }
            if(i==sum){
                System.out.println("完数为"+sum);
            }
        }
    }
}
