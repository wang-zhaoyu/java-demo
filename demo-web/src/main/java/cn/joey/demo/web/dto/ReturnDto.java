package cn.mobilemart.demo.web.dto;

/**
 * 接口返回统一类
 */
public class ReturnDto {
    /**
    返回状态码
     */
    private String retCode;
    /**
     *返回状态说明
     */
    private String retMsg;
    /**
     * 返回数据
     */
    private Object date;

    public ReturnDto() {
    }

    public ReturnDto(String retCode) {
        this.retCode = retCode;
    }

    public ReturnDto(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public ReturnDto(String retCode, String retMsg, Object date) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.date = date;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
