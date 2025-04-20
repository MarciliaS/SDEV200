/**
 * Abstract base class for a code snippet.
 */
public abstract class AbstractSnippet {
    protected String title;
    protected String language;
    protected String content;

    public AbstractSnippet(String title, String language, String content) {
        this.title = title;
        this.language = language;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract String getSnippetType();

    @Override
    public String toString() {
        return "Title: " + title + "\nLanguage: " + language + "\nContent:\n" + content;
    }
}

