package RestAssured.pojos.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SuccessfulRegResponse
{
    private Integer id;
    private String token;
}
