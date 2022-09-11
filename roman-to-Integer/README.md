# 13. Roman to Integer
## Task:

Roman numerals are represented by seven different symbols: _I, V, X, L, C, D_ and _M_.

| Symbol | Value |
|:---:|:---:|
| I |  1  |
| V |  5  |
| X | 10  |
| L | 50  |
| C | 100 |
| D | 500 |
| M |1000 |

For example, _2_ is written as _II_ in Roman numeral, just two ones added together. _12_ is written as _XII_, which is simply _X + II_. The number _27_ is written as _XXVII_, which is _XX + V + II_.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not _IIII_. Instead, the number four is written as _IV_. Because the one is before the _five_ we subtract it making _four_. The same principle applies to the number _nine_, which is written as _IX_. There are six instances where subtraction is used:

- _I_ can be placed before _V (5)_ and _X (10)_ to make _4_ and _9_.
- _X_ can be placed before _L (50)_ and _C (100)_ to make _40_ and _90_.
- _C_ can be placed before _D (500)_ and _M (1000)_ to make _400_ and _900_.

Given a roman numeral, convert it to an integer.

## Run:
Add in your IDEs new run configuration with arguments. The only argument is a roman numeral