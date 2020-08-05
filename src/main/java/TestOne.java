import Tool.Times;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 吴昊
 *  一、 代码实现以下方法
 *  入参:50 万个不重复的整数。
 *  出参:随机返回 10 万个不重复的整数。
 * 要求:
 *  执行时间尽可能少。
 */
public class TestOne {
    /**
     * 生成随机数
     * @param n 随机数个数
     * @param m 返回的个数
     * @return m
     */
    public static String CreateNum(int n,int m){
        if(m>n){
            return null;
        }
        /**
         * 生成n个不重复的随机整数
         */
        int[] num = new int[n];
        int[] returnNum = new int[m];
        for (int i =0; i<n ; i++){
            num[i] = i;
        }
        Random random = new Random();
        for (int i =0; i<n ; i++){
            //生成随机[0-n)之间的随机数,但不包括n
           int temp = random.nextInt(n-i)+i;
           //根据数组下标打乱数组顺序
           int t = num[temp];
            num[temp] = num[i];
            num[i] = t;
        }
        System.arraycopy(num,0,returnNum,0,m);
        return Arrays.toString(returnNum);
    }

    public static void main(String[] args) {
        /**
         * n: 生成随机数的个数
         * m: 希望返回的个数
         */
        Times.test("随机生成五万个随机数返回1万个",()->{
            String s = CreateNum(50000,10000);
            System.out.println(s);
        });
    }
}
