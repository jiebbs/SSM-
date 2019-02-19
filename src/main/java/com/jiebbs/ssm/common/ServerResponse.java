package com.jiebbs.ssm.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 通用响应对象
 * @author weijie
 * @version
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {
	
	private int status;
	private String message;
	private T data;
	
	//私有化全部构造器，以此使用静态方法来获取可以命名的构造器
	private ServerResponse(int status) {
		this.status = status;
	}
	
	private ServerResponse(int status, T data) {
		this.status = status;
		this.data = data;
	}

	private ServerResponse(int status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	private ServerResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	@JsonIgnore
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}
	
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	
	//响应成功
	public static <T> ServerResponse<T> createBySuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}
	
	public static <T> ServerResponse<T> createBySuccessMessage(String msg){
		return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg);
	}
	
	public static <T> ServerResponse<T> createBySuccess(T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
	}
	
	public static <T> ServerResponse<T> createBySuccess(String msg,T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
	}
	//响应出现错误
	public static <T> ServerResponse<T> createByError(){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
	}
	public static <T> ServerResponse<T> createByErrorMessage(String errorMsg){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMsg);
	}
	public static <T> ServerResponse<T> createByErrorCodeMessage(String errorMsg,int errorCode){
		return new ServerResponse<T>(errorCode,errorMsg);
	}
	
}
