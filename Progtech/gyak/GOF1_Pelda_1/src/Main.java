public class Main {
    public static void main(String[] args) throws Exception {
        Alkalmazottak alkalmazottak = new Alkalmazottak();
        alkalmazottak.hozzaad("Novák Laci", 18000);
        alkalmazottak.hozzaad("Berényi András", 30000);
        alkalmazottak.hozzaad("Magdi Anyus", 12000);
        alkalmazottak.hozzaad("Vili Bácsi", 16000);

        System.out.println("Atlag Fizu: " + alkalmazottak.atlagFizetes());
        System.out.println("Legnagyobb Fizu: " + alkalmazottak.legnagyobbFizu());
        System.out.println("Ki keresi a legtöbbet: " + alkalmazottak.kiKeresiALegtobbet());
    }
}