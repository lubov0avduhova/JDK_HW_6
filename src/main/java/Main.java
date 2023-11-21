import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям
 */
public class Main {
    private static int quantityDoors = 3;
    private static int quantityIteration = 1000;

    public static void main(String[] args) {
        int countWinner = 0;
        int countLoser = 0;
        for (int i = 0; i < processingGame().size(); i++) {
            if (processingGame().get(i + 1)) countWinner++;
            else countLoser++;

        }
        System.out.println("Выигрышных комбинаций: " + countWinner + "\nПроигрышных комбинаций: " + countLoser);

        double percentWinner = (double) (countWinner * 100) / quantityIteration;
        double percentLoser = (double) (countLoser * 100) / quantityIteration;
        System.out.println("% выигрышных комбинаций: " + percentWinner + "\n% проигрышных комбинаций: " + percentLoser);
    }

    /**
     * Метод получения парадокс Монти Холла
     *
     * @return коллекция результатов комбинаций
     */
    public static Map<Integer, Boolean> processingGame() {
        int counterIteration = 0;
        Map<Integer, Boolean> result = new HashMap<>();
        while (counterIteration < quantityIteration) {
            int winningDoor = new Random().nextInt(quantityDoors) + 1;
            int selectedDoor = new Random().nextInt(quantityDoors) + 1;
            result.put(counterIteration + 1, resultGame(winningDoor, selectedDoor));
            counterIteration++;
        }
        return result;
    }

    /**
     * Метод получения результата за один проход
     *
     * @param winningDoor  Дверь с выигрышем
     * @param selectedDoor Выбранная дверь
     * @return true если выбранная дверь оказалась выигрышной
     */
    public static boolean resultGame(int winningDoor, int selectedDoor) {
        int setNewDoor = new Random().nextInt(2); // Смена решения выбора: если 0 то не меняем, если 1 меняем
        if (winningDoor == selectedDoor) {
            return setNewDoor == 0;
        }
        return setNewDoor == 1;
    }
}
