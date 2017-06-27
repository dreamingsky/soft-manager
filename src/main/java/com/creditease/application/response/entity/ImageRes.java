package com.creditease.application.response.entity;

import com.creditease.application.annotation.FieldAnno;

/**
 * Created by huiyangchen1 on 2017/6/27.
 */
public class ImageRes {

    @FieldAnno(name = "imageName")
    private String imageName;
    @FieldAnno(name = "fileName")
    private String fileName;
    @FieldAnno(name = "fileUrl")
    private String fileUrl;
    @FieldAnno(name = "remark")
    private String remark;


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
