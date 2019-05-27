public class Manipulation {

    private String name;
    private Status status;
    private double money;



    public Manipulation(String name, String status, String money) {
        this.name = name;
        this.status = makeStatus(status);
        this.money = Double.valueOf(money);
    }

    private Status makeStatus(String status) {
        if(status.equals("С")) return Status.CREDIT;
        else return Status.DEBIT;
    }


    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public double getMoney() {
        return money;
    }
}
