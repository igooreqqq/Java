# Problem ula i pszczół

Dany jeden ul w którym mieszą się dwa otwory mogące pełnić funkcje wejść i wyjść. Tylko jedna pszczoła może przelatywać przez otwór w danej chwili, gdyż dwie nie mieszczą się w przejściu. Przelot przez wejście/wyjście do/z ula zajmuje pszczole 1 sekundę. W ulu spędza między 1-5 sekund i wylatuje. Na zewnątrz ula spędza 5-10 sekund i wraca. Jeśli jedno z wejść jest zajęte pszczoła może wybrać drugie jako wejście/wyjście i tak dalej, lub oczekiwać na przelot na danym przejściu!.

Napisz program symulujący zachowanie się takiego ula. Każda pszczoła powinna być osobnym wątkiem posiadająca unikalny identyfikator (integer). Z poziomu tekstowego menu powinno być można ustalić maksymalną ilość pszczół. Każda pszczoła-wątek powinien przechowywać informacje na temat ilości wlotów/wylotów, oraz średni czas oczekiwania na /wylot/wlot. Dane na ten temat powinny być zapisywane do pliku tekstowego.

W konsoli programu powinny na bieżąco wyświetlać się informacje na temat działania symulacji Na przykład:

```
Pszczoła 1 podlatuje pod przelot 1
Pszczoła 1 wlatuje przez przelot 1
Pszczoła 3 podlatuje pod przelot 1
Pszczoła 3 przelot 1 zajęty, sprawdza przelot 2
Pszczoła 3 przelot 2 zajęty, oczekuję przelot 2
Pszczoła 1 wylatuje z przelotu 1
Pszczoła 3 wlatuje przez przelot 2
...
```

Program powinien zostać napisany w sposób zapewniający optymalne przeloty pszczół przez ul.
