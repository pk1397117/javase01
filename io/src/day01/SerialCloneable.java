package day01;

import java.io.*;

/**
 * 序列化深克隆
 */
public class SerialCloneable implements Cloneable, Serializable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = null;
        try (var data = new ByteArrayOutputStream();
             var out = new ObjectOutputStream(data);
        ){
            //序列化对象到字节数组输出流
            out.writeObject(this);
            try (var in = new ObjectInputStream(new ByteArrayInputStream(data.toByteArray()));){
                //反序列化字节数组输出流中字节数组为对象
                o = in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
