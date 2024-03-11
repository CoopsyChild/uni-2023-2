import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

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

    public double atlagFizetes() throws Exception{
        return nemToroltAlkOsszfizetese() / jelenlegiAlkalmazottakSzama();
    }

    public double atlagFizetesV2() throws Exception{
        return alkalmazottak.stream().filter(x -> x.torolve == false).mapToDouble(x -> x.fizu).sum() / alkalmazottak.stream().filter(x -> x.torolve == false).count();
    }

    public int legnagyobbFizu() throws Exception{
        return (int) alkalmazottak.stream().filter(x -> x.torolve == false).mapToDouble(x -> x.fizu).max().getAsDouble();
    }

    public String kiKeresiALegtobbet() throws Exception {
        int maxFizu = legnagyobbFizu();
        return alkalmazottak.stream().filter(x -> x.torolve == false && x.fizu == maxFizu).findFirst().get().nev;
    }

    public String kiKeresiALegtobbetV2() throws Exception {
        int maxFizu = (int) alkalmazottak.stream().filter(x -> x.torolve == false).mapToDouble(x -> x.fizu).max().getAsDouble();
        return alkalmazottak.stream().filter(x -> x.torolve == false && x.fizu == maxFizu).findFirst().get().nev;
    }

    public int osszesEddigiAlkalmazott() {
        return alkalmazottak.size();
    }

    public long jelenlegiAlkalmazottakSzama() {
        return alkalmazottak.stream().filter(x -> x.torolve == false).count();
    }

    public double nemToroltAlkOsszfizetese() {
        return alkalmazottak.stream().filter(x -> x.torolve == false).mapToDouble(x -> x.fizu).sum();
    }
}
