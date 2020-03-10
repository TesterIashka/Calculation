/**
 * Конструктор сделан для того, чтобы вернуть объект с двумя значениями double
 * {@param #oneNumber} первое значение
 * {@param #twoNumber} второе значение
 */

final class getTwoDouble {

    private final double firstNumber;
    private final double secondNumber;

    public getTwoDouble(double first, double second) {
        this.firstNumber = first;
        this.secondNumber = second;
    }

    public double getFirst() {
        return firstNumber;
    }
    public double getSecond() {
        return secondNumber;
    }

}
