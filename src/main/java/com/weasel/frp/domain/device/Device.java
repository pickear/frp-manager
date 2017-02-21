package com.weasel.frp.domain.device;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Dylan
 * @date 2017/1/22.
 */
public class Device {

    /**
     * 所属用户
     */
    private String username;

    /**
     * 设备编码
     */
    private String number;

    /**
     * 类型
     */
    private DeviceType deviceType;
    /**
     * 协议类型
     */
    protected ProtocolType protocolType;
    /**
     * 密码
     */
    protected String authToken;
    /**
     * 绑定的地址
     */
    protected String bindAddr;
    /**
     * 监听的端口
     */
    protected String listenPort;

    private String customDomains;

    public Device() {
    }

    public Device( DeviceType deviceType,ProtocolType protocolType) {
        this.protocolType = protocolType;
        this.deviceType = deviceType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public ProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolTypeType(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getBindAddr() {
        return bindAddr;
    }

    public void setBindAddr(String bindAddr) {
        this.bindAddr = bindAddr;
    }

    public String getListenPort() {
        return listenPort;
    }

    public void setListenPort(String listenPort) {
        this.listenPort = listenPort;
    }

    public String getCustomDomains() {
        return customDomains;
    }

    public void setCustomDomains(String customDomains) {
        this.customDomains = customDomains;
    }

    public String name(){
        return StringUtils.lowerCase(this.getClass().getSimpleName());
    }

    public static Device ssh(){
        return new Device(DeviceType.SSH,ProtocolType.TCP);
    }

    public static Device dns(){
        return new Device(DeviceType.DNS,ProtocolType.UDP);
    }

    public static Device http(){
        return new Device(DeviceType.WEB,ProtocolType.HTTP);
    }
    public static Device https(){
        return new Device(DeviceType.WEB,ProtocolType.HTTPS);
    }

    public static enum DeviceType{
        SSH("ssh"),DNS("dns"),WEB("web");
        private String value;

        DeviceType() {
        }

        DeviceType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static enum ProtocolType {
        TCP("tcp"),UDP("udp"),HTTP("http"),HTTPS("https");
        private String value;

        ProtocolType() {
        }

        ProtocolType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
