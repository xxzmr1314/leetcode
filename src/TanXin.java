import java.util.*;

public class TanXin {

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *  455
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while(i<g.length&&j<s.length){
            if (s[j]>=g[i]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    /**
     * 435、给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(intervals,new Comparator<int [] >(){
            public int compare(int [] a1,int [] a2) {
                return a1[0] - a2[0];   //升序排列
            }
        });
        int index1 = 0;
        int index2 =1;
        while(index2<intervals.length){
            if (intervals[index1][1]>intervals[index2][0]){
                count++;
                if (intervals[index1][1]>=intervals[index2][1]){
                    index1=index2;
                    index2++;
                }else{
                    index2++;
                }
            }else{
                index1=index2;
                index2++;
            }
        }


        return count;
    }


    /**
     * 425、用最少的数量引爆气球
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length<2){
            return points.length;
        } else{
           //先对数组进行排序,根据起点来排
            Arrays.sort(points,(p1,p2)-> p1[0]-p2[0]);
            int num = 1;
            int end = points[0][1];//设置一个最远标志位，先赋值第一个区间的终点
            for (int i = 1; i < points.length; i++) {
               if (points[i][0]<=end){
                   end = Math.min(end,points[i][1]);
               }else{
                   num++;
                   end = points[i][1];
               }
            }
            return num;
        }

    }

    /**
     * 406、根据身高重建队列
     * 解法：先将队列按身高降序以及前面人数升序排列，然后再一个个插入
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i:people) {
            list.add(i[1],i);
        }
        return list.toArray(new int[list.size()][2]);//将list转换成数组
    }

    /**
     * 121、买卖股票的最佳时机
     * 本题的核心思想是，从后往前遍历，因为利润就是用后面的数-前面的数，然后尽量找到最大的数，因为用后面的最大的数来-前面的数才有可能得到最大利润
     * 在循环过程中，如果遇到比当前最大数更大的数就替换，如果遇到比当前最大利润更大的数也替换
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;
        for(int i = prices.length-1;i>=0;i--){//从后往前遍历
            if (prices[i]>max){
                max = prices[i];//遇到比最大值更大的数就赋值
            }
            if ((max - prices[i])>profit){
                profit = max - prices[i];
            }
        }
        return profit;
    }

    /**
     * 122、买卖股票的最佳时机2
     * 尽可能多买卖就可以了
     */
    public static int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = prices.length-1;i>=1;i--){
            if (prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }

    /**
     * 605、种植花朵
     */

}
