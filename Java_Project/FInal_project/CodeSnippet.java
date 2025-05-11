package application;

/**
 * A concrete implementation of a code snippet.
 * Inherits fields and methods from the abstract class AbstractSnippet.
 */
public class CodeSnippet extends AbstractSnippet {

    /**
     * Default no-argument constructor.
     * Required if using serialization tools (like Gson), though not used in this version.
     */
    public CodeSnippet() {
        super();
    }

    /**
     * Full constructor for a code snippet.
     *title    Title of the snippet
     *language Programming language of the snippet
     *content  The actual code content
     */
    public CodeSnippet(String title, String language, String content) {
        super(title, language, content);
    }

    /**
     * Returns the type of this snippet.
     * @return A string representing the snippet type ("Code").
     */
    @Override
    public String getSnippetType() {
        return "Code";
    }
}

