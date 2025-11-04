package sep3.wayofmilk.services;

import org.springframework.stereotype.Service;
import sep3.wayofmilk.DTOs.CowCreationDto;
import sep3.wayofmilk.DTOs.CowInfoDto;
import sep3.wayofmilk.entities.Cow;
import sep3.wayofmilk.repositoryDAOs.CowDAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    private static LocalDate parseDate(String text) {
        // Akceptuj "yyyy-MM-dd" i "yyyy-MM-ddTHH:mm:ss"
        if (text == null || text.isBlank()) throw new IllegalArgumentException("birthDate is required");
        if (text.indexOf('T') > 0) {
            return LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME).toLocalDate();
        }
        return LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public CowInfoDto createCow(String regNo, String birthDateIso) {
        var date = parseDate(birthDateIso);
        var toSave = new sep3.wayofmilk.entities.Cow(
            regNo,
            date,
            true  // healthy na start w POC
        );
        var saved = cowDAO.save(toSave);
    return toDto(saved);
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
