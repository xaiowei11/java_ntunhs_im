package vv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aa {
    public static void main(String[] args) {
        Path filePath = Path.of("C:\\Users\\User\\Desktop\\demo.txt");
        try {
            String content = Files.readString(filePath);

            // 正则表达式匹配URL
            String regex = "(01AF0055/\\d{6}[a-z]+\\.HRV\\.jpg\\?HRV\\.bpp)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);

            // 循环遍历匹配结果并打印提取出的URL
            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
