package day01;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * ÄÚ´æÓ³ÉäÎÄ¼þ
 */
public class Test06 {
    @Test
    public void test01(){
        try (FileChannel open = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Desktop\\±ÚÖ½"))){
            open.map(FileChannel.MapMode.READ_WRITE, 2,3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
