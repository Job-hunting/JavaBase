///*
//package exam.度小满;
//
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] array = new int[n];
//        boolean[] b = new boolean[n];
//        for (int i = 0; i<n; i++) {
//            array[i] = scanner.nextInt();
//        }
//
//        for (int i = 0; i< n;i++){
//            b[i] = false;
//        }
//
//        int count = 0;
//        int max = 0;
//        int in = 0;
//        int out = 0;
//        int status = 0;
//        for(int i = 0; i < array.length - 1; i++) {
//            if(array[i + 1] > array[i] && status == 0) {
//                in = array[i];
//                status = 1;
//                count ++;
//            }
//            if(array[i + 1] < array[i] && status == 1) {
//                out = array[i];
//                max += (out - in);
//                status = 0;
//            }
//        }
//        if(status == 1) {
//            out = array[array.length - 1];
//            max += (out - in);
//        }
//        System.out.println(max+" "+2*count);
//    }
//
//}
//*/
