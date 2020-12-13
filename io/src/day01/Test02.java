package day01;


import org.jsoup.Jsoup;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.awt.geom.Point2D;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test02 {

    /**
     * 序列化
     */
    @Test
    public void test01() {
        try (var out = new ObjectOutputStream(new FileOutputStream("F:/zzz/employee01.txt"));) {

            var e1 = new Employee("jack", 18, 5000);
            var e2 = new Employee("张三", 20, 8000);
            out.writeObject(e1);
            out.writeObject(e2);
            out.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
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
     * 序列化同相同对象
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
     * 反序列化相同对象会引用同一个内存地址
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
     * 修改默认的序列化机制
     * 在可序列化类中添加 private 的签名方法 writeObject 和 readObject
     * 流对象调用 writeObject 和 readObject 方法时则会调用该类中的对应方法
     */
    @Test
    public void test05() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:/zzz/label.dat"));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:/zzz/label.dat"))
        ) {
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
     * java.util.Date 中也添加了 readObject 和 writeObject 签名的方法
     */
    @Test
    public void test06() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:/zzz/date01.dat"));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:/zzz/date01.dat"));
        ) {
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

    /**
     * 模拟浏览器http请求
     */
    @Test
    public void test07() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI("http://www.baidu.com")).GET().build();
            HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> send = httpClient.send(httpRequest, stringBodyHandler);
            System.out.println(send.body());
            System.out.println(Jsoup.parse(send.body()).select("title").text());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test08() {
        class Staff implements Serializable {
            //private static final long serialVersionUID = -4890795920968760343L;
            private String name;
            private double galaxy;
            private LocalDate hireDay;

            public Staff() {
            }

            public Staff(String name, double galaxy, LocalDate hireDay) {
                this.name = name;
                this.galaxy = galaxy;
                this.hireDay = hireDay;
            }


            private void writeObject(ObjectOutputStream out) throws IOException {
                out.writeUTF(name);
                out.writeDouble(galaxy);
                out.writeLong(hireDay.toEpochDay());
            }


            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
                this.name = in.readUTF();
                this.galaxy = in.readDouble();
                this.hireDay = LocalDate.ofEpochDay(in.readLong());
            }

            @Override
            public String toString() {
                return "Staff{" +
                        "name='" + name + '\'' +
                        ", galaxy=" + galaxy +
                        ", hireDay=" + hireDay +
                        '}';
            }
        }
        try (var out = new ObjectOutputStream(new FileOutputStream("F:/zzz/staff.txt"));
             var in = new ObjectInputStream(new FileInputStream("F:/zzz/staff.txt"))
        ) {
            Staff zhangsan = new Staff("张三", 5000, LocalDate.of(2008, 5, 20));
            out.writeObject(zhangsan);
            Staff lisi = (Staff) in.readObject();
            System.out.println(lisi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
