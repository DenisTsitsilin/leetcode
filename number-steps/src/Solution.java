public class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                System.out.printf("Step %d) %d is even; divide by 2 and obtain %d.\n", ++step, num, num /= 2);
            } else System.out.printf("Step %d) %d is odd; subtract 1 and obtain %d.\n", ++step, num, num -= 1);
        }
        return step;
    }
}
