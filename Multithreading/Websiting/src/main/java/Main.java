import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
        List<String> html = Files.readAllLines(Paths.get("Sources/html.txt"));
        PrintWriter out = new PrintWriter("C:\\Users\\Speedy\\Desktop\\java_basics\\Multithreading\\Websiting\\Sources\\htmlTest.txt");
        Pattern pattern = Pattern.compile("https://.+\"");

        for (String s:html ) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                System.out.println(s.substring(matcher.start(),matcher.end()));
                System.out.println();
            }

        }



    }
}
