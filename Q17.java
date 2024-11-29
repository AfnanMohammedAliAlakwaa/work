class Flowers{
    public String name ;
    public int PetalsNumber ;
    public double price;

    public Flowers(String name, int PetalsNumber, double price) {
        this.name = name;
        this.PetalsNumber = PetalsNumber;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPetalsNumber() {
        return PetalsNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPetalsNumber(int PetalsNumber) {
        this.PetalsNumber = PetalsNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
public class Q17 {
    public static void main(String[] args) {
        Flowers obj1 = new Flowers("Orchid flower " , 5 , 2000.70);
        System.out.println("The flower is " + obj1.getName() + "The number of petals "+ obj1.getPetalsNumber() + " The price is " + obj1.getPrice());
    }

}
