import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        optionalTask2();
        scanner.close();
    }

    private static void helloUsername(){
        System.out.println("Please enter your name");
        System.out.println("Hello " + scanner.nextLine());
    }

    private static void reversArgs(String[] arg){
        for (int i = arg.length - 1; i != 0; i--) {
            System.out.print(arg[i] + " ");
        }
    }

    private static void randomValues(){
        Random random = new Random();
        int numberOfRandomDigits;

        System.out.println("\nСколько случайных чител вывести?");

        if (scanner.hasNextInt()) {
            numberOfRandomDigits = scanner.nextInt();
            for (int i = 0; i < numberOfRandomDigits; i++) {
                System.out.println(random.nextInt(150));
            }
            for (int i = 0; i < numberOfRandomDigits; i++) {
                System.out.print(random.nextInt(150) + " ");
            }
        }
    }

    private static void sumArgs(String[] arg){
        int sum = 0;

        for (int i = 0; i < arg.length; i++) {
            sum += Integer.parseInt(arg[i]);
        }

        System.out.println("Сумма аргументов = " + sum);
    }

    private static void month() {
        do{
            System.out.println("Введите номер месяца от 1 до 12 или Q для выхода");
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1: {
                        System.out.println("Январь");
                        break;
                    }
                    case 2: {
                        System.out.println("Февраль");
                        break;
                    }
                    case 3: {
                        System.out.println("Март");
                        break;
                    }
                    case 4: {
                        System.out.println("Апрель");
                        break;
                    }
                    case 5: {
                        System.out.println("Май");
                        break;
                    }
                    case 6: {
                        System.out.println("Июнь");
                        break;
                    }
                    case 7: {
                        System.out.println("Июль");
                        break;
                    }
                    case 8: {
                        System.out.println("Август");
                        break;
                    }
                    case 9: {
                        System.out.println("Сентябрь");
                        break;
                    }
                    case 10: {
                        System.out.println("Октябрь");
                        break;
                    }
                    case 11: {
                        System.out.println("Ноябрь");
                        break;
                    }
                    case 12: {
                        System.out.println("Декабрь");
                        break;
                    }
                    default: {
                        System.out.println("Вы ввели неверный номер месяца. Введите число от 1 до 12");

                    }
                }
            } else if (scanner.next().equalsIgnoreCase("Q")) break;
        } while (true);
    }

    private static void optionalTask1() {
        int n;
        int[] arr = new int[0];
        System.out.println("Введите количество чисел n");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Введите число");
                if(scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
                } else i--;
            }
        }

        minAndMaxLengthNumber(arr);

        printArrayFromMinToMaxLengthNumbers(arr);
    }

    private static void minAndMaxLengthNumber(int[] array){
        System.out.println("Minimal length number: " + array[indexMinimalLengthNumber(array)] +
                " Maximal length value: " + array[indexMaximalLengthNumber(array)]);
    }

    private static int indexMinimalLengthNumber(int[] array){
        int indexMinimalLengthValue = 0;
        for (int i = 1; i < array.length; i++ ) {
            if (String.valueOf(array[indexMinimalLengthValue]).length() > String.valueOf(array[i]).length())
                indexMinimalLengthValue = i;
        }
        return indexMinimalLengthValue;
    }

    private static int indexMaximalLengthNumber(int[] array) {
        int indexMaximalLengthValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[indexMaximalLengthValue]).length() < String.valueOf(array[i]).length())
                indexMaximalLengthValue = i;
        }
        return indexMaximalLengthValue;
    }

    private static void printArrayFromMinToMaxLengthNumbers(int[] array){
        int minimalLengthNumber = String.valueOf(array[indexMinimalLengthNumber(array)]).length();
        int counter = 0;

        while (counter < array.length) {
            for (int i = 0; i < array.length; i++) {
                if (String.valueOf(array[i]).length() == minimalLengthNumber) {
                    System.out.print(array[i] + " ");
                    counter++;
                }
            }
            minimalLengthNumber++;
        }

    }

    //Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
    private static void optionalTask2(){
        int n = 0;

        System.out.println("Введите размерность массива");
        n = scanner.nextInt();
        int[][] array = createArray(n);

        for(int i = 0; i < array.length; i++){
            calculateSum(array[i]);
        }
        System.out.println("\n**************************************");

        printArray(array);


    }

    private static void calculateSum(int[] array){
        int indexFirstPositiveValue = -1;
        int indexSecondPositiveValue = -1;
        int sum=0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > 0 && indexFirstPositiveValue == -1){
                indexFirstPositiveValue = i;
            } else if(array[i] > 0 && indexFirstPositiveValue >= 0 && indexSecondPositiveValue == -1){
                indexSecondPositiveValue = i;
            }
        }
        if(indexFirstPositiveValue >= 0 && indexSecondPositiveValue > 0 ){
            for(int i = indexFirstPositiveValue; i<=indexSecondPositiveValue; i++){
                sum +=array[i];
            }
            System.out.print(sum + " ");
        }
    }

    private static int[][] createArray(int n){
        int MIN_VALUE = -400;
        int MAX_VALUE = 400;

        Random random = new Random();
        int[][] array = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = random.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
            }
        }
        return array;
    }

    private static void printArray(int[][] array){
        int rows = array.length;
        int columns = array[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}