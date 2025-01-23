import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] array3 = new int[array1.length + array2.length];

        // System.arraycopy(array1, 0, array3, 0, array1.length);
        // System.arraycopy(array2, 0, array3, array1.length, array2.length);

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = array1.length, n = 0; i < array3.length; i++, n++) {
            array3[i] = array2[n];
        }

        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
        System.out.println("After Add element in array 1 and array2: " + Arrays.toString(array3));
    }
}
