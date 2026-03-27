import java.util.Scanner;
import java.util.Random;

public class CodeGenerator {

    // Цвета для оформления
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED   = "\u001B[31m";
    public static final String ANSI_CYAN  = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private static long currentId = 2147483648L;
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1": generateAndPrint(1); break;
                case "2": generateAndPrint(5); break;
                case "3": generateAndPrint(10); break;
                case "4": convertIdToTagMenu(scanner); break;
                case "5": convertTagToIdMenu(scanner); break;
                case "0":
                    System.out.println(ANSI_CYAN + "Завершение работы. Удачи, Styonly!" + ANSI_RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println(ANSI_RED + "Ошибка: Выберите пункт меню от 0 до 5." + ANSI_RESET);
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- " + ANSI_CYAN + "Brawl Stars Code Utility v3.8" + ANSI_RESET + " ---");
        System.out.println("1. Генерировать " + ANSI_GREEN + "1" + ANSI_RESET + " случайный код");
        System.out.println("2. Генерировать " + ANSI_GREEN + "5" + ANSI_RESET + " случайных кодов");
        System.out.println("3. Генерировать " + ANSI_GREEN + "10" + ANSI_RESET + " случайных кодов");
        System.out.println("4. Узнать " + ANSI_PURPLE + "ТЕГ по ID" + ANSI_RESET);
        System.out.println("5. Узнать " + ANSI_PURPLE + "ID по ТЕГУ" + ANSI_RESET);
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void generateAndPrint(int count) {
        System.out.println("\n" + ANSI_CYAN + "--- Сгенерированные коды ---" + ANSI_RESET);
        for (int i = 0; i < count; i++) {
            // Создаем случайный прыжок ID для разнообразия
            currentId += random.nextInt(1000000) + 500;
            String code = LongToCodeConverter.convert(currentId);
            System.out.println("ID: " + currentId + " -> Код: " + ANSI_GREEN + code + ANSI_RESET);
        }
        System.out.println(ANSI_CYAN + "----------------------------" + ANSI_RESET);
    }

    private static void convertIdToTagMenu(Scanner scanner) {
        System.out.print("\nВведите числовой ID: ");
        try {
            long id = Long.parseLong(scanner.nextLine());
            String tag = LongToCodeConverter.convert(id);
            System.out.println(ANSI_GREEN + "Результат: ТЕГ " + tag + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Ошибка: Введите целое число!" + ANSI_RESET);
        }
    }

    private static void convertTagToIdMenu(Scanner scanner) {
        System.out.print("\nВведите ТЕГ (например, XJ2LL7): ");
        String tag = scanner.nextLine().trim().toUpperCase();
        long id = LongToCodeConverter.convertToId(tag);
        System.out.println(ANSI_GREEN + "Результат: ID " + id + ANSI_RESET);
    }
}