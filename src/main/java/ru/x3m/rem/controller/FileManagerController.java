package ru.x3m.rem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.x3m.rem.utils.FormTodoc.FieldDTO;
import ru.x3m.rem.utils.FormTodoc.SetFieldsDTO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileManagerController {

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

    @GetMapping("/doc/")
    public String docPage(Model model) {
        model.addAttribute("fieldDTO", new FieldDTO());
        SetFieldsDTO setFieldsDTO = new SetFieldsDTO();
        List<FieldDTO> listFields = new ArrayList<FieldDTO>(20);
        FieldDTO fieldDTO = new FieldDTO();
//        if (quantity==0){
//            quantity=1;
//        }
//        for (int i = 0; i < quantity; i++) {
//            listFields.add(fieldDTO);
//        }
        setFieldsDTO.setFieldDTOList(listFields);
        model.addAttribute("setFieldsDTO", setFieldsDTO);
        return "docPage";
    }

    @PostMapping("/toDoc")
    public void createDevice(@ModelAttribute("listDTO") SetFieldsDTO setFieldsDTO) {

        System.out.println("tsss");
    }


}
