import java.util.*;
public class activity2 {

        public static void main(String[] args) {

            int[] Arr1 = {10, 77, 10, 54, -11, 10};
            System.out.println("Original Array is: " + Arrays.toString(Arr1));

            int searchNum = 10;
            int fixedSum = 30;

            System.out.println("Result: " + result(Arr1, searchNum, fixedSum));
        }

        public static boolean result(int[] numbers, int searchNum, int fixedSum) {
            int temp = 0;
            for (int number : numbers)
            {
                if (number == searchNum)
                {
                    temp += searchNum;
                }
                if (temp > fixedSum)
                {
                    break;
                }
            }
            return temp == fixedSum;
        }

}
