package com.matt.project.base.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class TraceMessage {

    private String traceId;



}
