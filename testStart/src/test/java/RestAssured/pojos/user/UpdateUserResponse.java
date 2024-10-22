package RestAssured.pojos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse
{
    private String name;
    private String job;
    private Date updatedAt;
}
