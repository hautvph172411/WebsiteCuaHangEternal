package webbangiaydabong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {
    private HttpStatus httpStatus;
    private String message;
    private Object object;
}
