package dinhgt.springboot.sbtrainingusers.errors;

public class ErrorResponse {

	private int http_code;
	private String message;
	private long timestamp;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	public ErrorResponse(int http_code, String message, long timestamp) {
		super();
		this.http_code = http_code;
		this.message = message;
		this.timestamp = timestamp;
	}
	public int getHttp_code() {
		return http_code;
	}
	public void setHttp_code(int http_code) {
		this.http_code = http_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
}
