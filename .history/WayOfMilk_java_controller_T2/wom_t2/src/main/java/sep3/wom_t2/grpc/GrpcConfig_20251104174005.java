package sep3.wom_t2.grpc;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Configuration;
import com.wom.proto.CowServiceGrpc;

@Configuration
public class GrpcConfig {
  @GrpcClient("t3")
  public CowServiceGrpc.CowServiceBlockingStub cowStub;
}
