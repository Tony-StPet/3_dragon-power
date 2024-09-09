import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int number = 13;
        findArithmeticSummands(number);
    }

    private static void findArithmeticSummands(int n) {
        System.out.println("Число голов: " + n);
        System.out.println("Арифметические слагаемые без 1:");

        // Создаем список для хранения последовательностей
        List<String> sequences = new ArrayList<>();

        // Рекурсивно находим слагаемые
        findSummandsRecursive(n, 2, "", sequences);

        // Выводим количество найденных последовательностей
        System.out.println("Найдено " + sequences.size() + " последовательностей");

        // Выводим последовательности и их силу
        for (String sequence : sequences) {
            System.out.println(sequence);

            // Вычисляем и выводим силу для текущей последовательности
            int power = 1;
            String[] parts = sequence.split("\\+");
            for (String part : parts) {
                power *= Integer.parseInt(part);
            }
            System.out.println("Сила равна = " + power);
        }
    }

    private static void findSummandsRecursive(int remaining, int start, String currentSum, List<String> sequences) {
        // Если оставшееся число равно 0, значит нашли слагаемое
        if (remaining == 0) {
            // Если в currentSum нет 1, добавляем его в список последовательностей
            if (!currentSum.contains("1")) {
                sequences.add(currentSum);
                System.out.println("Добавлена последовательность: " + currentSum);
            }
            return;
        }

        // Перебираем возможные слагаемые, начиная с start
        for (int i = start; i <= remaining; i++) {
            // Формируем новое слагаемое
            String newSum = currentSum.isEmpty() ? String.valueOf(i) : currentSum + "+" + i;
            // Рекурсивно ищем следующие слагаемые
            findSummandsRecursive(remaining - i, i, newSum, sequences);
        }
    }
}
