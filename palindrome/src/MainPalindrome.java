public class MainPalindrome {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder(args[0]);
        Integer length = str.length();
        if((length % 2) == 0){
            String first = str.substring(0, length / 2);
            String second = str.substring(length / 2);
            second = new StringBuilder(second).reverse().toString();
            System.out.println(first.equals(second) ? "Is palindrome" : "Is not palindrome");
        }else System.out.println("This number cannot be a palindrome");
    }
}