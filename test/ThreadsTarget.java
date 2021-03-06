public class ThreadsTarget {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                methodForThreadEarlyEnd();
            }
        }, "ThreadEarlyEnd").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("RenamedThread");
                methodForRenamedThread();
            }
        }, "ThreadWillBeRenamed").start();
    }

    static void methodForThreadEarlyEnd() {
        long now = System.currentTimeMillis();
        long counter = 0;
        while (System.currentTimeMillis() - now < 300) {
            counter++;
        }
    }

    static void methodForRenamedThread() {
        long now = System.currentTimeMillis();
        long counter = 0;
        while (System.currentTimeMillis() - now < 1000) {
            counter++;
        }
    }
}
