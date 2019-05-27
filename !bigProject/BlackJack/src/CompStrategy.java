public class CompStrategy implements Strategy {
    private Player player;

    public void init(Player player) {
        this.player = player;
    }

    @Override
    public boolean toGet() {
        int summa = player.getValue();
        return summa <= 17;
    }
}
