package e1.model;

public class Configuration {
    private String language;
    private String page;
    private boolean spam = true;
    private String sign;

    public Configuration(String language, String page, boolean spam, String sign) {
        this.language = language;
        this.page = page;
        this.spam = spam;
        this.sign = sign;
    }

    public Configuration() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean getSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
