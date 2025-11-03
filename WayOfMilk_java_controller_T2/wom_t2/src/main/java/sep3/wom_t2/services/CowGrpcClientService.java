// T2 Module: src/main/java/sep3/wom_t2/service/CowGrpcClientService.java

package sep3.wom_t2.services;

import net.devh.boot.grpc.server.service.GrpcClient;
import sep3.wayofmilk.grpc.CowData;
import sep3.wayofmilk.grpc.CowList;
import sep3.wayofmilk.grpc.CowServiceGrpc; // Generated client class
import sep3.wayofmilk.grpc.Empty;
import sep3.javashareddtos.CowInfoDto; // Import the shared DTO
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CowGrpcClientService {

  // Inject the gRPC stub, which handles communication setup
  @GrpcClient("core-server") // 'core-server' is the name we'll configure
  private CowServiceGrpc.CowServiceGrpcBlockingStub cowStub;

  public List<CowInfoDto> getAllCows() {
    // Call the remote gRPC method synchronously
    CowList cowList = cowStub.getAllCows(Empty.newBuilder().build());

    // Map the gRPC messages (CowData) back to the shared DTOs (CowInfoDto)
    return cowList.getCowsList().stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  // Helper method to convert gRPC message to shared DTO
  private CowInfoDto convertToDto(CowData cowData) {
    return new CowInfoDto(
        cowData.getId(),
        cowData.getRegNo(),
        LocalDate.parse(cowData.getBirthDate()), // Convert string back to LocalDate
        cowData.getIsHealthy()
    );
  }
}