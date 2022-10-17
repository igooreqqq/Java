Zaimplementuj następujące klasy i funkcjonalności:

    1.Klasę abstrakcyjną Shape
        prywatne pole typu String o nazwie name, określajace nazwę figury geometrycznej.
        abstrakcyjną metodą publiczną o nazwie calculateSurfaceArea, która zwraca double
        abstrakcyjną metodą publiczną o nazwie calculatePerimeter która zwraca double
        abstrakcyjną metodę getName, zwracajacą pole name
        abstrakcyjną metodą publiczną o nazwie scale która przyjmuje scalingFactor typu double będący współczynnikiem skalowania i zwraca Shape, metoda wyrzuca wyjątek ScalingFactorException jeśli scalingFactor <= 0
    2.Klasę Circle 
        Zawiera konstruktor parametrowy, przyjmujący 3 parametry typu double: środek (x,y) i promień, ustawia pole name na "Circle"
        Dziedziczy po Shape i implemetuje metody abstrakcyjne (skalowanie robione jest względem środka okręgu)
    3.Klasę Rectangular 
        Zawiera konstruktor parometrowy, przyjmujący 4 parametry typu double: x, y -- określające lewy górny wierzchołek oraz długość (względem x) i szerokość (względem y), ustwia pole name na "Rect"
        Dziedziczy po Shape i implementuje metody abstrakcyjne (skalowanie robione jest względem lewego górnego wierzchołka
    4.Klasę BagOfShapes która dziedziczy po Shape
        Zawiera listę Shape
        Implementuje funkcje abstrakcyjne Shape w następujący sposób który sumuje pola powierzchni i obwody, skalowanie jest wykonywane indywidualnie dla każdej figury z osobna
    5.Klasę Main która przechwytuje i odpowiednio obsługuje wszystkie wyjątki:
        Tworzy pusty obiekt BagOfShapes
        Wyświetli menu postaci
        1. Dodaj kwadrat - pyta o współrzędne i dodaje obietk kwadrat do BagOfShapes
        2. Dodaj okrąg - analogicznie j.w.
        3. Wyświetl pole powierzchni  - wyświetla sumę pól powierzchni w BagOfShapes
        4. Wyświetl obwód -- wyświetla sumę obwodów w BagOfShapes
        5. Skaluj obiekty -- skaluje wszystkie obiekty w BagOfShapes względem podanego współczynnika. 
        6. Print names  -- wyświetla wszystkie nazwy obiektów w BagOfShapes
        7. Remove object of index -- usuwa obiekt o podanym indeksie z BagOfShapes
        8. Exit -- wychodzi z programu
    6.Wyjątek ScalingFactorException wyjatek typu checked
