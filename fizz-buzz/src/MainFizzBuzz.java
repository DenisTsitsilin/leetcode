import java.util.ArrayList;
import java.util.List;

public class MainFizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(Integer.getInteger(args[0])));
    }

    public static List<String> fizzBuzz(int n) {
        if(n >= 1 && n<= 10000) {
            List<String> list = new ArrayList<>();
            for (Integer i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) list.add("FizzBuzz");
                else if (i % 3 == 0) list.add("Fizz");
                else if (i % 5 == 0) list.add("Buzz");
                else list.add(i.toString());
            }
            return list;
        }
        return null;
    }
}
