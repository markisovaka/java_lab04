import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiClient {
    private static final Gson gson = new Gson();

    public static List<User> fetchUsers(String apiUrl) throws Exception {
        String jsonResponse = makeRequest(apiUrl);
        Type userListType = new TypeToken<List<User>>() {}.getType();
        return gson.fromJson(jsonResponse, userListType);
    }

    public static List<Company> fetchCompanies(String apiUrl) throws Exception {
        String jsonResponse = makeRequest(apiUrl);
        Type companyListType = new TypeToken<List<Company>>() {}.getType();
        return gson.fromJson(jsonResponse, companyListType);
    }

    private static String makeRequest(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }
    }
}
