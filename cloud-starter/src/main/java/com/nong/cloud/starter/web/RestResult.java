package com.nong.cloud.starter.web;

/**
 * 通用返回结果，泛型可提供各种数据结果的返回，
 *
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
public class RestResult<T> {

  /** 默认请求成功code为200 */
  public static final int REQUEST_SUCCESS_CODE = 200;
  /** 默认请求成功错误信息为：请求成功 */
  public static final String REQUEST_SUCCESS_MESSAGE = "请求成功";

  /** 响应错误码 */
  private int code;

  /** 响应错误信息 */
  private String message;

  /** 响应数据，此处使用泛型，可通用 */
  private T data;

  public RestResult(T data) {
    this(REQUEST_SUCCESS_CODE, REQUEST_SUCCESS_MESSAGE, data);
  }

  /**
   * 不含返回数据的构造器，可提供给请求出现错误时，或不需要返回响应数据的请求使用呢
   *
   * @param code 错误编码
   * @param message 错误消息
   */
  public RestResult(int code, String message) {
    this(code, message, null);
  }

  public RestResult(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 请求成功，无响应数据
   *
   * @return RestResult<T>
   */
  public static <T> RestResult<T> success() {
    return new RestResult<T>(null);
  }

  /**
   * 请求成功，返回响应数据
   *
   * @param data 响应数据
   * @return RestResult<T>
   */
  public static <T> RestResult<T> success(T data) {
    return new RestResult<T>(data);
  }

  /**
   * 请求出现错误的情况，无需返回响应结果，直接返回错误码和错误信息
   *
   * @param code 错误码
   * @param message 错误信息
   * @return RestResult<T>
   */
  public static RestResult fail(int code, String message) {
    return new RestResult(code, message);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
