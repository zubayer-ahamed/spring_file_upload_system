package com.coderslab.controller;

import com.coderslab.util.FileUploadHelper;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws IOException {

        //settings for file upload
        String uploadPath = "\\web\\resources\\upload";
        int scaledWidth = 280;
        int scaledHeight = 180;

        FileUploadHelper fileUploadHelper = new FileUploadHelper();
        Map<String, String> returnedData = fileUploadHelper.doUpload(uploadPath, scaledWidth, scaledHeight, request, response);
        if (returnedData.get("message").equalsIgnoreCase("success")) {
            modelMap.addAttribute("sm", "File Upload successfull");
            modelMap.addAttribute("fileName", returnedData.get("fileName"));
        } else {
            modelMap.addAttribute("em", "File not upload");
        }

        return "success";
    }

}
