import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebScraper {

    public static void main(String[] args) {
        // 定义目标网页的URL
        String targetUrl = "https://example.com";
        
        try {
            // 创建URL对象
            URL url = new URL(targetUrl);
            
            // 打开URL连接
            URLConnection connection = url.openConnection();
            
            // 设置连接属性（例如，浏览器标识）
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            // 读取网页内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            
            // 输出网页内容
            System.out.println("网页内容：");
            System.out.println(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
