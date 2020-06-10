package Text;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
    public int counterInt(String string){
        Pattern pattern = Pattern.compile("[^0-9]{1,}");
        Matcher matcher = pattern.matcher(string);
        String res = matcher.replaceAll(" ");
        OptionalInt m = Arrays.asList(res.split(" ")).stream()
                .mapToInt(s -> s.length())
                .max();
        return m.getAsInt();
    }
}
