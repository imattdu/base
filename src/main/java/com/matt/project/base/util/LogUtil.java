package com.matt.project.base.util;

import com.matt.project.base.bo.TraceMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LogUtil {

    public static String genMsg(HttpServletRequest req, String lTag, String msg) {
        StringBuilder sb = new StringBuilder(1024);
        TraceMessage traceMessage = TraceUtil.getTraceMessage(req);
        sb.append(lTag);
        sb.append("||traceId=".concat(traceMessage.getTraceId()));
        sb.append("||spanId=".concat(UUID.randomUUID().toString()));
        sb.append("||_msg=".concat(msg));
        return String.valueOf(sb);
    }

    public static String genMsg(HttpServletRequest req, String lTag, Map<String, Object> msg) {
        StringBuilder sb = new StringBuilder(1024);
        TraceMessage traceMessage = TraceUtil.getTraceMessage(req);
        sb.append(lTag);
        sb.append("||traceId=".concat(traceMessage.getTraceId()));
        sb.append("||spanId=".concat(UUID.randomUUID().toString()));

        for (Map.Entry<String, Object> e: msg.entrySet()) {
            sb.append("||".concat(e.getKey()).concat("=").concat(e.getValue().toString()));
        }
        return String.valueOf(sb);
    }

}
