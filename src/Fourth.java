public class Fourth extends Thread{

    public void run(){
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nThis is thread\n");
    }
}
