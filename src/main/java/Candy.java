public class Candy extends Gift{
    private int days;
    public Candy(int idG, String nameG, double weightG, double priceG, int daysG) {
        super(idG, nameG, weightG, priceG);
        this.days = daysG;
    }

    public int getDays()
    {
        return days;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", days=" + days +
                '}';
    }
}
