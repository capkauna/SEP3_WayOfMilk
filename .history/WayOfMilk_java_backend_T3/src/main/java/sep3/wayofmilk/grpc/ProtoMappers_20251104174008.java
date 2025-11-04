package sep3.wayofmilk.grpc;

import com.wom.proto.Cow;
import sep3.wayofmilk.entities.Cow;

public class ProtoMappers {

    public static Cow toProto(sep3.wayofmilk.entities.Cow e) {
        return Cow.newBuilder()
                .setId(e.getId())
                .setRegNo(e.getRegNo())
                .setBirthDateIso(e.getBirthDate().toString())
                .setIsHealthy(e.isHealthy())
                .build();
    }
}
