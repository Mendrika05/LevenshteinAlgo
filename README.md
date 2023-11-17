## Levenshtein

The Levenshtein distance is determined by the minimum number of transformations required to transition from a character string S1 to another character string S2.

## Structure

Transformation can be :

- `insertion`
- `removal`
- `substitution`

```
if n1 = 0  =>  n2
if n2 = 0  =>  n1
if n1 > 0 and n2 > 0  => min(D(n1, n2 - 1)+1, D(n1 - 1, n2)+1, D(n1 - 1, n2 - 1)+cost(n1, n2))
                         with cost(n1, n2) => 0 if S1(n1) = S2(n2)
                                              1 else
```

n : letter
D : distance

## example

D (PAPA, MAMAN)

```
            M   A   M   A   N
        0   1   2   3   4   5
    0   0   1   2   3   4   5
P   1   1   1   2   3   4   5
A   2   2   2   1   2   3   4
P   3   3   3   2   2   3   4
A   4   4   4   3   3   2   3
```

D (PAPA, MAMAN) = 3
- insertion(N)
- P -> M
- P -> M