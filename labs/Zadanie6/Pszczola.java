import java.io.*;

public class Pszczola extends Thread{

    private final Ul ul;
    private final int nrPszczoly;
    private int liczbaWejsc;
    private int liczbaWyjsc;
    private long czasCzekaniaWejscie;
    private long czasCzekaniaDoWyjscia;

    public Pszczola(Ul ul, int nrPszczoly) {
        this.ul = ul;
        this.nrPszczoly = nrPszczoly;
        liczbaWejsc = 0;
        liczbaWyjsc = 0;
        czasCzekaniaWejscie = 0;
        czasCzekaniaDoWyjscia = 0;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println(this + " przebywa na zewnątrz");
                double rand = Math.random() * 5000 + 5000;
                sleep((long) rand);
                System.out.println(this + " podlatuje pod przelot 1");
                if(ul.pierwszeWejscieWolne()) {
                    synchronized (ul) {
                        System.out.println(this + " wlatuje przez przelot 1");
                        ul.przelezPrzezPierwszeWejscie();
                        ul.notify();
                    }

                } else {
                    System.out.println(this + " przelot 1 zajęty, sprawdza przelot 2");
                    if(ul.drugieWejscieWolne()) {
                        synchronized (ul) {
                            System.out.println(this + " wlatuje przez przelot 2");
                            ul.przelecPrzezDrugieWejscie();
                            ul.notify();
                        }

                    } else {
                        System.out.println(this + " przelot 2 zajęty, oczekuje przelot 2");
                        synchronized (ul){
                            long temp = System.currentTimeMillis();
                            ul.wait();
                            czasCzekaniaWejscie += System.currentTimeMillis() - temp;
                            System.out.println(this + " wlatuje przez przelot 2");
                            ul.przelecPrzezDrugieWejscie();
                            ul.notify();
                        }
                    }
                }
                liczbaWejsc++;

                System.out.println(this + " przebywa w ulu");
                double rand2 = Math.random() * 1000 + 4000;
                sleep((long) rand2);

                if(ul.pierwszeWejscieWolne()) {
                    synchronized (ul) {
                        System.out.println(this + " wylatuje przez przelot 1");
                        ul.przelezPrzezPierwszeWejscie();
                        ul.notify();
                    }

                } else {
                    System.out.println(this + " przelot 1 zajęty, sprawdza przelot 2");
                    if(ul.drugieWejscieWolne()) {
                        synchronized (ul) {
                            System.out.println(this + " wylatuje przez przelot 2");
                            ul.przelecPrzezDrugieWejscie();
                            ul.notify();
                        }

                    } else {
                        System.out.println(this + " przelot 2 zajęty, oczekuje przelot 2");
                        synchronized (ul) {
                            long temp = System.currentTimeMillis();
                            ul.wait();
                            czasCzekaniaDoWyjscia += System.currentTimeMillis() - temp;
                            System.out.println(this + " wylatuje przez przelot 2");
                            ul.przelecPrzezDrugieWejscie();
                            ul.notify();
                        }
                    }
                }
                liczbaWyjsc++;
                zapiszDoPliku();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }catch (IOException e1) {
                System.out.println("Blad zapisu");
                e1.printStackTrace();
            }
        }

    public synchronized void zapiszDoPliku() throws IOException
    {

        String str = this + " Liczba wejść: " + liczbaWejsc + ", czas czekania na wejscie " + czasCzekaniaWejscie/liczbaWejsc + " ,liczba wyjść " + liczbaWyjsc + " ,czas czekania na wyjście " + czasCzekaniaDoWyjscia/liczbaWyjsc + '\n';

        OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream("src\\info.txt", true));
        outputStream.write(str);
        outputStream.close();
    }


    @Override
    public String toString() {
        return "Pszczoła " + nrPszczoly;
    }
}
