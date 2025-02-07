package core.basesyntax.models;

import java.util.Arrays;
import java.util.Objects;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int amount;

    public FruitTransaction(Operation operation, String fruit, int amount) {
        this.operation = operation;
        this.fruit = fruit;
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitTransaction that = (FruitTransaction) o;
        return amount == that.amount
                && Objects.equals(operation, that.operation)
                && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, fruit, amount);
    }

    public static Operation getOperationByString(String string) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getLetter().equals(string))
                .findFirst().get();
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
               + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", amount=" + amount
                + '}';
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String letter;

        Operation(String letter) {
            this.letter = letter;
        }

        public String getLetter() {
            return letter;
        }
    }
}
