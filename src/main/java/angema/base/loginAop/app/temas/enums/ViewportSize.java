package angema.base.loginAop.app.temas.enums;

public enum ViewportSize {
    XXS("0"),
    XS("390"),
    SM("640"),
    MD("768"),
    LG("1024"),
    XL("1280");

    private final String size;

    ViewportSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}