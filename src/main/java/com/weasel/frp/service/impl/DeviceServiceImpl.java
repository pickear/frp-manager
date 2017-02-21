package com.weasel.frp.service.impl;

import com.weasel.frp.domain.device.Device;
import com.weasel.frp.infrastructure.repository.DeviceRepository;
import com.weasel.frp.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dylan
 * @date 2017/1/22.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Override
    public List<Device> query(Device device) {

        return repository.query(device);
    }
}
