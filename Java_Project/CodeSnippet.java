/**
 * CodeSnippet is a concrete class that extends AbstractSnippet.
 */
public class CodeSnippet extends AbstractSnippet {

    public CodeSnippet(String title, String language, String content) {
        super(title, language, content);
    }

    @Override
    public String getSnippetType() {
        return "Code";
    }
}

