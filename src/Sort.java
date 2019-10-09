import java.util.*;

/**
 * 排序相关问题
 */
public class Sort {


    /**
     * 排序
     * @param nums 乱序数组
     * 最简单的方式，调用java自带的方法进行排序，是插入排序、快速排序、归并排序多种集合
     * 判断方法
     * @return
     */
    public static int[] QuickSortOrigin(int[] nums){
        Arrays.sort(nums);
        return null;
    }

    /**
     * 手写快速排序：快速排序的原理其实就是找基准点，使得基准点左边的所有数字都<=它，右边的都>=它,然后递归执行
     * @param nums
     * @return
     */
    public static void QuickSort(int[] nums,int low,int high){
        int baseIndex,i,j,temp;
        if (low>high){
            return;
        }
        i = low;//数组最左端
        j = high;//数组最右端
        baseIndex = nums[low];//基准数
        while(i<j){//开始循环移动
            while(baseIndex<=nums[j]&&i<j){//从右边开始遇到比基准小的就停住
                j--;
            }
            while(baseIndex>=nums[i]&&i<j){//从左边开始遇到比基准大的就停住
                i++;
            }
            if(i<j){//两边都停住之后，如果右边的指针大于左边，就交换两个指针位置的量
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //循环结束，即两个指针相遇了，把基准位和相遇位交换
        nums[low] = nums[j];
        nums[j] = baseIndex;

        //递归调用
        QuickSort(nums,low,j-1);
        QuickSort(nums,j+1,high);
    }

    /**
     * 归并排序，待写
     * @param arry
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arry,int start,int end){
        if (start<end){

        }
    }




    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap();
        for(int i =0;i<nums.length;i++){
            if (map.get(nums[i])==null)
                map.put(nums[i],1);
            else
                map.put(nums[i],map.get(nums[i])+1);
        }
        for (int i=0;i<k;i++){
            int max = 0;
            int maxKey=0;
            for (Integer key :map.keySet()) {
                int value = map.get(key);
                if (value>max){
                    max = value;
                    maxKey = key;
                }
            }
            list.add(maxKey);
            map.remove(maxKey);
        }
        return list;
    }


    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。例如tree 输出eert或者eetr
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        int[] temp = chars.clone();

        Arrays.sort(temp);
        int max = 255;
        while (temp[max]>0){
            for (int i = 0; i < chars.length; i++) {
                if (temp[max]==chars[i]){
                    while(chars[i]-->0){
                        sb.append((char)i);
                    }
                }
            }
            max--;
        }
        return sb.toString();
    }




}
