package cmdb.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
	 private String status;
	 private String msg;
	 private T data;
	 
	 
	 public BaseResponse(String status, String msg, T data) {
		 this.status = status;		 
		 this.msg = msg;
		 this.data = data;
	 }
}
