package Lab4Java;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        JSONFunctions jsonFunctions = new JSONFunctions();
        System.out.println("Please wait, data is downloading.");
        JSONFunctions.pageUrl = "https://api-mobilespecs.azharimm.site/v2/top-by-interest";
        jsonFunctions.run();

        String jsonString = jsonFunctions.jsonDataInput;
        System.out.println(jsonString);
        JSONObject obj = null;
        try {
            obj = (JSONObject) new JSONParser().parse(jsonString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();

        DailyPhones dailyPhones = new DailyPhones();

        JSONArray jsonArray = null;
        if (obj != null) {
            dailyPhones.setStatus((boolean) obj.get("status"));
            obj = (JSONObject) obj.get("data");
            jsonArray = (JSONArray) obj.get("phones");
        }

        if (obj != null) {
            dailyPhones.setTitle((String) obj.get("title"));
        }

        for (Object jsonObject : jsonArray)
        {
            JSONObject current = (JSONObject) jsonObject;
            String phoneName = (String) current.get("phone_name");
            String phoneSlug = (String) current.get("slug");
            int hits = Integer.parseInt(current.get("hits").toString());
            String detail = (String) current.get("detail");
            Phone phone = new Phone(phoneName, phoneSlug, detail, hits);
            dailyPhones.addPhone(phone);
        }
        System.out.println(dailyPhones);
        System.out.print("""
        ---------------------------------------------------------------------------------------------------------------
        ---------------------------------------------------------------------------------------------------------------
        """);
        System.out.println("Sorted by hits from smallest to largest:");
        dailyPhones.getPhones().sort(Comparator.comparing(Phone::getHits));
        System.out.println(dailyPhones);
        System.out.print("""
        ---------------------------------------------------------------------------------------------------------------
        ---------------------------------------------------------------------------------------------------------------
        """);
        System.out.println("Sorted by hits from more to less:");
        dailyPhones.getPhones().sort((o1, o2) -> Integer.compare(o2.getHits(), o1.getHits()));
        System.out.println(dailyPhones);
    }
}