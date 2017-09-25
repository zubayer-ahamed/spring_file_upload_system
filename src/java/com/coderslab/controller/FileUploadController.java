package com.coderslab.controller;

import com.coderslab.util.FileUploadHelper;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uploadPath = "\\web\\resources\\upload";

        FileUploadHelper fileUploadHelper = new FileUploadHelper();
        boolean status = fileUploadHelper.doUpload(uploadPath, request, response);
        if (status) {
            modelMap.addAttribute("sm", "File Upload successfull");
        } else {
            modelMap.addAttribute("em", "File not upload");
        }
        return "success";
    }

}
