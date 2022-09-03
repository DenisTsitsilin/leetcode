public class MainPrefix {
    public static void main(String[] args) {
        if (args.length != 0) {
            String prefix = args[0];
            for(String str : args) {
                while (str.indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
            System.out.println(prefix);
        }
    }
}
