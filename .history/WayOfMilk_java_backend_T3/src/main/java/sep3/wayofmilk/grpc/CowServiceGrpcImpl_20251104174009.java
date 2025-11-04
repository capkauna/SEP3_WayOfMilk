package sep3.wayofmilk.grpc;

import com.wom.proto.CowServiceGrpc;
import com.wom.proto.CreateCowRequest;
import com.wom.proto.Cow;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import sep3.wayofmilk.entities.Cow; // ← to twoja encja
import sep3.wayofmilk.services.CowInfoService;

@GrpcService
public class CowServiceGrpcImpl extends CowServiceGrpc.CowServiceImplBase {

    private final CowInfoService service;

    public CowServiceGrpcImpl(CowInfoService service) {
        this.service = service;
    }

    @Override
    public void createCow(CreateCowRequest req, StreamObserver<Cow> resp) {
        // stwórz encję krowy przez serwis domenowy
        sep3.wayofmilk.entities.Cow saved =
                service.createCow(req.getRegNo(), req.getBirthDateIso(), req.getEmployeeId());

        com.wom.proto.Cow out = ProtoMappers.toProto(saved);
        resp.onNext(out);
        resp.onCompleted();
    }
}
