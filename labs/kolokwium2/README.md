# Sortujący serwer
Prosze napisać serwer działający na porcie 8001, do którego po połączeniu klient wysyła nazwy funkcji (metod zdefiniowanych w klasie java.lang.Math przyjmujących jeden argument typu double i zwracających wartośc double), każda nazwa w osobnej linijce. Na końcu listy klient wysyła x=[jakaś liczba], np. x=2. Wtedy serwer sortuje listę funkcji rosnąco w oparciu o wartośc funkcji we wskazanym punkcie, a nastepnie odsyła posortowaną listę do klienta.

Poniżej znajdyje się zrzut konsoli z przykładowej interakcji z serwerem. W nawiasach przy posortowanej liście wypisano wartości funkcji dla x=1.3. Pogrubiona czcionka oznacza dane wprowadzone z klawiatury przez klienta. Czcionka pochylona to dane odebrane od serwera.

```
$ telnet localhost 8001
Tring 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
czekam na dane...
sin
cos
log
log10
ala
Niepoprawna nazwa metody: ala
max
Niepoprawna nazwa metody: max
sqrt
ceil
floor
x=1.3
Posortowane metody
(0.11394335230683679) log10
(0.26236426446749106) log
(0.26749882862458735) cos
(0.963558185417193) sin
(1.0) floor
(1.140175425099138) sqrt
(2.0) ceil
Connection closed by foreign host.
```
