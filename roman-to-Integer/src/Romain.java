public class Romain {
    private Character key;
    private Integer value;
    private Boolean isBefore;

    public Romain(Character key, Integer value, Boolean isBefore) {
        this.key = key;
        this.value = value;
        this.isBefore = isBefore;
    }

    public Character getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
    public Boolean getBefore() {
        return isBefore;
    }
}
