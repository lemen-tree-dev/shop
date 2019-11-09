package com.shop.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author 杨小柒丶
 * @Date 2019/10/10
 * @Time 23:01
 */
@Configuration
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id =
            "2016101200671591";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCjF46fwTT5XlkwQCBP7iXivVHp75kWmbDUTgEU/SlwgCPYvdV4oVPisJ9PwEotDnLY6e9BHRp7z8E3qdukQDdOUqg2WVontyqsphnYxNj3lgTX1UD0MafOhzRBpsrU2NKEuS4i54DfkWMRIkM73e6yq1P6jNyEJ/ZGQ5gRnkt1OF+7vSaOdC57cYuqYuvwSjZKHxTBf1ZkzR8WB54olaIBPGLGrP8pGx/kwQQR0s8sNnsSyLDuxAhyUXhvkx9k+O511HKbStaJHI1e8ib+e/5+QBxDAxtrAhgAgqL6lsJ+pJnvkxTNoPUwHG9K2PtfdladM1lXQermIKGg6Bjymo/TAgMBAAECggEAZUWAe7TmZx5t9WcsaVWw0s3KaqAsCHug8QQK6fSV4dS/7ZtbTg+nXjFci5IUvUumhwkkVuNyiYUlLqJbz+9MKGdtKmprcBPt/M0baZ46N+tA0KEMN1YKJFWSXl3qvyZv+phejLACN1E5Ge+Tnj4eNXXrrL4BRFLoOxNH/1Cy/HLqQoQS4EDjS1BhIsiy3U7L2L1JIu4KSz0brqEK11Ze2mb76F3xGIB2nJqJl4m9wGcgf7wBxwpn8erOEcpQc0N1WzctZm38D2WJux/ioIU5ujvOgn7VYcjpUgXNQz/g9ByKAUg5epJZzG1gJU70W0vyBlrrUGim6dDAN3riTnhVSQKBgQDNxftIVl4w2LCzGyPHp6/wO6TTuPAcaQUDrdy9oHdMj0fO6cNTkula8mXnOvhNsOcMzUJvML48rcw7+a8WaO0J5uN5dWjUdsUOZFuWu03mqAsejMEex5CgkOBg4PM/yS2396ynyxAF+1e8jFm4ym4ipmxTD3/7A3ihvVjdA4HZBwKBgQDK5pNj0AbSCJ1GhreuFm4eRu+NGwJNBHXWeZ6fe8ZZ0Y/8w7G+N4qBVXcF9AcXqjiFSKkKiOi7p7eHyBbDBAlFoDsn09MVXn5DyRbLcVkyB0CRS8+I34R+yLWYEYqscpwqu+d9jkvVxJdtPxjkxg9ScMX4QzdE5rdCtqsfQ9jb1QKBgQCF6AiWEl5JOzoB0+98xcrgcm/Yt8jJNC5nLoUvgXUhBTydkdHiWQAyhvt5dg6PwEcbNZe98+JYamE1xk4CL1XR08bEC3ukh4XEz9oqRMl1CHXz83TZKtUbKCxb3wdswuZViX950dMjkWSO9maMsm7pbZOgmb2XA7NEzYs+iEG/kQKBgCs6ow5yBPH86d1b2IibuMx0mpc6uOvF1oFimhwql+ENGBtnalg3pyfVGK3JBzXQi4hCKdnXv5YzrpOcWtUj6AHQmKnspJ1563bvwg6IUNOq3ePW/hmQXb9Rbfc/TYdeR82HCVQj3B5oa0bYWapsVFlhM5yoXX8tlL//AUiBARQdAoGBAJ/gh1KXcCBc98RRh34UT6Urd12CIPkBEYjJRyzMJnIK7G6xKxMOHUVNeZPRg3c5knqsW606cEN7jPfVP7tT78TCRJHY6w0pcZOWbHOJgq1AnT46vLn1IZ7G9zSRPLrcMGjwIMXurCL2ASRN0oobGGiCpEOtF0vLrqNei/nimBqU";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzl0FWh+wHh4SFXOHVVHA7Mmf97Js+5/tCxURXqoAs9CkWvp0vHFO6j0u10gnsqbtDtRVfyoJvEE1yJYhPWaaZzkU+EgHA83p98j0JY7Z9T7+o9rAccuw0IT71CBMUzDUuunIvn4q7IbJHaqK6rDtVhOOJ17/KE53Zq7UcaoyfPEpgpbXvUpxvM8E5h8fgFElzdrBRA+UcpWjXNG+RBqpyuUZwN/LaUg6EynFpJ3unPnRY34MFOZmgwh2dcT19c/rYoq2zOW44UjCzGeW68gGItLS1ZfckAm+zEx/gZANDU15tm1PsPQDAZf0lykWxCDQtqGnhVkdyCjcR8SjQ+gGiQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问，测试修改springboot端口和外网地址
  //  public static String notify_url = "http://localhost:8082/notify_url";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网（通过netapp获取net123或自己购买生成）可以正常访问
    public static String return_url = "http://localhost:8080/#/dingdan";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";
    /** * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）*/
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
