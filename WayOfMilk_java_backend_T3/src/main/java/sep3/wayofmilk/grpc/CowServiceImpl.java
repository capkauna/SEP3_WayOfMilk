// T3 Module: src/main/java/sep3/wayofmilk/grpc/CowServiceImpl.java

package sep3.wayofmilk.grpc;

import net.devh.boot.grpc.server.service.GrpcService;
import sep3.javashareddtos.*;
import sep3.wayofmilk.services.CowInfoService; // Your existing service
import sep3.wayofmilk.grpc.CowServiceGrpc; // Generated base class
// Import generated message classes:
import sep3.wayofmilk.grpc.CowData;
import sep3.wayofmilk.grpc.CowList;
import sep3.wayofmilk.grpc.Empty;

import io.grpc.stub.StreamObserver;
import java.time.LocalDate;
import java.util.List;

@GrpcService // Marks this as a gRPC service implementation
public class CowServiceImpl extends CowServiceGrpc.CowServiceImplBase {

  private final CowInfoService coreService;

  public CowServiceImpl(CowInfoService coreService) {
    this.coreService = coreService;
  }

  @Override
  public void getAllCows(Empty request, StreamObserver<CowList> responseObserver) {

    // 1. Call the existing business logic service (returns List<CowInfoDto>)
    List<CowInfoDto> dtos = coreService.getAllCows();

    // 2. Map the DTOs (CowInfoDto) to the gRPC messages (CowData)
    CowList.Builder cowListBuilder = CowList.newBuilder();

    for (CowInfoDto dto : dtos) {
      CowData cowData = CowData.newBuilder()
          .setId(dto.getId())
          .setRegNo(dto.getRegNo())
          // Convert LocalDate to String for gRPC message
          .setBirthDate(dto.getBirthDate().toString())
          .setIsHealthy(dto.isHealthy())
          .build();
      cowListBuilder.addCows(cowData);
    }

    // 3. Send the response and complete the call
    responseObserver.onNext(cowListBuilder.build());
    responseObserver.onCompleted();
  }
  //testng
}