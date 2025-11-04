package sep3.wom_t2.controllers;

import sep3.wom_t2.service.CowGrpcClientService; // The gRPC client service
import sep3.javashareddtos.CowInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cows") // Public endpoint for the Blazor client
public class CowController {

  private final CowGrpcClientService cowGrpcClientService;

  public CowController(CowGrpcClientService cowGrpcClientService) {
    this.cowGrpcClientService = cowGrpcClientService;
  }

  /**
   * T2 Public Endpoint: Called by the Blazor Client (T1).
   * Maps to: GET http://localhost:8080/cows
   */
  @GetMapping
  public ResponseEntity<List<CowInfoDto>> getAllCows() {
    // T2 calls T3 via gRPC
    List<CowInfoDto> cows = cowGrpcClientService.getAllCows();

    // T2 converts the List<CowInfoDto> to a JSON response for the client (REST)
    return ResponseEntity.ok(cows);
  }
}
