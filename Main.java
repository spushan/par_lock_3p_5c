class Main {

    public static void main(String[] args) throws InterruptedException {

        BlockQueue mainQueue = new BlockQueue();

        Thread p1 = new Thread(new Producer(mainQueue));
        Thread p2 = new Thread(new Producer(mainQueue));
        Thread p3 = new Thread(new Producer(mainQueue));

        Thread c1 = new Thread(new Consumer(mainQueue));
        Thread c2 = new Thread(new Consumer(mainQueue));
        Thread c3 = new Thread(new Consumer(mainQueue));
        Thread c4 = new Thread(new Consumer(mainQueue));
        Thread c5 = new Thread(new Consumer(mainQueue));

        c1.setDaemon(true);
        c2.setDaemon(true);
        c3.setDaemon(true);
        c4.setDaemon(true);
        c5.setDaemon(true);

        long start = System.currentTimeMillis();

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        p1.join();
        p2.join();
        p3.join();

        long end = System.currentTimeMillis();
        System.out.println("Execution Time: " + ((end-start)/1000) + " seconds");


    }

}
