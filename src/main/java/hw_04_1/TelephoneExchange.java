package hw_04_1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TelephoneExchange implements Runnable {
    private static final int MAX_COUNT_INCOMING_CALL = 60;
    private final BlockingQueue<IncomingCall> callQueue = new LinkedBlockingQueue<>(MAX_COUNT_INCOMING_CALL);


    @Override
    public void run() {
        for (int i = 1; i <= MAX_COUNT_INCOMING_CALL; i++) {
            callQueue.add(new IncomingCall(i));
        }
    }

    public BlockingQueue<IncomingCall> getCallQueue() {
        return callQueue;
    }
}
