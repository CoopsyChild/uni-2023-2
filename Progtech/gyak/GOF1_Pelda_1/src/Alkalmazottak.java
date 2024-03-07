import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Alkalmazottak {

    class Rekord {
        public String nev;
        public double fizu;
        public boolean torolve;
    }
    List<Rekord> alkalmazottak = new ArrayList<>();
    public void hozzaad(String nev, double fizu) {
        Rekord rekord = new Rekord();
        rekord.nev = nev;
        rekord.fizu = fizu;
        rekord.torolve = false;
        alkalmazottak.add(rekord);
    }

    public int indexOf(String nev){
        return alkalmazottak.stream().map(x -> x.nev).toList().indexOf(nev);
    }

    public double getFizu(String nev) throws Exception {
        int index = this.indexOf(nev);
        //if(index == -1) return -1;
        if(index == -1) throw new Exception("Nem létező alkalmazott");
        return alkalmazottak.get(index).fizu;
    }

    public void torles(String nev) throws Exception{
        int index = this.indexOf(nev);
        if(index == -1) throw new Exception("Nem létező alkalmazott");
        alkalmazottak.get(index).torolve = true;
    }

    public int osszesEddigiAlkalmazott() {
        return alkalmazottak.size();
    }

    public long jelenlegiAlkalmazottakSzama() {
        return alkalmazottak.stream().filter(x -> x.torolve == false).count();
    }

    public double nemToroltAlkOsszfizetese() {
        long fizuk = 0;
        return alkalmazottak.stream().filter(x -> x.torolve == false).mapToDouble(x -> x.fizu).sum();
    }
}
