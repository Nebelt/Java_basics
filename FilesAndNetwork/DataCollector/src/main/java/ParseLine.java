import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParseLine {

    public static List<Line> parseLine() {

        String WHOLE_DOC = ParseWholeDoc.parseFile("data/code.html");
        Document listLines = Jsoup.parse(WHOLE_DOC);

        List<Line> lines = new ArrayList<>();
        Elements elements = listLines.select("span.js-metro-line");

        for (Element element : elements) {
            String name = element.text();
            String number = element.attr("data-line");
            Line line = new Line(number, name);
            lines.add(line);
        }


        return lines;
    }

}
