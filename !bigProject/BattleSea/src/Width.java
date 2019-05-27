public enum Width {
    A("A"), B("B"), C("С"), D("D"), E("E"), F("F"), G("G"), H("H"), I("I"), J("J");

    private String name;

    Width(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
