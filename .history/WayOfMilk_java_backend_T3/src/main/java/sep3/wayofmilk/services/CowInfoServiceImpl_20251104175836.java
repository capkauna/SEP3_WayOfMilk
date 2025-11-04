package sep3.wayofmilk.services;

import org.springframework.stereotype.Service;
import sep3.wayofmilk.DTOs.CowCreationDto;
import sep3.wayofmilk.DTOs.CowInfoDto;
import sep3.wayofmilk.entities.Cow;
import sep3.wayofmilk.repositoryDAOs.CowDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CowInfoServiceImpl implements CowInfoService {

    private final CowDAO cowDAO;

    public CowInfoServiceImpl(CowDAO cowDAO) {
        this.cowDAO = cowDAO;
    }

    @Override
    public List<CowInfoDto> getAllCows() {
        return cowDAO.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CowInfoDto addCow(CowCreationDto cowDto) {
        // default new cows to not healthy (quarantine until confirmed by VET)
        Cow toSave = new Cow(cowDto.getRegNo(), cowDto.getBirthDate(), false);
        Cow saved = cowDAO.save(toSave);
        return toDto(saved);
    }

    @Override
    public CowInfoDto createCow(String regNo, String birthDateIso) {
    Cow cow = new Cow();
    cow.setRegNo(regNo);
    cow.setBirthDate(LocalDate.parse(birthDateIso));
    cow.setHealthy(true);
    // jeśli masz DAO/repo, zapisz — np. cowRepository.save(cow)
    return cow;
}


    // ---- !!! Important to note! mapping helpers (keeps service decoupled from entity shape)
    private CowInfoDto toDto(Cow cow) {
        return new CowInfoDto(
                cow.getId(),
                cow.getRegNo(),
                cow.getBirthDate(),
                cow.isHealthy()
        );
    }
}
