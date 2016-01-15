package network;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ucash on 2016-01-14.
 */
public class Gra {

    private List<Cecha> cechy = new ArrayList<Cecha>();
    private List<Double> taks = new ArrayList<Double>();
    private List<Double> nies = new ArrayList<Double>();



    /*
     * Każdy symptom może mieć tylko 2 stany.
     *
     * Symptomy (Cechy) należy dodawać w takiej kolejności jak występują w Genie.
     *
     * Drugim argumentem w konstruktorze cecha jest wartość jaką chcemy przydzielić
     * pierwszemu stanowi symptomu, musi być z przedziału <0,1>.
     *
     * Pojedynczym wynikiem jest średnia arytmetyczna dla występujących stanów.
     */
    public Gra(){
        cechy.add(new Cecha("nowa", 0.25));
        cechy.add(new Cecha("rywa", 0.8));
        cechy.add(new Cecha("rts", 1));
        cechy.add(new Cecha("dluga", 0.6));
        cechy.add(new Cecha("tur", 0));
    }

    public void getResult(){
        int val = (int)Math.pow(2, cechy.size()) - 1;
        while (val >= 0){
            String bin = Integer.toString(val, 2);
            while (bin.length() < cechy.size()){
                bin = "0" + bin;
            }
            char[] mask = bin.toCharArray();
            double sum = 0.0;
            for (int i = 0; i < cechy.size(); i++){
                if (mask[i] == '1'){
                    sum += cechy.get(i).Tak;
                } else {
                    sum += cechy.get(i).Nie;
                }
            }
            double wynik = sum / cechy.size();
            taks.add(wynik);
            nies.add(1 - wynik);
            val --;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taks.size(); i++){
            sb.append(String.format("%.2f", taks.get(i)));
            sb.append("\t");
        }
        sb.append('\n');
        for (int i = 0; i < nies.size(); i++){
            sb.append(String.format("%.2f", nies.get(i)));
            sb.append("\t");
        }
        System.out.print(sb.toString().replace(',', '.'));
    }

}
