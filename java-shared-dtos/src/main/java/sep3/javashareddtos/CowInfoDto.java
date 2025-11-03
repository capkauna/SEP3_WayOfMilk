package sep3.javashareddtos;

import java.time.LocalDate;

public class CowInfoDto
{
  private long id;
  private String regNo;
  private LocalDate birthDate;
  private boolean isHealthy= false;

  public CowInfoDto()
  {
  }

  public CowInfoDto(long id, String regNo, LocalDate birthDate, boolean isHealthy)
  {
    this.id = id;
    this.regNo = regNo;
    this.birthDate = birthDate;
    this.isHealthy = isHealthy;
  }
}
