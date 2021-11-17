package Lab4Java;

public class Phone
{
    private int hits;
    private String phoneName;
    private String slug;
    private String detail;

    public Phone()
    { }

    /**
     * @param hits
     * @param detail
     * @param phoneName
     * @param slug
     */
    public Phone(String phoneName, String slug, String detail, int hits)
    {
        super();
        this.hits = hits;
        this.phoneName = phoneName;
        this.slug = slug;
        this.detail = detail;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString()
    {
        return "Phone{" +
                "hits=" + hits +
                ", phoneName='" + phoneName + '\'' +
                ", slug='" + slug + '\'' +
                ", detail='" + detail + '\'' +
                "}\n";
    }
}