package sep3.wom_t2.grpc;

import org.springframework.stereotype.Component;
import com.wom.proto.*;

@Component
public class CowGrpcClient {
  private final CowServiceGrpc.CowServiceBlockingStub stub;
  public CowGrpcClient(GrpcConfig cfg) { this.stub = cfg.cowStub; }

  public Cow create(String regNo, String birthDateIso, long employeeId) {
    var req = CreateCowRequest.newBuilder()
        .setRegNo(regNo)
        .setBirthDateIso(birthDateIso)
        .setEmployeeId(employeeId)
        .build();
    return stub.createCow(req);
  }
}
