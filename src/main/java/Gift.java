public abstract class Gift {
    public String name;
    public double weight;
    public double price;
    public int id;

    public Gift(int idG, String nameG, double weightG, double priceG) {
        this.name = nameG;
        this.weight = weightG;
        this.price = priceG;
        this.id = idG;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
