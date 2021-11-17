package Lab4Java;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONFunctions extends Thread
{
    public String jsonDataInput;
    public static String pageUrl;

    private String readAllData(Reader reader) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1)
            builder.append((char) cp);
        return builder.toString();
    }

    public String getData()
    {
        jsonDataInput = "";
        InputStream inputStream = null;
        try {
            inputStream = new URL(pageUrl).openStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                try {
                    jsonDataInput = readAllData(bufferedReader);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return jsonDataInput;
    }

    @Override
    public void run()
    {
        getData();
        super.run();
    }
}