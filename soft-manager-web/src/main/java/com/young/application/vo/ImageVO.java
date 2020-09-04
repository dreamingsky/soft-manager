package com.young.application.vo;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public class ImageVO {

    private Long id;
    private String imageName;
    private String fileName;
    private String fileUrl;
    private String remark;

    private MultipartFile file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
