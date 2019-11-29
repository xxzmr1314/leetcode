public class Main {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution(gas,cost));
    }
    private static int solution(int[] gas,int[] cost){
        int i ;
        int tempIndex ;
        int allGas = 0;
        int allCost = 0;
        boolean isWork = true;
        for( i = 0 ; i < gas.length ; i++ ){
            if( gas[i] < cost[i] ){
                continue;
            }else{
                allGas = gas[i] ;
                allCost = cost[i];
                for(int j = i ; j <= gas.length+i ; j++ ){
                    tempIndex = j ;
                    if( j >= gas.length ){
                        tempIndex = j - gas.length ;
                    }
                    allGas += gas[tempIndex];
                    allCost += cost[tempIndex];
                    if(allGas<allCost){
                        isWork = false;
                        break;
                    }
                }
            }
            if(isWork==true){
                return i;
            }
        }
        return -1;
    }
}