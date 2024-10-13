package exercitiul4;
import java.time.LocalDate;
import java.util.Scanner;
class Persoana {
    private final String nume;
    private  final String cnp;
    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }
    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }
    public int getVarsta() {
        String anul_nasterii = cnp.substring(1, 3);
        char prima_cif = cnp.charAt(0);
        int secol;
        if (prima_cif == '1' || prima_cif == '2') {
            secol = 1900;
        } else if (prima_cif == '5' || prima_cif == '6') {
            secol = 2000;
        } else {
            return -1;
        }
        int an_nastere = secol + Integer.parseInt(anul_nasterii);
        int an_curent = LocalDate.now().getYear();
        return an_curent - an_nastere;
    }
}
public class MainAppex4tema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Persoana[] persoane = new Persoana[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Persoana " + (i + 1));
            System.out.print("Nume: ");
            String nume = scanner.nextLine();
            String cnp;
            do {
                System.out.print("CNP: ");
                cnp = scanner.nextLine();
            } while (!cnpValid(cnp));

            persoane[i] = new Persoana(nume, cnp);
        }

        System.out.println("Informații persoane:");
        for (Persoana persoana : persoane) {
            System.out.println(persoana.getNume() + ", CNP: " + persoana.getCnp() + ", Vârstă: " + persoana.getVarsta());
        }

            scanner.close();
        }


    public static boolean cnpValid(String cnp) {
        if (cnp.length() != 13) {
            System.out.println("CNP-ul trebuie să aibă 13 caractere.");
            return false;
        }

        for (int i = 0; i < cnp.length(); i++) {
            if (!Character.isDigit(cnp.charAt(i))) {
                System.out.println("CNP-ul trebuie să conțină doar cifre.");
                return false;
            }
        }

        char prima_cif = cnp.charAt(0);
        if (prima_cif != '1' && prima_cif != '2' && prima_cif != '5' && prima_cif != '6') {
            System.out.println("Prima cifră a CNP-ului trebuie să fie 1, 2, 5 sau 6.");
            return false;
        }

        return true;
    }
}
