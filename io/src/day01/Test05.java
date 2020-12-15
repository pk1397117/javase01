package day01;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ŀ¼����
 */
public class Test05 {

    /**
     * Files.list
     * ���ʵ�ǰĿ¼���ļ��Լ�Ŀ¼
     * ���������Ŀ¼
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
     * ������ǰĿ¼�����ļ���Ŀ¼
     */
    @Test
    public void test02(){
        try (Stream<Path> resources = Files.walk(Paths.get("resources"))){
            resources.forEach(e -> System.out.println(e));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Files.find
     * ���ļ����Խ��й���
     */
    @Test
    public void test03(){
        try (Stream<Path> resources = Files.find(Paths.get("C:\\Users\\Administrator\\Desktop\\��ֽ"),5,(p, a) -> {
            //return a.size() == 2422791;
            try {
                return (Long)Files.getAttribute(p,"size") == 2422791;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        })){
            resources.forEach(e -> System.out.println(e));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ŀ¼��
     * glob�﷨
     */
    @Test
    public void test04(){
        try (final DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("C:\\Users\\Administrator\\Desktop\\��ֽ"),"*.zip")){
            for (Path path : paths) {
                System.out.println(path);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �ļ���
     * ��Ҫ����postVisitDirectory��visitFileFailed
     * ��������������򿪵�Ŀ¼���߲�������ʵ��ļ��ᱨ��
     */
    @Test
    public void test05() throws IOException {
        Files.walkFileTree(Paths.get("C:\\Users\\Administrator\\Desktop\\��ֽ"),new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("dir: "+dir);
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("file: "+file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });
    }

    /**
     * ZIP�ļ�ϵͳ
     * Paths.get �� fs.getPath ����
     */
    @Test
    public void test06(){
        try (FileSystem fs = FileSystems.newFileSystem(Paths.get("C:\\Users\\Administrator\\Desktop\\��ֽ\\webmagic-WebMagic-0.7.3.zip"), null);){
            Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (String.valueOf(dir.getFileName()).equals("webmagic-core")){
                        //System.out.println(dir);
                        return FileVisitResult.SKIP_SUBTREE;
                    }
                    //System.out.println(dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.SKIP_SUBTREE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
