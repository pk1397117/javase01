package thread.thread07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BlockingQueueTest {
    //队列长度
    private static final int FILE_QUEUE_SIZE = 10;

    //搜索线程数
    private static final int SEARCH_THREADS = 100;

    //路径
    private static final Path DUMMY = Path.of("");

    //阻塞队列
    private static final BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {

        try (var in = new Scanner(System.in)){
            System.out.print("Enter base directory (e.g. /opt/jdk-9-src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(Path.of(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            };

            new Thread(enumerator).start();
            for (int i = 1; i < SEARCH_THREADS; i++) {
                Runnable search = () -> {
                    var done = false;
                    while (!done){
                        try {
                            Path file = queue.take();
                            if (file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else {
                                search(file, keyword);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                new Thread(search).start();
            }
        }
    }

    /**
     *Recursively(递归地)enumerates(列举) all files in a given directory and its subdirectories(子目录).
     * See Chapters(章) 1 and 2 of Volume(卷;册) II for the stream and file operations.
     * @param directory the directory in witch to start
     * @throws IOException
     * @throws InterruptedException
     */
    public static void enumerate(Path directory) throws IOException, InterruptedException {
        try (Stream<Path> children = Files.list(directory)){
            for (Path child : children.collect(Collectors.toList())) {
                if (Files.isDirectory((child)))
                    enumerate(child);
                else
                    queue.put(child);
            }
        }
    }

    /**
     * Search a file for a given keyword and prints all matching lines.
     * @param file
     * @param keyword
     * @throws IOException
     */
    public static void search(Path file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)){
            int lineNumber = 0;
            while (in.hasNext()){
                lineNumber++;
                String line = in.nextLine();
                 if (line.contains(keyword))
                     System.out.printf("%s:%d:%s%n", file,lineNumber,line);
            }
        }
    }
}
