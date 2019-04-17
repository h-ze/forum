package com.hz.forum.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by 11022 on 2019/2/19 0019.
 */
public class test {
    public static void main(String[] args) {
        String newPwd = DigestUtils.md5Hex("123456123");
        System.out.println(newPwd);
        Md5Hash md5Hash = new Md5Hash("123456", "123", 1024);
        System.out.println(md5Hash);
    }
}
