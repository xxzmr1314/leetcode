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
     * 直接插入排序 O(n^2)
     * 每次循环都保证前面的序列是有序的，新的数进来就和前面的有序序列比较，找到自己最适合的位置插进去。
     * 第一种是通过交换两个数的位置来找到合适的位置插入
     */
    public static void InsertSort1(int[] nums){
        for (int i = 0; i < nums.length-1 ; i++) {
            for (int j = i+1; j >0 ; j--) {
                if (nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
    }
    /**
     * 第二种是通过将比目标插入值大的数统统往右移动的方式
     */
    public static void InsertSort2(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int j ;
            for (j = i; j>0&&nums[j-1]>num ; j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = num;
        }

    }

    /**
     * 折半插入排序
     */
    public static void BinaryInsertSort(int[] arr){
        int low,high,m,temp;
        for(int i = 1;i<arr.length;i++){
            //折半查找应该插入的位置
            low = 0;
            high = i-1;
            while(low <= high){
                m = (low+high)/2;
                if(arr[m] > arr[i])
                    high = m - 1;
                else
                    low = m + 1;
            }
            //统一移动元素，然后将这个元素插入到正确的位置，因为找到了插入的区域，所以那个区域往右的值都要向右挪一位
            temp = arr[i];
            for(int j=i;j>high+1;j--){
                arr[j] = arr[j-1];
            }
            arr[high+1] = temp;
        }
    }


    /**
     * 希尔排序 O(n)至O(n^2)
     */
    static void InsertSort_gap(int[] nums,int start,int gap){
        for (int i = start+gap;i<nums.length;i=i+gap){
            int num = nums[i];
            int j ;
            for (j = i; j > gap&&nums[j-gap]>num ; j=j-gap) {
                nums[j] = nums[j-gap];
            }
            nums[j] = num;
        }
    }
    static void shellSort(int[] nums,int gaps[],int m){
        int gap;
        for (int i=m-1;i>=0;i--){
            gap = gaps[i];
            for (int start = 0;start<gap;start++){
                InsertSort_gap(nums,start,gap);
            }
        }
    }


    /**
     * 简单选择排序  O(n^2)
     * 每次找出最小的放在前面就可以了
     */
    public static void SelectSort(int[] nums){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    nums[i] = nums[j];
                }
            }
        }
    }

    /**
     * 手写二分查找
     */
    public static int BinarySearch(int[] nums,int target){
        int l=0,r = nums.length-1;//在[l.....r]范围内查找target
        while(l<=r){
            int mid = l+(r-l)/2;//避免整形溢出，用左边加上两者中间的一般
            if (nums[mid]==target) return mid;
            if (nums[mid]>target){
                r = mid - 1;
            }else{
                l = mid +1;
            }
        }
        return -1;
    }



    /**
     * O(nlogn)
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
     * 选择排序
     * @param arry
     */
    public static void SelectionSort(int[] arry){
        for (int i = 0; i < arry.length-1; i++) {
            for (int j = i+1; j < arry.length; j++) {
                if (arry[j]<arry[i]){
                    //如果发现后面的数比较小。就交换
                    int temp = arry[i];
                    arry[i] = arry[j];
                    arry[j] = temp;
                }
            }
        }
    }

    /**
     * 归并排序，O(nlogn)
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


    /**
     * 283、移动零元素
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int notNullIndex = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[notNullIndex++] = nums[i];
            }
        }
        for(int j = notNullIndex; j<nums.length;j++){
            nums[j] = 0 ;
        }
    }




}
