package yxxy.c_023;

import java.io.*;

/**单例模式之:枚举实现
 * @author WangLe
 * @date 2019/11/19 10:39
 * @description
 * 注意: 使用枚举来实现单例模式,好处是序列化以后不会让单例失效
 * 场景: 创建了一个对象以后,将其序列化存到硬盘以后,反序列化以后,原来的对象和序列化以后的对象是同一个对象,符合单例模式得定义
 * 即:任何时候在内存中都只用一个该类的实例存在
 */
public enum Singleton2 implements Serializable {
    INSTANCE("zhangsan");
    private String name;

    public static Long getMills() {
        return System.currentTimeMillis();
    }

    Singleton2(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton2 singleton2 = Singleton2.INSTANCE;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\test\\test"));
        oos.writeObject(singleton2);
        oos.flush();
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\test\\test"));
        Singleton2 o = (Singleton2) ois.readObject();

        System.out.println(o.getName());
        System.out.println(o == singleton2);
    }


}
