// T3 Module: src/main/java/sep3/wayofmilk/grpc/CowServiceImpl.java

package sep3.wayofmilk.grpc;

import net.devh.boot.grpc.server.service.GrpcService;
import sep3.javashareddtos.*;
import sep3.wayofmilk.services.CowInfoService; // the existing service
// Import generated message classes:

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

  @Override
  public void addCow(CowCreationRequest request, StreamObserver<CowData> responseObserver) {

    // 1. Convert the gRPC Request message into the Spring DTO
    CowCreationDto creationDto = new CowCreationDto(
        request.getRegNo(),
        LocalDate.parse(request.getBirthDate()) // Convert string to LocalDate
    );

    // 2. Call the Core Business Service
    CowInfoDto createdDto = coreService.addCow(creationDto);

    // 3. Convert the resulting CowInfoDto back into the gRPC response message (CowData)
    CowData responseData = CowData.newBuilder()
        .setId(createdDto.getId())
        .setRegNo(createdDto.getRegNo())
        .setBirthDate(createdDto.getBirthDate().toString())
        .setIsHealthy(createdDto.isHealthy())
        .build();

    // 4. Send the response and complete the call
    responseObserver.onNext(responseData);
    responseObserver.onCompleted();
  }
  //testng
  //hahaha
}