package com.ciq.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    public static final String SUCCESS_RESPONSE_DEFAULT = "1000";
	public static final String FAILURE_RESPONSE_DEFAULT = "1001";

    private String responseCode;
	private String responseMessage;

    public BaseResponse()
	{

	}

	public BaseResponse(String code)
	{
		this.responseCode = code;
	}

	public String getResponseCode()
	{
		return responseCode;
	}

	public void setResponseCode(String responseCode)
	{
		this.responseCode = responseCode;
	}

	public String getResponseMessage()
	{
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage)
	{
		this.responseMessage = responseMessage;
	}
}
