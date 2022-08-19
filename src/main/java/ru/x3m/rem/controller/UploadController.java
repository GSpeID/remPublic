package ru.x3m.rem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

@Controller
public class UploadController {

    @PostMapping("/upload")
    public String fileUpload(@RequestParam MultipartFile file, @RequestParam String clientDir,
                             RedirectAttributes redirectAttributes, ModelMap modelMap) {
        String fileName = file.getOriginalFilename();

        modelMap.addAttribute("clientDir", clientDir.toLowerCase());
        String uploadUrl = "/home/x3m/Downloads/rem/clientFiles/" + clientDir + "/" + fileName;
        try {
            file.transferTo(new File(uploadUrl));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Не удалось загрузить файл " +
                    file.getOriginalFilename());
        }
        redirectAttributes.addFlashAttribute("message", "Файл " + file.getOriginalFilename() + " успешно загружен");
        return "redirect:/management";
    }


}
