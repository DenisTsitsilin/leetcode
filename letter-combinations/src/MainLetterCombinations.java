import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainLetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations(args[0]));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (!digits.equals("")) {
            int[] arr = Arrays.stream(digits.split("", 0))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();
            for (int i : arr) {
                switch (i) {
                    case 2, 3, 4, 5, 6 -> list = get(list, getStrArr((i - 1) * 3 - 3, 3));
                    case 7 -> list = get(list, getStrArr((i - 1) * 3 - 3, 4));
                    case 8 -> list = get(list, getStrArr((i - 1) * 3 - 2, 3));
                    case 9 -> list = get(list, getStrArr((i - 1) * 3 - 2, 4));
                }
            }
        }
        return list;
    }

    private static List<String> getStrArr(int i, int count) {
        return Arrays.asList("abcdefghijklmnopqrstuvwxyz".substring(i, i + count).split("", 0));
    }

    private static List<String> get(List<String> list, List<String> listAdd) {
        List<String> result = new ArrayList<>();
        if (!list.isEmpty()) {
            for (String st : list) {
                for (String st2 : listAdd) {
                    result.add(st.concat(st2));
                }
            }
        } else {
            result.addAll(listAdd);
        }
        return result;
    }
}
