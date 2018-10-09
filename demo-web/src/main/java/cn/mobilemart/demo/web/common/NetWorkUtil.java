package cn.mobilemart.demo.web.common;

import javax.servlet.http.HttpServletRequest;

public class NetWorkUtil {
    /***
     * 获取客户端ip
     * @param request
     * @return
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || "null".equalsIgnoreCase(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "null".equalsIgnoreCase(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "null".equalsIgnoreCase(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-real-ip");
        }
        if (StringUtils.isBlank(ip) || "null".equalsIgnoreCase(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") > -1) {
            int ipsLength = ip.split(",").length;
            ip = ip.split(",")[ipsLength - 1].trim();
        }
        return ip;
    }
}
