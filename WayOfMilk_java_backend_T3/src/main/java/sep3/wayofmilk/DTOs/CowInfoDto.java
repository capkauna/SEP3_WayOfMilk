package sep3.wayofmilk.DTOs;

import java.time.LocalDate;

public class CowInfoDto {
    private long id;
    private String regNo;
    private LocalDate birthDate;
    private boolean healthy;

    public CowInfoDto() {}

    public CowInfoDto(long id, String regNo, LocalDate birthDate, boolean healthy) {
        this.id = id;
        this.regNo = regNo;
        this.birthDate = birthDate;
        this.healthy = healthy;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public boolean isHealthy() { return healthy; }
    public void setHealthy(boolean healthy) { this.healthy = healthy; }
}
