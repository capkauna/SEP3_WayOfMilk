package sep3.wayofmilk.grpc;

import sep3.wayofmilk.DTOs.CowInfoDto;

public class ProtoMappers {

    public static com.wom.proto.Cow toProto(CowInfoDto d) {
        return com.wom.proto.Cow.newBuilder()
                .setId(d.getId())
                .setRegNo(d.getRegNo())
                .setBirthDateIso(d.getBirthDate().toString())
                .setIsHealthy(d.isHealthy())
                .build();
    }
}
