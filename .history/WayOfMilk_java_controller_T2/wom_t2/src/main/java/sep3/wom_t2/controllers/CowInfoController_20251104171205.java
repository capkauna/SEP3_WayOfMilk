package sep3.wom_t2.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import sep3.wom_t2.grpc.CowGrpcClient;
import com.wom.proto.Cow;

@RestController
@RequestMapping("/api/cows")
public class CowInfoController {

  record CreateCowDto(String regNo, String birthDate) {}
  record CowDto(long id, String regNo, String birthDate, boolean isHealthy) {}

  private final CowGrpcClient client;
  public CowInfoController(CowGrpcClient client) { this.client = client; }

  @PostMapping
  public ResponseEntity<CowDto> create(@RequestBody CreateCowDto body) {
    Cow created = client.create(body.regNo(), body.birthDate(), 1L);
    var dto = new CowDto(created.getId(), created.getRegNo(),
                         created.getBirthDateIso(), created.getIsHealthy());
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }
}
