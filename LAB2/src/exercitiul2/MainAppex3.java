package exercitiul2;
import java.util.Scanner;
public class MainAppex3 {
    public static void main(String[] args ) {
        int pozitia;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Sirul de baza: ");
        StringBuilder sir=new StringBuilder(scanner.nextLine());
        StringBuilder sir_introdus=new StringBuilder(scanner.nextLine());
        System.out.println("Pozitia: ");
        pozitia=scanner.nextInt();


        sir.insert(pozitia,sir_introdus);
        System.out.println(sir.toString());
        System.out.println("Pozitia de unde sa inceapa stergerea: ");
        int pozitia_inceput=scanner.nextInt();
        System.out.println("Numarul de caractere: ");
        int nr_caractere=scanner.nextInt();
        int poz_final=pozitia_inceput+nr_caractere;
        sir.delete(pozitia_inceput,poz_final);
        System.out.println(sir.toString());


    }
}
