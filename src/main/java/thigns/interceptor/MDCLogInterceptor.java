package thigns.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
@Component
public class MDCLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestId = UUID.randomUUID().toString();
        String requestUrl = request.getRequestURI();
        String userAgent = request.getHeader("User-Agent");
        String clientIP = getClientIP(request);

        MDC.put("requestId", requestId);
        MDC.put("requestUrl", requestUrl);
        MDC.put("userAgent", userAgent);
        MDC.put("clientIP", clientIP);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
    }

    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.hasLength(ip)) {
            // X-Forwarded-For 헤더가 존재하면 첫 번째 IP만 가져옵니다.
            ip = ip.split(",")[0].strip();
        } else {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
