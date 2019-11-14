
package cn.com.webxml;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a> <strong>2400多个城市天气预报Web服务</strong>，包含2300个以上中国城市和100个以上国外城市天气预报数据。数据每2.5小时左右自动更新一次，准确可靠。<br />使用本站 WEB 服务请注明或链接本站：<a href="http://www.webxml.com.cn/" target="_blank">http://www.webxml.com.cn/</a> 感谢大家的支持！<br /><br /><img alt="PDF" title="PDF file" src="http://www.webxml.com.cn/images/icon/pdf.gif" style="vertical-align: middle;" /> <a href="http://www.webxml.com.cn/files/WeatherWsHelp.pdf" target="_blank">接口帮助文档</a> &nbsp;&nbsp;&nbsp; <img alt="ZIP" title="ZIP file" src="http://www.webxml.com.cn/images/icon/zip.gif" style="vertical-align: middle;" /> <a href="http://www.webxml.com.cn/files/about_city.zip">部分城市介绍和气候背景</a> &nbsp;&nbsp;&nbsp; <img alt="ZIP" title="ZIP file" src="http://www.webxml.com.cn/images/icon/zip.gif" style="vertical-align: middle;" /> <a href="http://www.webxml.com.cn/files/city_photo.zip">部分城市图片</a> &nbsp;&nbsp;&nbsp; <img alt="HTML" title="HTML file" src="http://www.webxml.com.cn/images/icon/html.gif" style="vertical-align: middle;" /> <a href="http://www.webxml.com.cn/zh_cn/weather_icon.aspx" target="_blank">天气现象和图例</a><br />&nbsp;
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WeatherWS", targetNamespace = "http://WebXml.com.cn/", wsdlLocation = "file:/D:/\u5de5\u7a0b/\u7535\u5546/Shop-WebService/src/main/resources/weather.wsdl")
public class WeatherWS
    extends Service
{

    private final static URL WEATHERWS_WSDL_LOCATION;
    private final static WebServiceException WEATHERWS_EXCEPTION;
    private final static QName WEATHERWS_QNAME = new QName("http://WebXml.com.cn/", "WeatherWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/\u5de5\u7a0b/\u7535\u5546/Shop-WebService/src/main/resources/weather.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEATHERWS_WSDL_LOCATION = url;
        WEATHERWS_EXCEPTION = e;
    }

    public WeatherWS() {
        super(__getWsdlLocation(), WEATHERWS_QNAME);
    }

    public WeatherWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEATHERWS_QNAME, features);
    }

    public WeatherWS(URL wsdlLocation) {
        super(wsdlLocation, WEATHERWS_QNAME);
    }

    public WeatherWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEATHERWS_QNAME, features);
    }

    public WeatherWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WeatherWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WeatherWSSoap
     */
    @WebEndpoint(name = "WeatherWSSoap")
    public WeatherWSSoap getWeatherWSSoap() {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWSSoap"), WeatherWSSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWSSoap
     */
    @WebEndpoint(name = "WeatherWSSoap")
    public WeatherWSSoap getWeatherWSSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebXml.com.cn/", "WeatherWSSoap"), WeatherWSSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEATHERWS_EXCEPTION!= null) {
            throw WEATHERWS_EXCEPTION;
        }
        return WEATHERWS_WSDL_LOCATION;
    }

}
