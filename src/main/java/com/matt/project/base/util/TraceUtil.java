package com.matt.project.base.util;

import com.matt.project.base.bo.TraceMessage;
import com.sun.management.jmx.Trace;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class TraceUtil {

    public static TraceMessage getTraceMessage(HttpServletRequest req) {
        Object traceMessageObj = req.getAttribute("TRACE_MESSAGE");
        if (traceMessageObj == null) {
            traceMessageObj = newTraceMessage(req);
        }
        return (TraceMessage) traceMessageObj;
    }

    public static String genUUID() {
        String uuid = UUID.randomUUID().toString();
        String nowStr = String.valueOf(System.currentTimeMillis() / 1000);
        return nowStr.concat(uuid.substring(uuid.length() - 10));
    }

    public static TraceMessage newTraceMessage(HttpServletRequest req) {
        String traceId = "";
        if (req.getHeader("traceid") != null) {
            traceId = req.getHeader("traceid");
        } else {
            traceId = genUUID();
        }
        return new TraceMessage(traceId);
    }
}
