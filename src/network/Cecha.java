package network;

public class Cecha {
    public String Nazwa;
    public double Tak;
    public double Nie;

    public Cecha(String nazwa, double tak) {
        this.Nazwa = nazwa;
        this.Tak = tak;
        this.Nie = 1- tak;
    }
}
