package RestAssured.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse
{
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
