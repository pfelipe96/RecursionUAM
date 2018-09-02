public class InsertionSort {
    public static void main(String[] args) {
        int valueObject[] = {25, 57, 48, 12, 92, 86, 33};
        insertionSort(valueObject);
    }

    private static void insertionSort(int[] array) {
        int interator = 0;
        int reserve = 0;

        while (interator != array.length - 1) {
            for (int i = interator; i >= 0; i--) {
                if (array[i] > array[i + 1]) {
                    reserve = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = reserve;
                }else{
                    break;
                }
            }

            interator++;
        }


        for (int x = 0; x < array.length; x++) {
            System.out.println(array[x]);
        }
    }
}