package com.matt.project.base.vo;

import com.matt.project.base.bo.TraceMessage;
import lombok.*;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommonVO {
    private String traceId;
    private Integer code;
    private String msg;
    private Object data;


    public static CommonVO suc(HttpServletRequest req, Object data) {
        TraceMessage traceMessage = (TraceMessage)req.getAttribute("TRACE_MESSAGE");
        return new CommonVO(traceMessage.getTraceId(),0, "", data);
    }

    public static CommonVO fail(HttpServletRequest req,Object data) {
        TraceMessage traceMessage = (TraceMessage)req.getAttribute("TRACE_MESSAGE");
        return new CommonVO(traceMessage.getTraceId(),1, "", data);
    }


}
