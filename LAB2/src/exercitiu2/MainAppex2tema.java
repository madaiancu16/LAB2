package exercitiu2;

import java.io.*;
import java.util.Random;

class Vers {
    private String text_Vers;

    public Vers(String textvers) {
        this.text_Vers = textvers;
    }

    public int nr_cuv() {
        return text_Vers.split("\\s+").length;
    }

    public int nr_voc() {
        int k = 0;
        String vocale = "aeiouAEIOU";
        for (int i = 0; i < text_Vers.length(); i++) {
            if (vocale.indexOf(text_Vers.charAt(i)) != -1) {
                k++;
            }
        }
        return k;
    }

    public String getTextVers() {
        return text_Vers;
    }
}
public class MainAppex2tema {

    public static void main(String[] args) throws IOException {

        String gr_fin = "la";
        Random random = new Random();
        BufferedReader br = new BufferedReader(new FileReader("src/exercitiu2/cantec_in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/exercitiu2/cantec_out.txt"));
        Vers[] versuri = new Vers[100];
        int count = 0;
        String rand;

        while ((rand = br.readLine()) != null) {
            versuri[count] = new Vers(rand);
            count++;
        }

        for (int i = 0; i < count; i++) {
            Vers vers = versuri[i];
            int nr_cuv = vers.nr_cuv();
            int nr_vocale = vers.nr_voc();
            String rand_nou = vers.getTextVers();

            boolean ultim_la = rand_nou.endsWith(gr_fin);

            double numar_a = random.nextDouble();
            if (numar_a < 0.1) {
                rand_nou = rand_nou.toUpperCase();
            }

            if (ultim_la) {
                rand_nou += " *";
            }

            bw.write(rand_nou + " | Cuvinte: " + nr_cuv + " | Vocale: " + nr_vocale);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}