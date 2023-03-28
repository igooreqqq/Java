import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ul {
    private boolean stanPierwszegoWejscia;
    private boolean stanDrugiegoWejscia;
    private final ExecutorService execut = Executors.newCachedThreadPool();

    public Ul() {
        stanPierwszegoWejscia = true;
        stanDrugiegoWejscia = true;
    }

    public void start(int liczbaPszczol) {
        for(int i = 1; i <= liczbaPszczol; i++) {
            execut.execute(new Pszczola(this, i));
        }
    }

    public boolean pierwszeWejscieWolne() {
        return stanPierwszegoWejscia;
    }

    public boolean drugieWejscieWolne() {
        return stanDrugiegoWejscia;
    }

    public synchronized void przelezPrzezPierwszeWejscie() throws InterruptedException {
        stanPierwszegoWejscia = false;
        wait(1000);
        stanPierwszegoWejscia = true;
    }

    public synchronized void przelecPrzezDrugieWejscie() throws InterruptedException {
        stanDrugiegoWejscia = false;
        wait(1000);
        stanDrugiegoWejscia = true;
    }

}
