
package yxxy.c_022;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 * <p>
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 * <p>
 * 运行下面的程序，理解ThreadLocal
 *
 * @author 马士兵
 */
public class ThreadLocal2 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();
    static ThreadLocal<Room> tlRoom = new ThreadLocal<>();
    

    public static void main(String[] args) {
        Person p = new Person("张三");
        Room room = new Room("北京市朝阳区");
        tl.set(p);
        tlRoom.set(room);
        new Thread(() -> {
            Person pp = new Person("李四");
            Room room1 = new Room("重庆市江北区");
            tl.set(pp);
            tlRoom.set(room1);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("t1-people: "+tl.get().toString());
            System.out.println("t1-room: "+tlRoom.get().toString());

        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main-people: "+tl.get().toString());
        System.out.println("main-room: "+tlRoom.get().toString());
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    
    static class Room{
        String address;

        public Room(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "address='" + address + '\'' +
                    '}';
        }
    }
}


