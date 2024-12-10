public class Company {
    private int id;
    private String name;
    private String industry;

    public Company(int id, String name, String industry) {
        this.id = id;
        this.name = name;
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "Company{id=" + id + ", name='" + name + "', industry='" + industry + "'}";
    }
