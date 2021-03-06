package asia.dreamdropsakura.commonutils;

public enum ReturnParam {
    ITEMS("items"), TOTAL("total"), ROWS("rows");

    private final String name;

    ReturnParam(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
