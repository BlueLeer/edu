package yxxy.c_025;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        // 将线程不安全的List转化成线程安全的同步List
        List<String> nameListSync = Collections.synchronizedList(nameList);
        
	}
}
