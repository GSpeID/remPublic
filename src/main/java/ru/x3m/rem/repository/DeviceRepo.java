package ru.x3m.rem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.x3m.rem.entity.Device;

@Repository
public interface DeviceRepo extends CrudRepository<Device, Long> {

    Device findByDeviceId(Long id);

}
