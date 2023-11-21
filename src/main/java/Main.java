import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 � �������� ������ ��������� ��� ����������� ��� ��� ������������ ��������� ����� ����� (�������� ����� ����� � ��������� ) � �������� ��������� � �������� ��������� (��������� ���� � ����� �� 1000 � ������� �������� ����).
����������:
������� ���� Java Maven ��� Gradle ������;
�������������� ����������� ���������� ������;
��������� ��������� � HashMap<��� �����, ���������>
������� �� ����� ���������� �� ������� � ����������
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
        System.out.println("���������� ����������: " + countWinner + "\n����������� ����������: " + countLoser);

        double percentWinner = (double) (countWinner * 100) / quantityIteration;
        double percentLoser = (double) (countLoser * 100) / quantityIteration;
        System.out.println("% ���������� ����������: " + percentWinner + "\n% ����������� ����������: " + percentLoser);
    }

    /**
     * ����� ��������� �������� ����� �����
     *
     * @return ��������� ����������� ����������
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
     * ����� ��������� ���������� �� ���� ������
     *
     * @param winningDoor  ����� � ���������
     * @param selectedDoor ��������� �����
     * @return true ���� ��������� ����� ��������� ����������
     */
    public static boolean resultGame(int winningDoor, int selectedDoor) {
        int setNewDoor = new Random().nextInt(2); // ����� ������� ������: ���� 0 �� �� ������, ���� 1 ������
        if (winningDoor == selectedDoor) {
            return setNewDoor == 0;
        }
        return setNewDoor == 1;
    }
}
