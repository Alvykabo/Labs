package com.company;


import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class BusStops {
    //Остановка может одновременно принимать 2 автобуса
    //Остановка занята - true, свободно - false
    private static final boolean[] PLACES_FOR_FIRST_STATION = new boolean[1];
    private static final boolean[] PLACES_FOR_SECOND_STATION = new boolean[1];
    private static final boolean[] PLACES_FOR_THIRD_STATION = new boolean[1];
    private static final boolean[] PLACES_FOR_FOURTH_STATION = new boolean[1];
    private static final Semaphore SEMAPHORE_FOR_FIRST_STATION = new Semaphore(1, true);
    private static final Semaphore SEMAPHORE_FOR_SECOND_STATION = new Semaphore(1, true);
    private static final Semaphore SEMAPHORE_FOR_THIRD_STATION = new Semaphore(1, true);
    private static final Semaphore SEMAPHORE_FOR_FOURTH_STATION = new Semaphore(1, true);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("На маршруте 4 остановки");
        Thread.sleep(1200);
        Scanner busScanner = new Scanner(System.in);
        System.out.println("Введите число автобусов, которые будут ехать по маршруту от 2 до 10 " +
                "включительно");
        int buses = busScanner.nextInt();
        if (buses == 2 || buses == 3 || buses == 4 || buses == 5 || buses == 6 || buses == 7 ||
                buses == 8 || buses == 9 || buses == 10) {
            for (int i = 1; i <= buses; i++) {
                new Thread(new Bus(i)).start();
                Thread.sleep(400);
            }
        }
    }

    public static class Bus implements Runnable {
        private final int busNumber;

        public Bus(int busNumber) {
            this.busNumber = busNumber;
        }

        @Override
        public void run() {
            System.out.printf("Автобус №%d подъехал к остановке №1.\n", busNumber);
            try {
                SEMAPHORE_FOR_FIRST_STATION.acquire();
                int parkingNumber = -1;

                //Ищем свободное место и паркуемся
                synchronized (PLACES_FOR_FIRST_STATION) {
                    for (int i = 0; i < 1; i++)
                        if (!PLACES_FOR_FIRST_STATION[i]) {      //Если место свободно
                            PLACES_FOR_FIRST_STATION[i] = true;  //занимаем его
                            parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                            System.out.printf("Автобус №%d остановился на остановке №1.\n", busNumber, i);
                            break;
                        }
                }

                Thread.sleep(3000);       //Выгружаются люди на остановке

                synchronized (PLACES_FOR_FIRST_STATION) {
                    PLACES_FOR_FIRST_STATION[parkingNumber] = false; //Освобождаем место
                }

                //release(), напротив, освобождает ресурс
                SEMAPHORE_FOR_FIRST_STATION.release();
                System.out.printf("Автобус №%d покинул остановку №1.\n", busNumber);
            } catch (InterruptedException e) {
                System.out.println();
            }
            Bus bus = new Bus(busNumber);
            bus.secondStation();
            bus.thirdStation();
            bus.fourthStation();
        }

            public void secondStation(){
            System.out.printf("Bus №%d подъехал к остановке №2\n", busNumber);
            try {
                SEMAPHORE_FOR_SECOND_STATION.acquire();
                int parkingNumber = -1;
                synchronized (PLACES_FOR_SECOND_STATION){
                    for (int i = 0; i < 1; i++)
                        if (!PLACES_FOR_SECOND_STATION[i]) {      //Если место свободно
                            PLACES_FOR_SECOND_STATION[i] = true;  //занимаем его
                            parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                            System.out.printf("Bus №%d остановился на остановке №2.\n", busNumber, i);
                            break;
                        }
                }
                Thread.sleep(3000);       //Уходим за покупками, к примеру
                synchronized (PLACES_FOR_SECOND_STATION) {
                    PLACES_FOR_SECOND_STATION[parkingNumber] = false;//Освобождаем место
                }
                SEMAPHORE_FOR_SECOND_STATION.release();
                System.out.printf("Bus №%d покинул остановку №2\n", busNumber);
            } catch (InterruptedException e) {
                System.out.println();
            }
        }
        public void thirdStation(){
            System.out.printf("Bus №%d подъехал к остановке №3\n", busNumber);
            try {
                SEMAPHORE_FOR_THIRD_STATION.acquire();
                int parkingNumber = -1;
                synchronized (PLACES_FOR_THIRD_STATION){
                    for (int i = 0; i < 1; i++)
                        if (!PLACES_FOR_THIRD_STATION[i]) {      //Если место свободно
                            PLACES_FOR_THIRD_STATION[i] = true;  //занимаем его
                            parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                            System.out.printf("Bus №%d остановился на остановке №3.\n", busNumber, i);
                            break;
                        }
                }
                Thread.sleep(3000);       //Уходим за покупками, к примеру
                synchronized (PLACES_FOR_THIRD_STATION) {
                    PLACES_FOR_THIRD_STATION[parkingNumber] = false;//Освобождаем место
                }
                SEMAPHORE_FOR_THIRD_STATION.release();
                System.out.printf("Bus №%d покинул остановку №3\n", busNumber);
            } catch (InterruptedException e) {
                System.out.println();
            }
        }

        public void fourthStation(){
            System.out.printf("Bus №%d подъехал к остановке №4\n", busNumber);
            try {
                SEMAPHORE_FOR_FOURTH_STATION.acquire();
                int parkingNumber = -1;
                synchronized (PLACES_FOR_FOURTH_STATION){
                    for (int i = 0; i < 1; i++)
                        if (!PLACES_FOR_FOURTH_STATION[i]) {      //Если место свободно
                            PLACES_FOR_FOURTH_STATION[i] = true;  //занимаем его
                            parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                            System.out.printf("Bus №%d остановился на остановке №4.\n", busNumber, i);
                            break;
                        }
                }
                Thread.sleep(3000);       //Уходим за покупками, к примеру
                synchronized (PLACES_FOR_FOURTH_STATION) {
                    PLACES_FOR_FOURTH_STATION[parkingNumber] = false;//Освобождаем место
                }
                SEMAPHORE_FOR_FOURTH_STATION.release();
                System.out.printf("Bus №%d покинул остановку №4\n", busNumber);
            } catch (InterruptedException e) {
                System.out.println();
            }
        }
    }
}