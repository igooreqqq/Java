Napisz program, który będzie służył do opóźniania, lub przyspieszania wyświetlania napisów do filmów w formacie MicroDVD ;-). Czas pojawienia się napisu oznaczany jest w tym formacie dwiema liczbami umieszczonymi pomiędzy nawiasami klamrowymi. Pierwsza liczba to numer klatki pojawienia się napisu, druga to numer klatki zniknięcia. Program powinien posiadać metodę delay(const char in, const char out,int delay, int fps) wykonującą opóźnienie (lub przyspieszenie) napisów o podaną ilość milisekund w zależności od tego jaki film ma framerate.
Program powinien przyjmować jako parametry cztery wartości: ścieżkę do pliku wejściowego, ścieżkę do pliku wyjściowego i liczbę milisekund i framerate. Metoda delay powinna wyrzucać wyjątek gdy w pliku pojawi się niepoprana sekwencja znaków. Np. zamiast {1234}{4565} pojawia się {sdfg}{33ff}, lub gdy sekwencje klatek są niepoprawne np. {123344}{12}

    Propgram powinien obsługiwać każdą niepoprawną sytuację, zwracać wyjątek w którym będzie zawarta informacja o linijce w jakiej pojawił się błąd (wraz z treścią tej linijki) i typie błędu.
    Wyjątki mają być obsłużone w mainie
    Jeśli pojawia się wyjatki niobsługiwane w programie, powinna zostać zwrócona linia w której wyjatek się pojawił, treść tej linii i informacja o nieznanym typie wyjątku.
    Plik do testów gravity.txt
    Program powinien mieć klasę Main z metodą main i pobierać niezbęde parametry z linii poleceń:
    java Main gravity.txt gravity-delayed.txt 100 25
