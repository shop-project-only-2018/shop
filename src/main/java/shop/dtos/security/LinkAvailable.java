package shop.dtos.security;

public class LinkAvailable {

    private String href;
    private String text;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LinkAvailable() {
    }

    public LinkAvailable(String href, String text) {
        this.href = href;
        this.text = text;
    }

}
