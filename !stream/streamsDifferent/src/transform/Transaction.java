package transform;

public class Transaction {
    private final String name;
    private final boolean credit;
    private final double amount;

    public Transaction(String name, boolean credit, double amount) {
        this.name = name;
        this.credit = credit;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public boolean isCredit() {
        return credit;
    }

    public double getAmount() {
        return amount;
    }
}
