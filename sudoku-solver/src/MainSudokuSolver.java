import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainSudokuSolver {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }

    private static void solveSudoku(char[][] board) {
        List<List<List<Integer>>> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            List<List<Integer>> row = new ArrayList<>();
            for (int j = 0; j <= 8; j++) {
                if (board[i][j] != '.') {
                    //Если есть в этой строке данные, то заносим их в соответствующую ячейку
                    List<Integer> value = new ArrayList<>();
                    value.add(Character.getNumericValue(board[i][j]));
                    row.add(j, value);
                } else {
                    //Если данных нет, то заносим туда лист с всеми возможными значениями
                    List<Integer> valueList = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());
                    row.add(j, valueList);
                }
            }
            //Заполняем столбцы строками
            list.add(i, row);
        }

        rec(list);
    }

    private static void recursion(List<List<List<Integer>>> list, int i, int j) {
        List<Integer> existsValueInBox = new ArrayList<>();
        for (int k = i; k <= i + 2; k++) {
            for (int l = j; l <= j + 2; l++) {
                List<Integer> integers = list.get(k).get(l);
                if (integers.size() == 1) {
                    existsValueInBox.add(integers.get(0));
                }
            }
        }
        for (int k = i; k <= i + 2; k++) {
            for (int l = j; l <= j + 2; l++) {
                List<Integer> integers = list.get(k).get(l);
                if (integers.size() != 1) {
                    existsValueInBox.forEach(valExists -> integers.removeIf(val -> Objects.equals(val, valExists)));
                }
            }
        }
        if (i + 3 < 9) {
            i += 3;
        } else {
            i = 0;
            j += 3;
        }
        if (j != 9)
            recursion(list, i, j);
    }

    private static void rec(List<List<List<Integer>>> list){
        System.out.println(list);
        System.out.println("Прошли по строкам");

        //Проходим по строкам
        for (List<List<Integer>> lists : list) {
            //Список значений, которые уже есть в строке
            List<Integer> existsValueInRow = new ArrayList<>();
            for (List<Integer> integers : lists) {
                if (integers.size() == 1) {
                    existsValueInRow.add(integers.get(0));
                }
            }
            for (List<Integer> integers : lists) {
                if (integers.size() != 1) {
                    //Удаляем из возможных значений в этой строке все те значения, которые уже существуют в данной строке
                    existsValueInRow.forEach(valExists -> integers.removeIf(val -> Objects.equals(val, valExists)));
                }
            }
        }

        System.out.println(list);
        System.out.println("Прошли по строкам");

        //Проходим по столбцам
        for (int j = 0; j <= 8; j++) {
            //Список значений, которые уже есть в столбце
            List<Integer> existsValueInColumn = new ArrayList<>();
            for (int i = 0; i <= 8; i++) {
                List<Integer> integers = list.get(i).get(j);
                if (integers.size() == 1) {
                    existsValueInColumn.add(integers.get(0));
                }
            }
            for (int i = 0; i <= 8; i++) {
                List<Integer> integers = list.get(i).get(j);
                if (integers.size() != 1) {
                    //Удаляем из возможных значений в этом столбце все те значения, которые уже существуют в данном столбце
                    existsValueInColumn.forEach(valExists -> integers.removeIf(val -> Objects.equals(val, valExists)));
                }
            }
        }

        System.out.println(list);
        System.out.println("Прошли по столбцам");

        //Проходим по секторам 3*3
        recursion(list,0,0);

        System.out.println(list);
        System.out.println("Начинаем все с начала");

        for (List<List<Integer>> lists : list) {
            for (List<Integer> integers : lists) {
                if(integers.size()!=1) {
                    rec(list);
                    break;
                }
            }
        }
    }
}
