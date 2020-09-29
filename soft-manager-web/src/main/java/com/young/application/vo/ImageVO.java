package com.young.application.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Data
public class ImageVO {

    private Long id;
    private String imageName;
    private String fileName;
    private String fileUrl;
    private String remark;

    private MultipartFile file;

}
