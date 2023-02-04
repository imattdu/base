package com.matt.project.base;

import com.matt.project.base.util.IpUtil;

import java.util.UUID;

public class A {

    public static void main(String[] args) {
        System.out.println(IpUtil.getLocalIpByNetCard());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
    }
}
