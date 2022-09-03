import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainRomain {
    public static void main(String[] args) {
        List<Romain> romainList = new ArrayList<>();
        romainList.add(new Romain('I', 1, true));
        romainList.add(new Romain('V', 5, false));
        romainList.add(new Romain('X', 10, true));
        romainList.add(new Romain('L', 50, false));
        romainList.add(new Romain('C', 100, true));
        romainList.add(new Romain('D', 500, false));
        romainList.add(new Romain('M', 1000, false));

        Map<Character, Romain> romainMap = romainList.stream()
                .collect(Collectors.toMap(Romain::getKey, Function.identity()));
        StringBuilder str = new StringBuilder(args[0]);
        if (str.length() < 1 || str.length() > 15) {
            System.out.println("Length cannot be less than 1 or greater than 15");
            throw new RuntimeException();
        }
        Integer value = 0;

        try {
            for (int i = 0; i <= str.length(); ++i) {
                Romain romain = romainMap.get(str.charAt(i));
                if (romain.getBefore()) {
                    Romain romainNext = romainMap.get(str.charAt(i + 1));
                    if (romain.getValue() < romainNext.getValue()) {
                        value += romainNext.getValue() - romain.getValue();
                        ++i;
                        if (i < str.length() - 1) {
                            continue;
                        } else break;
                    }
                }
                value += romain.getValue();
            }

            if (value > 1 && value < 3999) System.out.println(value);
            else System.out.println("Error: Out of range");
        }catch (NullPointerException exception){
            System.out.println("Error: No such number exists");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}