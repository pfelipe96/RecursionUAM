public class SelectionSort {
    public static void main(String[] args) {
        int valueObject[] = {25, 57, 48, 12, 92, 86, 33};
        changeNumber(valueObject);
    }

    private static void changeNumber(int[] array) {

        for (int i = array.length - 1; i >= 0; i--) {
            for (int y = array.length - 1; y >= 0; y--) {
                if (array[i] < array[y]) {
                }
            }
        }

        for(int i = 0; i < array.length; i++){
            System.out.print(array);
        }
    }
}
