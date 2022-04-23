package vn.techmaster.ex02.model;

public enum Location {
    HA_NOI("Hanoi"),
    HAI_PHONG("Haiphong"),
    DA_NANG("Danang"),
    HO_CHI_MINH("TPHCM");

    public final String value;

    Location(String value) {
        this.value = value;
    }

}
