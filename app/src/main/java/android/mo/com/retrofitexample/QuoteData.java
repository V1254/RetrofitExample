package android.mo.com.retrofitexample;

/**
 * Simple representation of a quote retrieved from the api.
 */
public class QuoteData {
    private int id;
    private String author;
    private String quote;
    private String permalink;

    public QuoteData(int id, String author, String quote, String permalink) {
        this.id = id;
        this.author = author;
        this.quote = quote;
        this.permalink = permalink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
