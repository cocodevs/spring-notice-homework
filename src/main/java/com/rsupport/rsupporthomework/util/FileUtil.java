package com.rsupport.rsupporthomework.util;

import com.rsupport.rsupporthomework.domain.Post;
import com.rsupport.rsupporthomework.domain.PostFile;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FileUtil {
    public List<PostFile> parseFileInfo(Post post, List<MultipartFile> multipartFiles) throws Exception {
        List<PostFile> fileList = new ArrayList<>();
        if (multipartFiles.isEmpty()) {
            return fileList;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        if (multipartFiles.isEmpty()) {
            return fileList;
        }
        String absolutePath = new File("").getAbsolutePath() + "/";

        String path = "src/main/resources/static/upload/" + current_date;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                String contentType = multipartFile.getContentType();
                String originalFileExtension;
                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                } else {
                    if (contentType.contains("image/jpeg")) {
                        originalFileExtension = ".jpg";
                    } else if (contentType.contains("image/png")) {
                        originalFileExtension = ".png";
                    } else if (contentType.contains("image/gif")) {
                        originalFileExtension = ".gif";
                    }
                    else {
                        break;
                    }
                }
                String new_file_name = Long.toString(System.nanoTime()) + originalFileExtension;

                PostFile postFile = new PostFile();
                postFile.setOriginalFileName(multipartFile.getOriginalFilename());
                postFile.setFilePath("/upload/" + current_date + "/" + new_file_name);
                postFile.setFileSize(multipartFile.getSize());
                postFile.setPost(post);

                fileList.add(postFile);

                file = new File(absolutePath + path + "/" + new_file_name);
                multipartFile.transferTo(file);
            }
        }
        return fileList;
    }
}