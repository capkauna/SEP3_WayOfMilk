package sep3.wayofmilk.grpc;

public class ProtoMappers {

    public static com.wom.proto.Cow toProto(sep3.wayofmilk.entities.Cow e) {
        return com.wom.proto.Cow.newBuilder()
                .setId(e.getId())
                .setRegNo(e.getRegNo())
                .setBirthDateIso(e.getBirthDate().toString())
                .setIsHealthy(e.isHealthy())
                .build();
    }
}
