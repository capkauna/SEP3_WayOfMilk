package sep3.wayofmilk.grpc;

import com.wom.proto.CowServiceGrpc;
import com.wom.proto.CreateCowRequest;
import com.wom.proto.Cow;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import sep3.wayofmilk.entities.Cow as CowEntity; // jeśli koliduje nazwa, użyj pełnych

import sep3.wayofmilk.services.CowInfoService;

@GrpcService
public class CowServiceGrpcImpl extends CowServiceGrpc.CowServiceImplBase {

  private final CowInfoService service;
  public CowServiceGrpcImpl(CowInfoService service) { this.service = service; }

  @Override
  public void createCow(CreateCowRequest req, StreamObserver<Cow> resp) {
    var saved = service.createCow( // użyj swojej metody; jeśli inna sygnatura – dopasuję po podesłaniu
        req.getRegNo(),
        req.getBirthDateIso(), // parsuj w serwisie do LocalDate
        req.getEmployeeId()
    );
    var out = ProtoMappers.toProto(saved);
    resp.onNext(out);
    resp.onCompleted();
  }
}
