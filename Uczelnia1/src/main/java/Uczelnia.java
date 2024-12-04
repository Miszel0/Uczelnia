import Seeders.MainSeeder;
import Services.CandidateService;

import java.util.Scanner;

public class Uczelnia {
    public static void main(String[] args) {
        CandidateService candidateService= new CandidateService();
        Scanner scanner = new Scanner(System.in);
        MainSeeder.seed(); // uzupełnienie danych (opcjonalnie)

        System.out.println("Witamy ponownie!");
        boolean open = true;
        while (open) {
            System.out.print(
                    "==============================================" +
                            "\nDostępne opcje: " +
                            "\n \t 1. Wyszukanie po nazwisku " +
                            "\n \t 2. Wyszukanie z listy " +
                            "\n \t 3. Zakończenie pracy " +
                            "\n Wybierz opcję (1-3): "
            );

            int option = scanner.nextInt();
            System.out.println("==============================================");

            switch (option) {
                case 1 -> candidateService.verifyByName();
                case 2 -> candidateService.verifyByList();
                case 3 -> open = false;

                default -> System.out.println("Opcja niedostępna!");
            }
        }

        System.out.println("\nZamykanie programu.");
    }
}