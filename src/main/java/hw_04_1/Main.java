package hw_04_1;

public class Main {
    public static void main(String[] args) {
        TelephoneExchange telephoneExchange = new TelephoneExchange();
        Thread telephoneExchangeThread = new Thread(telephoneExchange);
        ThreadGroup threadGroup = new ThreadGroup("Колл-центр");
        Thread operatorThread1 = new Thread(threadGroup, new TelephoneOperator(telephoneExchange, "Оператор1"));
        Thread operatorThread2 = new Thread(threadGroup, new TelephoneOperator(telephoneExchange, "Оператор2"));
        Thread operatorThread3 = new Thread(threadGroup, new TelephoneOperator(telephoneExchange, "Оператор3"));
        telephoneExchangeThread.start();
        operatorThread1.start();
        operatorThread2.start();
        operatorThread3.start();
        try {
            telephoneExchangeThread.join();
            operatorThread1.join();
            operatorThread2.join();
            operatorThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadGroup.interrupt();
    }
}
