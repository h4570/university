## Sorting comparison (10)

| Type        | Table A (random)  | Table B (asc) | Table C (desc) |
| ----------- | ----------------- | ------------- | -------------- |
|  Quicksort  |     0.000017s     |   0.000009s   |    0.000013s   |
|  Heapsort   |     0.000012s     |   0.000022s   |    0.000008s   |
|  Bubblesort |     0.000005s     |   0.000005s   |    0.000005s   |
  
## Sorting comparison (50k)

| Type        | Table A (random)  | Table B (asc) | Table C (desc) |
| ----------- | ----------------- | ------------- | -------------- |
|  Quicksort  |     0.062575s     |   3.764097s   |    5.014439s   |
|  Heapsort   |     0.012859s     |   0.011296s   |    0.012339s   |
|  Bubblesort |     8.142634s     |   2.663119s   |    6.312586s   |
  
### Summary (PL)

Dla małej tablicy najszybszy okazał się bubblesort, który ma podobny czas działania dla wszystkich trzech tabel. Najprawdopodobniej wynika to z prostoty samego algorytmu, gdzie brak rekurencji, dodatkowych pętli czy warunków, redukuje ilość instrukcji dla procesora.

W tablicy z 50 tysiącami elementów, najszybszy jest heapsort, który okazał się bezkonkurencyjny dla wszystkich 3 tabel.
Z wszystkich 3 algorytmów Bubblesort jest średnio najwolniejszy.
Quicksort najlepiej poradził sobie z tablicą, która ma w sobie losowe elementy, a gorzej poradził sobie z asc/desc.
