package day01;

import java.io.*;

/**
 * ���л����¡
 */
public class SerialCloneable implements Cloneable, Serializable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = null;
        try (var data = new ByteArrayOutputStream();
             var out = new ObjectOutputStream(data);
        ){
            //���л������ֽ����������
            out.writeObject(this);
            try (var in = new ObjectInputStream(new ByteArrayInputStream(data.toByteArray()));){
                //�����л��ֽ�������������ֽ�����Ϊ����
                o = in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
