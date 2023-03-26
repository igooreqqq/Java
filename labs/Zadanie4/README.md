     Napisz program składający się z następujących klas (klasy bez pakietów)
        Klasa Cryptographer, zawierająca niestepujące pola i metody:
            statyczna metoda cryptfile, przyjmująca jako parametry plik do zaszyfrowania, plik w którym powinien zostać zapisany zaszyfrowany tekst oraz referencje do typu Algorithm:
            public void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm)
            statyczna metoda decryptfile działająca odwrotnie do cryptfile
            public void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm)
        Interfejs Algorithm posiadający następujące metody:
            metoda crypt szyfrująca pojedyncze słowo i zwracająca jego zaszyfrowana postać: 
            public String crypt(String inputWord)
            metoda decrypt deszyfrująca pojedyncze słowo i zawracająca jego odszyfrowaną postać
            public String decrypt(String inputWord)
        Klasa ROT11 implementująca interfejs Algorithm
            Klasa powinna posiadać statyczną,  zmienną finalną określającą alfabet używany w algorytmie, oraz przesunięcie - rotację (w tym wypadku 11) ROT13 (dla ułatwienia zakładamy, że szyfrujemy tylko teksty składające się z liter a-Z oraz cyfry 0-9. Dopuszczalne są duże i małe litery. Spacji i znaków końca linii nie szyfrujemy: w pliku wejściowym jak i wyjściowym pozostają bez zmian).
            Dla spójności proszę przyjąć  następujacy alfabet: 
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        Klasa Polibiusz implementująca interfejs Algorithm
            Klasa powinna realizować algorytm szyfrujący Polibiusza. Nie szyfrujemy spacji; algorytm nie powinien być case sensitive. Uwaga! Szyfr powinien rozróżniać J i L (podpowiedz: dodaj kolumnę ze znakami specjalnymi do szachownicy).
        Klasa Main z funkcją main. W funkcji main umieść kod który pobierze z parametrów programu ścieżki do pliku wejściowego i wyjściowego, oraz wartość crypt lub decrypt w zależności od tego cyt szyfrować czy deszyfrować oraz algorytm szyfrujący (dopuszczalne wartości to rot albo Polibiusz). Algorytmem  wykona szyfrowanie/deszyfrowanie pliku wejściowego i wynik umieści w pliku wyjściowym. Poniżej przykład wywołania programu:
        java Main /home/sbk/do_szyfrowania.txt /home/sbk/wynik.txt crypt rot 
        Przykładowy plik do zaszyfrowania: tocrypt.txt
        Przykładowe wyjście dla algorytmu ROT11: decrypt.txt
        Przykładowy plik dla Polibiusza (zakładamy że nie ma w nim znaków specjalnych i cyfr innych niż znak nowej linii i spacja): poli-input.txt
        Przykładowe wyjście dla Polibiusza z przykładu powyżej: poli-output.txt
