import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/8/28 0028.
 */
public class RegexTool {

    public static void main(String[] args) {
        String str = "<iframe height=498 width=510 src=\"http://player.youku.com/embed/XMjE4MTY4MDE2\" frameborder=0 allowfullscreen></iframe>";
        regTest(str);
    }

    private static void regTest(String str) {
        String regEx = "(?:src=[\"|\'])(.+)(?=[\"|\'])";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        while(mat.find()){
            System.out.println(mat.group(1));
        }
    }

    public static List<String> getResult(String src, String regex) {
        ArrayList<String> result = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

}
