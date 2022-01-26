import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import managers.RestManager;

public class BaseHelper {
    public Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public RestManager restManager = new RestManager();
}
