package com.weasel.frp.service;

import com.weasel.frp.domain.device.Device;

import java.util.List;

/**
 * @author Dylan
 * @date 2017/1/22.
 */
public interface DeviceService {


     List<Device> query(Device device);
}
