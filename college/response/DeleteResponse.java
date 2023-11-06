package com.scs.college.response;

import org.springframework.http.HttpStatus;

public class DeleteResponse {
		private boolean status;		//true,false
		private String message;   // ""
		private HttpStatus httpStatusCode;
		
		public DeleteResponse() {
			this.status = false;
			this.message = "Record Not Deleted";
			this.httpStatusCode = httpStatusCode.NOT_ACCEPTABLE;
		}
		public DeleteResponse(boolean status, String message, HttpStatus httpStatusCode) {
			this.status = status;
			this.message = message;
			this.httpStatusCode = httpStatusCode;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public HttpStatus getHttpStatusCode() {
			return httpStatusCode;
		}
		public void setHttpStatusCode(HttpStatus httpStatusCode) {
			this.httpStatusCode = httpStatusCode;
		}
		
		
		
		
}
