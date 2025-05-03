import java.util.Scanner;

public class kalkulatorDlaChetnych {


    public static void main(String[] args) {
        Scanner czytnik = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nNo to co dzisiaj liczymy?");
            System.out.println("1. Sprężynka - wahadło");
            System.out.println("2. Wachadlo matematyczne");
            System.out.println("3. Oba na raz");
            System.out.println("4. Pozdrowienia dla pana Kłoska");
            System.out.println("0. Koniec programu");
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
                case 4:
                    System.out.println("POZDRAWIIAM PANA KLOSKA!!!!!!!!!!!!!!");
                case 0:
                    System.out.println("Dzięki za liczenie!");
                    break;
                default:
                    System.out.println("Zla wartosc");
            }
        } while (wybor != 0);

        czytnik.close();
    }

    public static void obliczWahadloSprezynowe(Scanner skaner) {
        System.out.println("\n--- Wachadlo prezynowe");
        System.out.print("Podaj masę (m) w kilogramach: ");
        double masaSprezyny = skaner.nextDouble();
        System.out.print("Stala sprężystości (k) w niutonach na metr: ");
        double stalaSprezystosci = skaner.nextDouble();

        if (masaSprezyny > 0 && stalaSprezystosci > 0) {
            double okresSprezyny = 2 * Math.PI * Math.sqrt(masaSprezyny / stalaSprezystosci);
            double czestotliwoscSprezyny = 1 / okresSprezyny;
            System.out.println("Okres tego wahadła: " + String.format("%.4f", okresSprezyny) + " sekund");
            System.out.println("Częstotliwość: " + String.format("%.4f", czestotliwoscSprezyny) + " herców");
        } else {
            System.out.println("Zle dane (masa i stała muszą być większe od zera!).");
        }
    }

    public static void obliczWahadloMatematyczne(Scanner input) {
        System.out.println("\n--- Wachadlo matematyczne --");
        System.out.print("Podaj długość (l) w metrach: ");
        double dlugoscWahadla = input.nextDouble();
        System.out.print("Przyspieszenie (g) w m/s^2 (dla Ziemi to około 9.81) LICZBA MA BYC Z PRZECINKIEM: ");
        double grawitacja = input.nextDouble();

        if (dlugoscWahadla > 0 && grawitacja > 0) {
            double okresWahadla = 2 * Math.PI * Math.sqrt(dlugoscWahadla / grawitacja);
            double czestotliwoscWahadla = 1 / okresWahadla;
            System.out.println("Okres matematycznego wachadla: " + String.format("%.4f", okresWahadla) + " s");
            System.out.println("Częstotliwość tego wachadla: " + String.format("%.4f", czestotliwoscWahadla) + " Hz");
        } else {
            System.out.println("Zle dane (długość i grawitacja muszą być większe od zera!).");
        }
    }
}