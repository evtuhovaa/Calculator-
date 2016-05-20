package test;

/**
 * Created by Allex on 20.05.2016.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegClass {



        public static boolean checkWithRegExp(String string)
        {
            Pattern pattern1 = Pattern.compile("(^[0-9]+([\\/][0-9]+)?[+*-][0-9]+([/][0-9]+)?$)");
            Pattern pattern2 = Pattern.compile("^(([0-9]+)|(\\([0-9]+[\\/][0-9]+\\)))[/*](([0-9]+)|(\\([0-9]+[\\/][0-9]+\\)))$");
            Matcher matcher1 = pattern1.matcher(string);
            Matcher matcher2 = pattern2.matcher(string);
            return matcher1.matches()||matcher2.matches();
        }

}
