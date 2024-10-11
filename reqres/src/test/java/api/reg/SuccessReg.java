package api.reg;

public class SuccessReg
{
    private Integer id;
    private String token;


    public SuccessReg(Integer id, String token)
    {
        this.id = id;
        this.token = token;
    }

    public SuccessReg()
    {
    }

    public String getToken() {
        return token;
    }

    public Integer getId() {
        return id;
    }
}
