package utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg){
        this(code,msg,null);
    }

    public static<T> CommonResult<T> ok(T data){
        CommonResult<T> result = new CommonResult<>(200,"success",data);
        return result;
    }

    public static<T> CommonResult<T> fail(T data){
        CommonResult<T> result = new CommonResult<>(400,"failed",data);
        return result;
    }
}
