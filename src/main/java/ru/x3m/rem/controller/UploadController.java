package ru.x3m.rem.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UploadController {

//    @PostMapping("/upload")
//    public ResponseEntity<?> handleFileUpload (@RequestParam MultipartFile file, @RequestParam String clientDir,
////                                               @RequestParam String fileName,
//                                               RedirectAttributes redirectAttributes, ModelMap modelMap){
//        String fileName = file.getOriginalFilename();
//
//        modelMap.addAttribute("clientDir", clientDir);
//        try{
//            file.transferTo(new File("/home/x3m/Downloads/rem/clientFiles/"+clientDir+"/"+fileName));
//        }catch (Exception e){
//            redirectAttributes.addFlashAttribute("message", "Не удвлось загрузить файл " +
//                    file.getOriginalFilename());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//        redirectAttributes.addFlashAttribute("message", "Файл "+file.getOriginalFilename()+" успешно загружен");
//        return ResponseEntity.ok("Файл "+file.getOriginalFilename()+" успешно загружен");
//    }


}
