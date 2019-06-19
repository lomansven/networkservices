package nl.sneakerjagers.demo.Models;

public class Link {

    private String href;
    private String text;

    public Link(String text, String href) {

        this.href = href;
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public String getText() {
        return text;
    }

}
