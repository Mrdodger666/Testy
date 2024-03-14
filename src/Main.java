import java.security.PublicKey;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static String city;
    public static int age;
    public static String weekday;
    public static double discount;

    public static void main(String[] args) throws Exception {
        double cenaBiletu = CalculateCena();
        System.out.println("Dane:" + city +", " + age + ", " + weekday+"\n"+ "Cena biletu:" + cenaBiletu + "\n" + "Zniżka:" + (discount * 100) + "%");
    }


    public static int getWiek() throws Exception {
        int wiek;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj swój wiek:");
            wiek = scanner.nextInt();
            age = wiek;
        } catch (Exception exc) {
            throw new Exception("Niepoprawny wiek");

        }
        if (wiek < 1 || wiek > 150) {
            throw new Exception("Wiek musi byc z zakresu  1 i 150");
        }
        return wiek;
    }

    public static String getmiejscezamieszkania() throws Exception {
        String miasto;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj miejsce zamieszkania:");
            miasto = scanner.next();
            city=miasto;
        } catch (Exception exc) {
            throw new Exception("Niepoprawne miasto");
        }
        return miasto;
    }

    public static String getdzientygodnia() throws Exception {
        HashSet<String> dnitygodnia = new HashSet<>();
        dnitygodnia.add("poniedziałek");
        dnitygodnia.add("wtorek");
        dnitygodnia.add("środa");
        dnitygodnia.add("czwartek");
        dnitygodnia.add("piątek");
        dnitygodnia.add("sobota");
        dnitygodnia.add("niedziela");

        String dzienTygodnia;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj dzień tygodnia:");
            dzienTygodnia = scanner.next();
            weekday = dzienTygodnia;
        } catch (Exception exc) {
            throw new Exception("Niepoprawny dzień tygodnia");
        }
        if (!dnitygodnia.contains(dzienTygodnia)) {
            throw new Exception("Niepoprawny dzień tygodnia");
        }
        return dzienTygodnia;
    }

    public static double ApplyDiscountBasedOnWeekday() throws Exception {
        double ZnizkaProc = 0;
        if (getdzientygodnia().equals("czwartek"))
        {
           ZnizkaProc = 1;
        }
        return ZnizkaProc;
    }

    public static double ApplyDiscountBasedOnAge() throws Exception {
        double ZnizkaProc = 0;
        int w=getWiek();
        if (w < 10)
        {
            ZnizkaProc = 1;
        } else if (w < 18) {
            ZnizkaProc = 0.5;
        }
        return ZnizkaProc;
    }

    public static double ApplyDiscountBasedOnCity() throws Exception {
        double ZnizkaProc = 0;
        if (getmiejscezamieszkania().equals("Warszawa"))
        {
            ZnizkaProc = 0.2;
        }
        return ZnizkaProc;
    }
    public static double CalculateCena() throws Exception {
        double cenaBiletu = 40;
        double ZnizkaProc = CalculateZnizka();

        cenaBiletu = cenaBiletu - cenaBiletu * ZnizkaProc;
        return cenaBiletu;
    }

    public static double CalculateZnizka() throws Exception {
      double z= ApplyDiscountBasedOnAge() + ApplyDiscountBasedOnCity() + ApplyDiscountBasedOnWeekday();

      if(z>1){
          z=1;
      }
      discount = z;
      return z;
    }
}
