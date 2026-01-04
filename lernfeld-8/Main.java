// wenn Klassen in unterschiedlichen Dateien sind erfolgt das Abrufen durch "import...."
class Tier {
    String name;
 
    public void lautegeben() {
        System.out.println("Dieses Tier macht Geräusche");
    }
 
    public void vorstellen() {
        System.out.println("Hallo, mein Name ist " + name + ".");
    }
 
    public void schlafen() {
        System.out.println("Ich schlafe");
    }
 
    public void bewegen() {
        System.out.print(name + " bewegt sich gerne");
    }
}
// Wenn Klassen innerhalb der gleichen Datei dann entfällt "public"
class Hund extends Tier {
    @Override
    public void lautegeben() {
        System.out.println("Wau Wau");
    }
}
 
class Katze extends Tier {// extends = erbt von der Elterklasse in diesem Fall Klasse "Tier"
    @Override
    public void lautegeben() {
        System.out.println("Miau Miau");
    }
}
 
public class Main {
    public static void main(String[] args) {
        Hund meinHund = new Hund(); // Ein Objekt vom Typ HUND wird erstellt
        meinHund.name = "Akira";
 
        meinHund.vorstellen();
        meinHund.lautegeben();//Überschrieben in Klasse Hund
        meinHund.schlafen();
        meinHund.bewegen();
 
        System.out.println(); //  // nur für bessere Lesbarkeit
 
        Katze meineKatze = new Katze(); //Ein Objekt vom Typ Katze wird erstellt
        meineKatze.name = "Maja";
 
        meineKatze.vorstellen();
        meineKatze.lautegeben();// Überschrieben in Klassed Katze
        meineKatze.schlafen();
        meineKatze.bewegen();
    }
}