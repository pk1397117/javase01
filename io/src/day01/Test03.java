package day01;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test03 {
    /**
     * ���л����������Ͱ�ȫ��ö��
     */
    @Test
    public void test01(){
        try (var out = new ObjectOutputStream(new FileOutputStream("F:/zzz/orientation.dat"));
             var in = new ObjectInputStream(new FileInputStream("F:/zzz/orientation.dat"));
        ){
            Orientation horizontal = Orientation.HORIZONTAL;
            Orientation vertical = Orientation.VERTICAL;
            out.writeObject(horizontal);
            out.writeObject(vertical);
            Object o1 = in.readObject();
            Object o2 = in.readObject();
            // ��Orientation ��� readResolve �����Է���ǡ����ö�ٳ���
            System.out.println(horizontal == o1);//true
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡserialVersionUID
     */
    @Test
    public void test02() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Orientation> clazz = Orientation.class;
        Orientation orientation = Orientation.HORIZONTAL;
        Field serialVersionUID = clazz.getDeclaredField("serialVersionUID");
        serialVersionUID.setAccessible(true);
        System.out.println(serialVersionUID.get(orientation));
        Field value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        value.set(orientation,5);
        System.out.println(value.get(orientation));
        //��ȡ�����ֶ�
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("------------------------");

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
            for (Parameter parameter : declaredMethod.getParameters()) {
                System.out.println(parameter.getName());
            }
        }
        System.out.println("------------------------");

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
            for (Parameter parameter : declaredConstructor.getParameters()) {
                System.out.println(parameter.getType());
            }

        }
    }

    /**
     * ʹ�����л��������¡
     */
    @Test
    public void test03() throws CloneNotSupportedException {
        Employee e = new Employee("����", 18, 5000);
        Employee e1 = (Employee) e.clone();
        System.out.println(e1);
        System.out.println(e == e1);
    }
}
