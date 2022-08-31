# Odwrotna Notacja Polska

| Termin oddania      | Punkty     |
|---------------------|:-----------|
|    21.05.2022 23:00 |   10        |

--- 
Przekroczenie terminu o **n** zajęć wiąże się z karą:
- punkty uzyskania za realizację zadania są dzielone przez **2<sup>n</sup>**.

--- 


## Zadanie 1 (Red)
Bazując na definicji stosów z poprzedniego zadania,
napisać testu funkcji `evalRPN`, która pobiera napis będący zapisem wyrażenia arytmetycznego 
w Odwrotnej Notacji Polskiej (RPN). Dopuszczalne wyrażenia to:
- liczba całkowita, np. `1`, `12`, `997`
- operacje dwuargumentowe dodawanie, mnożenie, odejmowanie (już są) i dzielenie (już jest ale nie ma reakcji na błędy)
- operacje jednoargumentowe: np. silnia czy wartość bezwzględna (lub dowolna inna operacja jednoargumentowa)
- możliwość obliczania w wybranym systemie liczbowym; do wyboru: binarny, dziesiętny, szesnastkowy.
Np. 
- B101 = 5
- D10 = 10
- #AB = 171
- #BA D13 + = 199

Nie należy zapominać, że nie wszystkie ciągi powyższych znaków są poprawnym 
wyrażeniem RPN (np. `1 2`) i to także należy wyrazić w testach. 
Przykładowe testy znajduje się w pliku `RPNTest`.

## Zadanie 2 (Green)
Zaimplementować metodę `evalRPN` w klasie `RPN`, 
która będzie poprawnie wyliczała wyrażenia RPN opisane powyżej 
oraz reagowała na niepoprawne wyrażenia. Metoda powinna przejść wszystkie testy 
opisane w Zadaniu 1.
