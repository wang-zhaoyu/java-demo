package cn.mobilemart.demo.api.common;
/**
* @Description: 全局变量定义
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:40
*/
public class Constant {

	public static final String SPLIT = "|";

	//Redis key定义
	public static final Integer REDIS_DB_IDX = 0;
	public static final String REDIS_KEY_MOBILE = "mobile";
	public static final String REDIS_KEY_ACCESS_TOKEN = "access_token";
	public static final String REDIS_KEY_JSAPI_TICKET = "jsapi_ticket";
	public static final String REDIS_KEY_WX_USERINFO = "wx_userinfo";
    public static final String REDIS_KEY_USER_TOKEN = "user_token";
    public static final String REDIS_KEY_MOBILE_SHORT_MSG ="redis_key_mobile_short_msg";
    public static final String REDIS_KEY_OPENDID = "REDIS_KEY_OPENDID";
    public static final String REDIS_KEY_STATIONS_IDS = "REDIS_KEY_STATIONS_IDS";
    public static final String REDIS_KEY_LOGIN_TOKEN = "REDIS_KEY_LOGIN_TOKEN";


    //md5加密盐
	public static final String TOKEN_MD5_SALT = "MD5_KEY_OPENID_SALT";

    /**
     * 短信模板内容  1 注册
     */
    public static final int SMS_REGIST_CONTENT = 1;

	//Redis key默认超时时间，单位秒
	public static final Long REDIS_KEY_EXPIRE = 86400L;//24小时

	//微信token缓存时间
	public static final Long REDIS_ACCESS_TOKEN_EXPIRE = 7000L;
	public static final Long REDIS_JSAPI_TICKET_EXPIRE = 7000L;

	//微信access token错误
	public static final String ACCESS_TOKEN_INVALID = "access_token_invalid";
	public static final Integer ACCESS_TOKEN_ERR = 40001;

	public static final Long REDIS_SEND_MSGSHORT_EXPIRE = 60L;
	public static final Long REDIS_MSGSHORT_EXPIRE = 1800L;

	//token生效时间，2小时
	public static final Long REDIS_LOGIN_TOKEN_EXPIRE = 7200L;

	public static final String MSGSHORT_CONTENT = "（操作验证码，请完成验证），如非本人操作，请忽略本短信。【魔急便】";
}
