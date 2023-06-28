import java.util.Arrays;
public class activity4 {

    public static void main(String args[])
    {
        int[] data = { 9, 5, 1, 4, 3 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
    static void ascendingSort(int inputArray[])
    {
            int size = inputArray.length;

            for (int i = 1; i < size; i++) {
                int key = inputArray[i];
                int j = i - 1;

                while (j >= 0 && key < inputArray[j]) {
                    inputArray[j + 1] = inputArray[j];
                    --j;
                }
                inputArray[j + 1] = key;
            }
        }
}
