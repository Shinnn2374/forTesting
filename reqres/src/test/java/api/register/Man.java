package api.register;

public class Man
{
    private String name;
    private String job;

    public Man(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public Man() {
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
