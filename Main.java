import java.util.List;

public class Main {
    public static void main(String[] args) {
        String usersUrl = "https://fake-json-api.mock.beeceptor.com/users";
        String companiesUrl = "https://fake-json-api.mock.beeceptor.com/companies";

        try {
            // Получение пользователей
            List<User> users = ApiClient.fetchUsers(usersUrl);
            System.out.println("Users:");
            users.forEach(System.out::println);

            // Получение компаний
            List<Company> companies = ApiClient.fetchCompanies(companiesUrl);
            System.out.println("\nCompanies:");
            companies.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }
}
