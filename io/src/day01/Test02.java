package day01;


import org.junit.Test;


import javax.swing.text.html.parser.Entity;
import java.awt.geom.Point2D;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test02 {

    /**
     * ���л�
     */
    @Test
    public void test01() {
        try (var out = new ObjectOutputStream(new FileOutputStream("F:/zzz/employee01.txt"));) {

            var e1 = new Employee("jack", 18, 5000);
            var e2 = new Employee("����", 20, 8000);
            out.writeObject(e1);
            out.writeObject(e2);
            out.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �����л�
     */
    @Test
    public void test02() {
        try (var in = new ObjectInputStream(new FileInputStream("F:/zzz/employee01.txt"));) {

            HashSet<Employee> employees = new HashSet<>();
            Employee e;
            while ((e = (Employee) in.readObject()) != null) {
                employees.add(e);
            }

            System.out.println(employees);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���л�ͬ��ͬ����
     */
    @Test
    public void test03() {

        try (var out = new ObjectOutputStream(new FileOutputStream("F:/zzz/manager01.dat"));) {
            Employee e = new Employee("Jack", 18, 5000);
            Manager m1 = new Manager(e);
            Manager m2 = new Manager(e);
            out.writeObject(m1);
            out.writeObject(m2);
            out.writeObject(null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �����л���ͬ���������ͬһ���ڴ��ַ
     */
    @Test
    public void test04() {

        try (var in = new ObjectInputStream(new FileInputStream("F:/zzz/manager01.dat"))) {
            ArrayList<Manager> managers = new ArrayList<>();
            Manager m;
            while ((m = (Manager) in.readObject()) != null) {
                managers.add(m);
            }
            System.out.println(managers);
            System.out.println(managers.get(0).getSecretary() == managers.get(1).getSecretary());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * �޸�Ĭ�ϵ����л�����
     * �ڿ����л�������� private ��ǩ������ writeObject �� readObject
     * ��������� writeObject �� readObject ����ʱ�����ø����еĶ�Ӧ����
     */
    @Test
    public void test05() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:/zzz/label.dat"));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:/zzz/label.dat"))
        ){
            LabeledPoint game = new LabeledPoint("game", new Point2D.Double(3, 4));
            out.writeObject(game);
            System.out.println(in.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * java.util.Date ��Ҳ����� readObject �� writeObject ǩ���ķ���
     */
    @Test
    public void test06(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:/zzz/date01.dat"));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:/zzz/date01.dat"));
        ){
            Date date = new Date();
            out.writeObject(date);
            System.out.println(in.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test07(){
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI("http://www.baidu.com")).GET().build();
            HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> send = httpClient.send(httpRequest, stringBodyHandler);
            System.out.println(send.body());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
