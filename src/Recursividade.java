public class Recursividade {
    public static void main(String[] args) {
        int valueObject[] = {25, 57, 48, 12, 92, 86, 33};

        System.out.println(factorial(3));
        System.out.println(expoent(4, 2));
        fibonacci(11);
        System.out.print(lookForNumber(valueObject.length-1, valueObject));
    }

    private static long factorial(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static int expoent(int base, int expoent) {
        if (expoent <= 0) {
            return 1;
        }

        return base * expoent(base, expoent - 1);
    }

    private static int fibonacci(int n) {
        if(n == 1 || n == 2) {
            System.out.println(1);
            return 1;
        } else {
            int value = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.println(value);
            return value;
        }
    }

    private static int lookForNumber(int length, int array[]){
        int valueReserve = 0;

        if(length == 0){
            return array[0];
        }if(array[length] > array[length - 1]){
            valueReserve = array[length - 1];
            array[length - 1] = array[length];
            array[length] = valueReserve;
        }

        return lookForNumber(length - 1, array);
    }
}
