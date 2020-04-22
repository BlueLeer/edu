package yxxy.c_021;

/**
 * @author WangLe
 * @date 2019/11/19 16:26
 * @description
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(0 >> 1);

        String[] src = {"1", "2", "3", "a", "b", "c"};
        String[] des = new String[10];
        System.arraycopy(src, 2, des, 2, 3);
        for (String de : des) {
            System.out.println(de);
        }
    }
}
