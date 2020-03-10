
public class Cookies extends Gift{
    private String country;
    public Cookies(int idG, String nameG, double weightG, double priceG, String countryG) {
        super(idG, nameG, weightG, priceG);
        this.country = countryG;
    }
    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Cookies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", country='" + country + '\''+
                '}';
    }
}
