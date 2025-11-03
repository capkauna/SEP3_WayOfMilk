// for my own understanding of functionalities
package sep3.wayofmilk.services;

import sep3.wayofmilk.entities.Cow;
import sep3.wayofmilk.repositoryDAOs.CowDAO;
import sep3.javashareddtos.CowInfoDto; // Import the shared DTO
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

// Marks this class as a Spring business service
@Service
public class CowInfoService {

  // Inject the Data Access Object (DAO) / Repository
  private final CowDAO cowDAO;

  // Constructor Injection (Spring automatically provides the CowDAO instance)
  public CowInfoService(CowDAO cowDAO) {
    this.cowDAO = cowDAO;
  }

  /**
   * Retrieves all Cow entities from the database and maps them to DTOs.
   * This is the public contract of the T3 (Core Server).
   * @return A list of CowInfoDto objects.
   */
  public List<CowInfoDto> getAllCows() {

    // 1. Fetch all entities from the PostgreSQL database
    List<Cow> cows = cowDAO.findAll();

    // 2. Map the list of Cow Entities (database objects) to
    //    CowInfoDto DTOs (data transfer objects).
    return cows.stream()
        .map(this::convertToDto) // Use the private helper method
        .collect(Collectors.toList());
  }

  /**
   * Private helper method to convert a single Cow Entity to a CowInfoDto.
   * This decouples the service logic from the entity structure.
   */
  private CowInfoDto convertToDto(Cow cow) {
    // You use the parameterized constructor of the CowInfoDto
    return new CowInfoDto(
        cow.getId(),
        cow.getRegNo(),
        cow.getBirthDate(),
        cow.isHealthy() // Use the isHealthy getter
    );
  }
}