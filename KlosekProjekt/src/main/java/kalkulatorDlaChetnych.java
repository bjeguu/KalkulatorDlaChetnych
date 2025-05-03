import java.util.Scanner;

public class kalkulatorDlaChetnych {


    public static void main(String[] args) {
        Scanner czytnik = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nNo to co dzisiaj liczymy?");
            System.out.println("1. Sprężynka - wahadło");
            System.out.println("2. Matematyczne machanie");
            System.out.println("3. Oba na raz!");
            System.out.println("0. Koniec zabawy");
            System.out.print("Wybieraj: ");
            wybor = czytnik.nextInt();
            czytnik.nextLine();

            switch (wybor) {
                case 1:
                    obliczWahadloSprezynowe(czytnik);
                    break;
                case 2:
                    obliczWahadloMatematyczne(czytnik);
                    break;
                case 3:
                    obliczWahadloSprezynowe(czytnik);
                    obliczWahadloMatematyczne(czytnik);
                    break;
                case 0:
                    System.out.println("Dzięki za liczenie!");
                    break;
                default:
                    System.out.println("Ups, nie rozumiem. Jeszcze raz?");
            }
        } while (wybor != 0);

        czytnik.close();
    }

    public static void obliczWahadloSprezynowe(Scanner skaner) {
        System.out.println("\n--- Liczymy sprężynkę ---");
        System.out.print("Podaj masę (m) w kilogramach: ");
        double masaSprezyny = skaner.nextDouble();
        System.out.print("A teraz stała sprężystości (k) w niutonach na metr: ");
        double stalaSprezystosci = skaner.nextDouble();

        if (masaSprezyny > 0 && stalaSprezystosci > 0) {
            double okresSprezyny = 2 * Math.PI * Math.sqrt(masaSprezyny / stalaSprezystosci);
            double czestotliwoscSprezyny = 1 / okresSprezyny;
            System.out.println("Okres tego wahadła: " + String.format("%.4f", okresSprezyny) + " sekund");
            System.out.println("Częstotliwość: " + String.format("%.4f", czestotliwoscSprezyny) + " herców");
        } else {
            System.out.println("Coś tu nie gra z danymi sprężynki (masa i stała muszą być większe od zera!).");
        }
    }

    public static void obliczWahadloMatematyczne(Scanner input) {
        System.out.println("\n--- Czas na matematyczne machanie ---");
        System.out.print("Podaj długość (l) w metrach: ");
        double dlugoscWahadla = input.nextDouble();
        System.out.print("No i przyspieszenie ziemskie (g) w m/s^2 (dla Ziemi to około 9.81): ");
        double grawitacja = input.nextDouble();

        if (dlugoscWahadla > 0 && grawitacja > 0) {
            double okresWahadla = 2 * Math.PI * Math.sqrt(dlugoscWahadla / grawitacja);
            double czestotliwoscWahadla = 1 / okresWahadla;
            System.out.println("Okres matematycznego machania: " + String.format("%.4f", okresWahadla) + " s");
            System.out.println("Częstotliwość tego machania: " + String.format("%.4f", czestotliwoscWahadla) + " Hz");
        } else {
            System.out.println("Oj, chyba coś nie tak z danymi matematycznego wahadła (długość i grawitacja muszą być większe od zera!).");
        }
    }
}