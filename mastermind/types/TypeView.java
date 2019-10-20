package mastermind.types;

public enum TypeView {
    CONSOLE;

    public static TypeView get(String string) {
        for (TypeView vType : TypeView.values()) {
            if (vType.name().equalsIgnoreCase(string)) {
                return vType;
            }
        }
        return TypeView.CONSOLE;
    }
}
