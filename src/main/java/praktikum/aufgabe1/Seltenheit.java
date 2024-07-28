package praktikum.aufgabe1;

public enum Seltenheit {
    HAEUFIG, NORMAL, SELTEN;

    @Override
    public String toString() {
        return switch (this.ordinal()) {
            case (0) -> "häufig";
            case (1) -> "normal";
            case (2) -> "selten";
            default -> "";
        };
    }
}
