package Lab4Java;

import java.util.ArrayList;
import java.util.List;

public class DailyPhones
{
    private boolean status;
    private String title;
    private List<Phone> phones = new ArrayList<>();

    public DailyPhones()
    { }

    /**
     * @param status
     * @param phones
     * @param title
     */
    public DailyPhones(String title, List<Phone> phones, boolean status)
    {
        super();
        this.title = title;
        this.phones = phones;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) { this.phones = phones; }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("DailyPhones{");
        sb.append("title=").append(title);
        sb.append(", phones=").append(phones);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}