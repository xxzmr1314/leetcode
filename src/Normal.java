public class Normal {
    /**
     * 507、判断一个数是否是完美数,完美数即正整数除了本身意外的所有因子相加等于本身的数
     */
    public static boolean checkPerfectNumber(int num){
        int sum = 1;
        if (num<=1){
            return false;
        }
        for (int i = 2; i*i < num; i++) {//i*i是分界线，如果大于i的数，那他另一个因子肯定小于i，之前一定已经经历过了，例如2*7和7*2是一样的，因子都是2和7
            if (num%i==0){
                //如果正好是平方，则只取i一个因子
                if (num/i==i){
                    sum+=i;
                }else {
                    //非平方加入两个因子
                    sum+=i+num/i;
                }
            }
        }

        return sum==num;
    }


    /**
     * 实现将一个不限长度的十进制字符串转换成八进制字符串
     * @param shi
     */
    public static String change(double shi){
        String ba = "";
        while(shi>8){
            int origin = 8;
            int cifang = 0;
            while((int)shi/origin>0){
                origin*=8;
                cifang++;
            }
            double temp = Math.pow(8,cifang);
            ba+=(int)shi/temp;
            shi-= temp*((int)shi/temp);
            if ((int)shi!=0){
                ba+=shi;
            }
        }


        return ba;
    }
}
