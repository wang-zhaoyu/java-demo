package cn.mobilemart.demo.web.common;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* @Description: 字符处理工具类
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:47
*/
public final class StringUtils {

    /**
     * 判断对象或字符串是否为空
     * 
     * @param obj
     * @return
     */
    public static boolean isBlank(Object obj) {
        boolean flag = false;
        if (null == obj || "".equals(obj.toString().trim())) {
            flag = true;
        }
        return flag;
    }

    public static <T extends Number> List<T> split(String str,String sp) throws ParseException {
        List<T> list = new ArrayList<T>();
        String[] arr =   str.split(sp);
        for(String e : arr){
            list.add((T) NumberFormat.getInstance().parse(e));
        }
        return list;
    }

    public static <T> String concat(List<T> list,String sp){
        StringBuilder sb = new StringBuilder();
        for(T e:list){
           sb.append(e.toString()+sp);
        }
        return sb.deleteCharAt(sb.length()-1).toString();

    }


    public static boolean isNotBlank(Object obj) {
        return !isBlank(obj);
    }

    // ======================获取字符串==========================

    /**
     * 获取随机的32位UUID字符串：(已将其中的"-"替换掉)
     * <p>
     * 另：还可使用RandomGUID <br>
     * 地址：http://www.javaexchange.com/aboutRandomGUID.html
     * 
     * @return
     */
    public static String getRandomUUIDStr() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 随机获取指定长度的字符串(仅由数字组成)：
     * 
     * @param length 获取的长度
     * @return 长度小于或等于0时，则返回""
     */
    public static String getRandomStr4Number(Integer length) {
        if (length <= 0) {
            return "";
        }

        String str = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    /**
     * 随机获取指定长度的字符串(由数字与字母组成)：
     * <p>
     * 另：如果导入commons-lang.jar包，可用此类： <br>
     * RandomStringUtils.randomAlphanumeric(length)
     * 
     * @param length 获取的长度
     * @return 长度小于或等于0时，则返回""
     */
    public static String getRandomStr(Integer length) {
        if (length <= 0) {
            return "";
        }

        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

    /**
     * 得到一个日期加随机数的字符串
     * 
     * @param length 随机数的个数，如不加随机数，则用0代替
     * @return 如果length=8，返回形式为：20110318103647015PVje2TJO
     */
    public static String getDateAndRandStr(Integer length) {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + getRandomStr(length);
    }

    // -------------------------------------------------------------------------
    // 其它：
    // 1、重复输出多个字符
    // 2、对于指定属性的第一个字母大写
    // 3、去掉字符串的最后一个字符
    // 4、截取指定长度字符
    // 5、字符编码
    // 6、将字符串转为输入流
    // -------------------------------------------------------------------------

    /**
     * 重复输出多个字符 <br>
     * (说明：此方法直接拷贝于"org.apache.commons.lang.StringUtils")
     * 
     * <pre>
     * StringUtils.padding(0, 'e')  = ""
     * StringUtils.padding(3, 'e')  = "eee"
     * StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
     * </pre>
     */
    public static String padding(Integer repeat, char padChar) throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }



    /**
     * 去掉字符串的最后一个字符(常用于去掉最后一个分号(;))
     * 
     * @param str 目标字符串
     * @return 如果为null，或长度为0，则返回本身
     */
    public static String removeLastChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        return str.substring(0, str.length() - 1);
    }

    
    /**
     * 反转义&midddot中点
     * 
     * @param str
     * @return
     */
    public static String middotUnescape(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("&middot;", "·");
    }

    /**
     * 把中文转成Unicode码
     * 
     * @param str
     * @return
     */
    public static String chinaToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

}
