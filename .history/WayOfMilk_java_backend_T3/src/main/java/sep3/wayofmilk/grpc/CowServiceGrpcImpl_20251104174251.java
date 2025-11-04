package sep3.wayofmilk.grpc;

import com.wom.proto.CowServiceGrpc;
import com.wom.proto.CreateCowRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import sep3.wayofmilk.services.CowInfoService;

@GrpcService
public class CowServiceGrpcImpl extends CowServiceGrpc.CowServiceImplBase {

    private final CowInfoService service;

    public CowServiceGrpcImpl(CowInfoService service) {
        this.service = service;
    }

    @Override
    public void createCow(CreateCowRequest req, StreamObserver<com.wom.proto.Cow> resp) {
        sep3.wayofmilk.entities.Cow saved =
                service.createCow(req.getRegNo(), req.getBirthDateIso(), req.getEmployeeId());

        com.wom.proto.Cow out = ProtoMappers.toProto(saved);
        resp.onNext(out);
        resp.onCompleted();
    }
}
