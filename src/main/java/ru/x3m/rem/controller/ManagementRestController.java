package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.*;
import ru.x3m.rem.service.ManagementService;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/management/api")
public class ManagementRestController {

    private final ManagementService managementService;


    @Autowired
    public ManagementRestController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping("/findAllClients")
    public List<ClientDTO> findAllClients() {
        return managementService.findAllClients();
    }

    @GetMapping(value = "/findClient/{id}")
    public ClientDTO findClient(@PathVariable("id") Long id) {
        return managementService.findClientById(id);
    }

    @GetMapping(value = "/findDevice/{id}")
    public DeviceDTO findDevice(@PathVariable("id") Long id) {
        return managementService.findDeviceById(id);
    }

    @GetMapping(value = "/findRepairType/{id}")
    public RepairTypeDTO findRepairType(@PathVariable("id") Long id) {
        return managementService.findRepairTypeById(id);
    }

    @GetMapping(value = "/findClientType/{id}")
    public ClientTypeDTO findClientType(@PathVariable("id") Long id) {
        return managementService.findClientTypeById(id);
    }

    @GetMapping("/findStatus/{id}")
    public RepairStatusDTO findStatusById(@PathVariable("id") Long id) {
        return managementService.findRepairStatusById(id);
    }

    @GetMapping("/getFilesList/{clientDir}")
    public List<FileDTO> filesStrings(@PathVariable("clientDir") String clientDir) throws IOException {
        List<FileDTO> fileDTOS = new ArrayList<>();
        String dir = "/home/x3m/Downloads/rem/clientFiles/" + clientDir;
        Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (!Files.isDirectory(file)) {
                    String fileName = file.getFileName().toString();
                    fileDTOS.add(new FileDTO(fileName));
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return fileDTOS;
    }
}
