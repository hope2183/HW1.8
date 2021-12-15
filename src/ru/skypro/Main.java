package ru.skypro;

import javax.swing.text.AttributeSet;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //TASK 1
        int year = 2021;
        printIsLeapYearResult(year, isLeapYear(year));

        // TASK 2
        int clientOS = 1; //1 - ANDROID, 0 - IOS
        int deviceYear = 2021;
        printRecommendApplicationVersion(clientOS, deviceYear);

        // TASK 3
        int distance = 165;
        System.out.println();
        System.out.println(distance < 100 ? "Количество дней на доставку: " + calculateDeliveryDays(distance) : "Доставить не сможем!");

        // TASK 4
        String text = "aabccddefgghiijjkk";
        findAndPrintDuplicates(text);

        // TASK 5
        int arr[] = new int []{7,10,15,3};
        reverseArray(arr);
        System.out.println("Reversed array: "+ Arrays.toString(arr));

        // TASK 6
        int [] array = generateRandomArray();
        double averageSum = calculateAverageValueFrom(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Средняя сумма трат в день в течение месяца составила "+averageSum+" рублей.");
    }

    //TASK 1
    public static void printIsLeapYear(int year) {
        boolean leapYear = isLeapYear(year);
        printIsLeapYearResult(year, leapYear);
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static void printIsLeapYearResult(int year, boolean leapYear) {
        if (leapYear) {
            System.out.println(year + " - високосный год!");
        } else {
            System.out.println(year + " - не високосный год!");
        }
    }

    //TASK 2
    public static void printRecommendApplicationVersion(int clientOS, int deviceYear) {
        boolean deviceIsOld = isDeviceOld(deviceYear);
        System.out.print("Установите ");
        if (deviceIsOld) {
            System.out.print("lite ");
        }
        System.out.print("версию для ");
        if (clientOS == 0) {
            System.out.print("IOS.");
        } else {
            System.out.print("ANDROID.");
        }
    }

    public static boolean isDeviceOld(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear < currentYear;
    }

    //TASK 3
    public static int calculateDeliveryDays(int deliveryDistance) {
        int result = 1;
        if (deliveryDistance >= 20 && deliveryDistance < 60) {
            result++;
        }
        if (deliveryDistance >= 60 && deliveryDistance < 100) {
            result += 2;
        }
        return result;
    }

    //TASK 4
    public static void findAndPrintDuplicates(String text) {
        if (text.equals("")){
            return;
        }
        boolean isDuplicateFound = false;
        char[] letters = text.toCharArray();
        char prevChar = Character.MAX_VALUE;
        for (char letter : letters
        ) {
            if (letter == prevChar) {
                System.out.println("Найден дубль по символу " + letter);
                isDuplicateFound = true;
                break;
            }
            prevChar = letter;
        }
           if (isDuplicateFound){
               System.out.println("Дублей не найдено!");
            }
            }
    //TASK 5
    public static void reverseArray (int []arr){
        // int arr[] = new int []{7,10,15,3}
        int head = 0;
        int tail = arr.length-1;
        while (head<tail){
            int temp = arr[head];
            arr[head++] = arr[tail];
            arr[tail--] = temp;
        }
    }

    //TASK 6
     public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    public static double calculateAverageValueFrom(int []array){
        int sum = calculateSumFrom(array);
        return calculateAverageValue (sum, array.length);
    }
    public static int calculateSumFrom(int array[]){
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
            return sum;
        }
        public static double calculateAverageValue(int sum, int elementAmount){
        return sum / (double) elementAmount;
    }

        }





