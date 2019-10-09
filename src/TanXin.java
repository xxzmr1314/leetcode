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

}
