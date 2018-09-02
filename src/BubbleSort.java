public class BubbleSort {
    public static void main(String[] args) {
        int valueObject[] = {25, 57, 48, 12, 92, 86, 33};

        bubbleSort(valueObject);
    }

    private static void bubbleSort(int[] array) {
        int reserve = 0;
        boolean stopInterator = true;
        int interator = array.length - 1;

        while (stopInterator) {
            for (int j = 0; j < interator; j++) {
                stopInterator = false;

                if (array[j] > array[j + 1]) {
                    reserve = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = reserve;
                    stopInterator = true;
                }
            }

            interator--;
        }


        for (int x = 0; x < array.length; x++) {
            System.out.println(array[x]);
        }

    }
}
