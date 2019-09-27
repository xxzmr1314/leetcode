import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       /* int[] list = {1,3,5,7,9};
        ShuangZhiZhen.TwoSum(list,16);*/

       /*if (ShuangZhiZhen.SumOfSquareNumbers(14)){
           System.out.println("是的呀");
       }else{
           System.out.println("可惜不是哦");
       }*/
/*
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        ShuangZhiZhen.merge(nums1,3,nums2,3);
        for (int i= 0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
*/
        String s = "bab";
        List<String> d = new ArrayList<>();
        d.add("ba");
        d.add("ab");
        d.add("a");
        d.add("b");
        System.out.println(ShuangZhiZhen.longSon(s,d));




    }
}
