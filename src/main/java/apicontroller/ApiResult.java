package apicontroller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApiResult {
    SUCCESS(2000, "Success"),
    INVALID_REQUEST(2001, "Invalid request"),
    NEGATIVE_BALANCE(2002, "Balance cannot be negative"),
    ACCOUNT_NOT_FOUND(2003, "Account is not founded"),
    ACCOUNT_ALREADY_EXIST(2004, "Account is already exists"),
    INSUFFICIENT_FUNDS(2005, "Insufficient balance"),
    CURRENCY_DOES_NOT_MATCH(2006, "Currencies does not match"),
    SYSTEM_ERROR(2099, "System error");

    private int status;
    private String description;

    ApiResult(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String toJSON(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        }catch (Exception e){
            return "";
        }
    }
}