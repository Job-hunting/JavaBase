package com.louis.tools.mail.data;//package com.louis.tools.mail.data;
//
//import java.io.InputStream;
//
///**
// * @author duansaisai
// * @date 2020-09-25 10:01
// * 附件需要的参数
// */
//public class AttachMeta {
//
//    /**
//     * 媒体格式，见https://www.runoob.com/http/http-content-type.html
//     * */
//    private String contentType;
//    /**
//     * 文件输入流
//     * */
//    private InputStream inputStream;
//
//    /**
//     * 附件的文件名称
//     * */
//    private String name;
//
//    /**
//     * 图片cid，用来在邮件中嵌入图片，与inputStream一起使用
//     * */
//    private String cid;
//
//    public AttachMeta(String contentType, InputStream inputStream, String name, String cid) {
//        this.contentType = contentType;
//        this.inputStream = inputStream;
//        this.name = name;
//        this.cid = cid;
//    }
//
//    public String getContentType() {
//        return contentType;
//    }
//
//    public void setContentType(String contentType) {
//        this.contentType = contentType;
//    }
//
//    public InputStream getInputStream() {
//        return inputStream;
//    }
//
//    public void setInputStream(InputStream inputStream) {
//        this.inputStream = inputStream;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCid() {
//        return cid;
//    }
//
//    public void setCid(String cid) {
//        this.cid = cid;
//    }
//}
