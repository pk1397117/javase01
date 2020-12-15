package day01;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 目录操作
 */
public class Test05 {

    /**
     * Files.list
     * 访问当前目录中文件以及目录
     * 不会访问子目录
     */
    @Test
    public void test01(){
        try (Stream<Path> resources = Files.list(Paths.get("resources"));){
            resources.forEach(e -> System.out.println(e));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Files.walk
     * 遍历当前目录所有文件与目录
     */
    @Test
    public void test02(){
        try (Stream<Path> resources = Files.walk(Paths.get("resources"))){
            resources.forEach(e -> {
                if (!Files.isDirectory(e))
                    System.out.println(e.getFileName());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test03(){
        
    }

}
