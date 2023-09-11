package src.jys;
import java.awt.*;
import java.lang.*;

/*
public class ThreadExample {
    public static void main(String[] args) {

        int[] x = new int[100];
        for (int i = 0; i < 100; i++) {
            x[i] = i;
        }


        int mid = x.length / 2;


        int[] subArray1 = new int[mid];
        int[] subArray2 = new int[x.length - mid];
        System.arraycopy(x, 0, subArray1, 0, mid);
        System.arraycopy(x, mid, subArray2, 0, x.length - mid);

        Thread th1 = new Thread(new MyThread(subArray1));
        Thread th2 = new Thread(new MyThread(subArray2));

        th1.start();
        th2.start();

        try {

            th1.join();
            th2.join();


            int sum = MyThread.getResult() + MyThread.getResult();
            System.out.println("Main thread의 합: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Runnable {
    private int[] array;
    private  int result = 0;

    public MyThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        result = sum;
        System.out.println(Thread.currentThread().getName() + "의 합: " + sum);
    }

    public  int getResult() {
        return result;
    }
}

 */
public class ThreadExample {
    public static void main(String[] args) {

        int[] x = new int[100];
        for (int i = 0; i < 100; i++) {
            x[i] = i;
        }

        // 배열을 두 개로 나누기 위한 중간 인덱스 계산
        int mid = x.length / 2;

        // 배열을 두 개의 서브 배열로 나누기
        int[] subArray1 = new int[mid];
        int[] subArray2 = new int[x.length - mid];
        System.arraycopy(x, 0, subArray1, 0, mid);
        System.arraycopy(x, mid, subArray2, 0, x.length - mid);

        // 두 개의 스레드 생성
        MyThread th1 = new MyThread(subArray1);
        MyThread th2 = new MyThread(subArray2);

        // 스레드 시작
        th1.start();
        th2.start();

        try {
            // 스레드가 실행을 완료할 때까지 대기
            th1.join();
            th2.join();

            // 결과를 출력
            int sum = th1.getResult() + th2.getResult();
            System.out.println("Main thread의 합: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    private int[] array;
    private int result = 0;

    public MyThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        result = sum;
        System.out.println(Thread.currentThread().getName() + "의 합: " + sum);
    }

    public int getResult() {
        return result;
    }
}
