package JavaExercise20240929;

public class JavaExercise {
    public static void main(String[] args) {
        int[] array = {5,1,1,1};
        int k = 0;
        Solution solution = new Solution();
        System.out.println(solution.timeRequiredToBuy(array, k));
    }
}
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int length = tickets.length;
        while (true) {
            for (int i = 0; i < length; i++) {
                if (tickets[i] > 0) {
                    time++;
                    tickets[i]--;
                }
                if (tickets[k] == 0) {
                    return time;
                }
            }
        }
    }
}
