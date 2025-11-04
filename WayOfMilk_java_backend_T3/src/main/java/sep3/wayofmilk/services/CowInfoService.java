package sep3.wayofmilk.services;

import sep3.wayofmilk.DTOs.CowCreationDto;
import sep3.wayofmilk.DTOs.CowInfoDto;

import java.util.List;

public interface CowInfoService {
    List<CowInfoDto> getAllCows();
    CowInfoDto addCow(CowCreationDto cow);
    // Will add more signatures later (getById, updateHealth, moveDept, etc.) //Waqar
}
