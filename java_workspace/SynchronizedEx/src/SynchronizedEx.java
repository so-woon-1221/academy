public class SynchronizedEx {
    public static void main(String[] args) {
        ShareBoard board = new ShareBoard();

        Thread thread1 = new StudentThread("kitase", board);
        Thread thread2 = new StudentThread("hyosoo", board);

        thread1.start();
        thread2.start();
    }
}

class ShareBoard {
    private int sum = 0;

    public void add() {
        int n = sum;
        Thread.yield(); // 두명이 서로 양보하다록
        n += 10;
        sum = n;
        System.out.println(Thread.currentThread().getName() + " : " + sum);
    }

    public int getSum() {
        return sum;
    }
}

class StudentThread extends Thread {
    private final ShareBoard board;

    public StudentThread(String name, ShareBoard board) {
        super(name);
        this.board = board;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            board.add();
        }
    }
}
