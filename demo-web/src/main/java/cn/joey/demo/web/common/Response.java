package cn.joey.demo.web.common;

import lombok.Data;

/**
 * @author wangzhaoyu
 * @date 2017-12-22
 */
@Data
public class Response<T> {
    private Integer error_code;
    private String err_msg;
    private T data;


    public Response() {
    }

    public Response(Integer error_code, String err_msg, T data) {
        this.error_code = error_code;
        this.err_msg = err_msg;
        this.data = data;
    }

    public Response(Integer error_code, String err_msg) {
        this.error_code = error_code;
        this.err_msg = err_msg;
    }

    public Response(T data) {
        this.data = data;
    }

    public Response setByCodeAndMsg(Integer code, String errMsg) {
        this.error_code = code;
        this.err_msg = errMsg;
        return this;
    }

    public Response setByCodeAndMsg(Integer code, String errMsg, T data) {
        this.error_code = code;
        this.err_msg = errMsg;
        this.data = data;
        return this;
    }


    /**
     * @param errorCode  错误编码
     * @param errorMsg  错误信息
     * @return 返回响应对象
     */
    public static <E> Response<E> errorResponse(Integer errorCode,String errorMsg){
        Response<E> result = new Response<>();
        result.setError_code(errorCode);
        result.setErr_msg(errorMsg);
        return result;
    }

    /**
     * @param errorMsg  错误信息
     * @return 返回响应对象
     */
    public static <E> Response<E> errorResponseMsg(String errorMsg){
        Response<E> result = new Response<>();
        result.setError_code(ErrorCode.FAIL.code);
        result.setErr_msg(errorMsg);
        return result;
    }

    /**
     * @return 返回响应对象
     */
    public static <E> Response<E> successResponse(){
        Response<E> result = new Response<>();
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(ErrorCode.SUCCESS.message);
        return result;
    }

    /**
     * @return 返回响应对象
     */
    public static <E> Response<E> successResponseWithMsg(String message){
        Response<E> result = new Response<>();
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(message);
        return result;
    }



    /**
     * @return 返回响应对象
     */
    public static <E> Response<E> successResponse(E data){
        Response<E> result = new Response<>();
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(ErrorCode.SUCCESS.message);
        result.setData(data);
        return result;
    }

    /**
    * @Description: 判断响应是否为成功响应
    * @Author: wangzhaoyu
    * @Date: 2019/1/25 上午10:31
    */
    public static boolean isSuccessResponse(Response response){
        if(response == null){
            return false;
        }
        Integer error_code = response.getError_code();
        if(error_code == null || error_code.compareTo(ErrorCode.SUCCESS.code) != 0){
            return false;
        }
        return true;
    }
}
