package hw_04_1;

public class TelephoneOperator implements Runnable {
    private TelephoneExchange telephoneExchange;
    private String name;
    private final long CALL_HOLD_TIME = 1000L;
    public TelephoneOperator(TelephoneExchange telephoneExchange, String name) {
        this.telephoneExchange = telephoneExchange;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                IncomingCall incomingCall = telephoneExchange.getCallQueue().take();
                System.out.println(name + " принимает звонок #" + incomingCall.getId());
                Thread.sleep(CALL_HOLD_TIME);
                System.out.println(name + " завершил звонок #" + incomingCall.getId());
                if (telephoneExchange.getCallQueue().isEmpty()) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
