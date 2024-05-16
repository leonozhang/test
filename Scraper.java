import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {

    public static void main(String[] args) {
        String url = "https://example.com/news"; // 替换为你要爬取的网页URL

        try {
            // 连接到网站并获取HTML文档
            Document document = Jsoup.connect(url).get();

            // 选择包含新闻标题的元素（假设标题在<h2>标签中）
            Elements newsHeadlines = document.select("h2");

            // 遍历每个标题元素并打印出文本内容
            for (Element headline : newsHeadlines) {
                System.out.println("Title: " + headline.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
