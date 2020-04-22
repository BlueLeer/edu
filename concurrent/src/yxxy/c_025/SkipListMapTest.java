package yxxy.c_025;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author WangLe
 * @date 2019/12/6 15:24
 * @description 关于ConcurrentSkipListMap的更多详细解释,
 * 参考: https://snailclimb.gitee.io/javaguide/#/docs/java/Multithread/%E5%B9%B6%E5%8F%91%E5%AE%B9%E5%99%A8%E6%80%BB%E7%BB%93
 */
public class SkipListMapTest  {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String,String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put("a","AAA");
        skipListMap.put("b","BBB");
        skipListMap.put("c","CCC");
        skipListMap.put("d","DDD");
        skipListMap.put("e","EEE");


    }
}
