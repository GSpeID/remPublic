package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.service.ManagementService;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Controller
public class ManagementController {

    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    //--- для повторного использования в качестве метода, вместо дублирования кода
    static void globalModelsList(Model model, ManagementService managementService) {
        List<ClientDTO> clients = managementService.findAllClients();
        model.addAttribute("clients", clients);
        List<DeviceDTO> devices = managementService.findAllDevices();
        model.addAttribute("devices", devices);
        List<ClientTypeDTO> clientTypes = managementService.findAllClientTypes();
        model.addAttribute("clientTypes", clientTypes);
        List<RepairTypeDTO> repairTypes = managementService.findAllRepairTypes();
        model.addAttribute("repairTypes", repairTypes);
        List<RepairStatusDTO> repairStatuses = managementService.findAllRepairStatuses();
        model.addAttribute("repairStatuses", repairStatuses);
    }

    //---возыращения моделей для страницы с валидацией
    private String modelsList(Model model) {
        globalModelsList(model, managementService);
        return "management";
    }

    @GetMapping("/management")
    public String allManagementPage(Model model) {
        model.addAttribute("clientDTO", new ClientDTO());
        model.addAttribute("deviceDTO", new DeviceDTO());
        model.addAttribute("clientTypeDTO", new ClientTypeDTO());
        model.addAttribute("repairTypeDTO", new RepairTypeDTO());
        model.addAttribute("repairStatusDTO", new RepairStatusDTO());
        return modelsList(model);
    }

    @PostMapping("/management/upload")
    public String fileUpload(@RequestParam MultipartFile file, @RequestParam String clientDir,
                             RedirectAttributes redirectAttributes, ModelMap modelMap) {
        String fileName = file.getOriginalFilename();

        modelMap.addAttribute("clientDir", clientDir.toLowerCase());
        String uploadUrl = "/home/x3m/Downloads/rem/clientFiles/" + clientDir + "/" + fileName;
        try {
            file.transferTo(new File(uploadUrl));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Не удвлось загрузить файл " +
                    file.getOriginalFilename());
        }
        redirectAttributes.addFlashAttribute("message", "Файл " + file.getOriginalFilename() + " успешно загружен");
        return "redirect:/management";
    }

    //----- Save\Delete Client

    @PostMapping("/management/create-client")
    public String createClient(@ModelAttribute("clientDTO") @Valid ClientDTO clientDTO,
                               BindingResult result, Model model,
                               @ModelAttribute("deviceDTO") DeviceDTO deviceDTO,
                               @ModelAttribute("clientTypeDTO") ClientTypeDTO clientTypeDTO,
                               @ModelAttribute("repairTypeDTO") RepairTypeDTO repairTypeDTO,
                               @ModelAttribute("repairStatusDTO") RepairStatusDTO repairStatusDTO) {
        if (result.hasErrors()) {//ToDo проврека на ifExist
            return modelsList(model);
        }
        managementService.saveClient(clientDTO);
        return "redirect:/management";
    }

    @GetMapping("/management/delete-client/{clientId}")
    public String deleteClient(@PathVariable Long clientId) {
        managementService.deleteClient(clientId);
        return "redirect:/repair-service/management";
    }

    //----- Save\Delete Client Type


    @PostMapping("/management/create-client-type")
    public String createClientType(@ModelAttribute("clientTypeDTO") @Valid  ClientTypeDTO clientTypeDTO,
                                   BindingResult result,Model model,
                                   @ModelAttribute("clientDTO") ClientDTO clientDTO,
                                   @ModelAttribute("deviceDTO")  DeviceDTO deviceDTO,
                                   @ModelAttribute("repairTypeDTO")  RepairTypeDTO repairTypeDTO,
                                   @ModelAttribute("repairStatusDTO")  RepairStatusDTO repairStatusDTO) {
        if (result.hasErrors()) {//ToDo проврека на ifExist
            return modelsList(model);
        }
        managementService.saveClientType(clientTypeDTO);
        return "redirect:/management";
    }

    @GetMapping("/management/delete-client-type/{clientTypeId}")
    public String deleteClientType(@PathVariable Long clientTypeId) {
        managementService.deleteClientType(clientTypeId);
        return "redirect:/management";
    }

    //----- Save\Delete Device

    @PostMapping("/management/create-device")
    public String createDevice(@ModelAttribute("deviceDTO") @Valid  DeviceDTO deviceDTO,
                               BindingResult result, Model model,
                               @ModelAttribute("clientDTO") ClientDTO clientDTO,
                               @ModelAttribute("clientTypeDTO")  ClientTypeDTO clientTypeDTO,
                               @ModelAttribute("repairTypeDTO")  RepairTypeDTO repairTypeDTO,
                               @ModelAttribute("repairStatusDTO")  RepairStatusDTO repairStatusDTO) {
        if (result.hasErrors()) {//ToDo проврека на ifExist
            return modelsList(model);
        }
        managementService.saveDevice(deviceDTO);
        return "redirect:/management";
    }

    @GetMapping("/management/delete-device/{deviceId}")
    public String deleteDevice(@PathVariable Long deviceId) {
        managementService.deleteDevice(deviceId);
        return "redirect:/management";
    }

    //----- Save\Delete Repair Type

    @PostMapping("/management/create-repair-type")
    public String createRepairType(@ModelAttribute("repairTypeDTO") @Valid  RepairTypeDTO repairTypeDTO,
                                   BindingResult result, Model model,
                                   @ModelAttribute("clientDTO") ClientDTO clientDTO,
                                   @ModelAttribute("deviceDTO")  DeviceDTO deviceDTO,
                                   @ModelAttribute("clientTypeDTO")  ClientTypeDTO clientTypeDTO,
                                   @ModelAttribute("repairStatusDTO")  RepairStatusDTO repairStatusDTO) {
        if (result.hasErrors()) {//ToDo проврека на ifExist
            return modelsList(model);
        }
        managementService.saveRepairType(repairTypeDTO);
        return "redirect:/management";
    }

    @GetMapping("/management/delete-repair-type/{repairTypeId}")
    public String deleteRepairType(@PathVariable Long repairTypeId) {
        managementService.deleteRepairType(repairTypeId);
        return "redirect:/management";
    }

    //----- Save\Delete Statuses

    @PostMapping("/management/create-status")
    public String createStatus(@ModelAttribute("repairStatusDTO") @Valid RepairStatusDTO repairStatusDTO,
                               BindingResult result, Model model,
                               @ModelAttribute("clientDTO") ClientDTO clientDTO,
                               @ModelAttribute("deviceDTO")  DeviceDTO deviceDTO,
                               @ModelAttribute("clientTypeDTO") ClientTypeDTO clientTypeDTO,
                               @ModelAttribute("repairTypeDTO") RepairTypeDTO repairTypeDTO
                               ) {
        if (result.hasErrors()) {//ToDo проврека на ifExist
            return modelsList(model);
        }
        managementService.saveStatus(repairStatusDTO);
        return "redirect:/management";
    }

    @GetMapping("/management/delete-status/{statusId}")
    public String deleteStatus(@PathVariable Long statusId){
        managementService.deleteStatus(statusId);
        return "redirect:/management";
    }

}
