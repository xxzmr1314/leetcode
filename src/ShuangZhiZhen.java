import java.util.List;

/**
 * 双指针相关问题
 */
public class ShuangZhiZhen {


    /**
     * 两个指针，要求从List中取到两个值，使得它们的和等于target
     * @param list
     * @param target
     * @return
     */
    public static void TwoSum (int[] list,int target){
        for(int i = 0;i<list.length;++i){
            for (int k=list.length-1;k>i;--k){
                if ((list[i]+list[k])==target){
                    System.out.println("两个指针分别是"+i+"和"+k);
                }
            }
        }
    }

    /**
     * 判断一个数是否为两个数的平方和
     * @param c
     * @return
     */
    public static boolean SumOfSquareNumbers(int c){
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                //如果两个数和大于目标数，则将大指针即目标数往前移
                j--;
            } else {
                //如果两个数的和小于目标书，则将小指针即0往后移
                i++;
            }
        }
        return false;
    }


    /**
     * 归并两个有序数组 m为数组a的大小(不包含0元素)，n为b的大小
     * @param
     * @param
     * @return
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //宗旨就是谁大就把谁塞到后边，同时让游标减1，谁的游标成为负数了说明没有了，就直接把另一个数组的塞到末尾就行了。
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    /**
     * 最长子序列
     */
    public static String longSon(String s , List<String> d){
        String longer="";
        for(String target : d){
            if(target.length()>s.length()||target.length()<=longer.length()){//如果列表中的字符串长于给出的字符串或者短于已经得出的序列，直接判断下一个
                continue;
            }
            int i=0;
            int j=0;
            while(i<s.length()&&j<target.length()){
                if(s.charAt(i)==target.charAt(j)){
                    i++;
                    j++;
                    continue;
                }
                i++;
            }
            if(j==target.length()){
                longer=target;
            }
        }
        return longer;
    }







}
