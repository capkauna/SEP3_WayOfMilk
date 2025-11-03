package sep3.wayofmilk.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The service T3 will implement and T2 will call
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: cow_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CowServiceGrpc {

  private CowServiceGrpc() {}

  public static final String SERVICE_NAME = "CowService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.wayofmilk.grpc.Empty,
      sep3.wayofmilk.grpc.CowList> getGetAllCowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCows",
      requestType = sep3.wayofmilk.grpc.Empty.class,
      responseType = sep3.wayofmilk.grpc.CowList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.wayofmilk.grpc.Empty,
      sep3.wayofmilk.grpc.CowList> getGetAllCowsMethod() {
    io.grpc.MethodDescriptor<sep3.wayofmilk.grpc.Empty, sep3.wayofmilk.grpc.CowList> getGetAllCowsMethod;
    if ((getGetAllCowsMethod = CowServiceGrpc.getGetAllCowsMethod) == null) {
      synchronized (CowServiceGrpc.class) {
        if ((getGetAllCowsMethod = CowServiceGrpc.getGetAllCowsMethod) == null) {
          CowServiceGrpc.getGetAllCowsMethod = getGetAllCowsMethod =
              io.grpc.MethodDescriptor.<sep3.wayofmilk.grpc.Empty, sep3.wayofmilk.grpc.CowList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllCows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.wayofmilk.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.wayofmilk.grpc.CowList.getDefaultInstance()))
              .setSchemaDescriptor(new CowServiceMethodDescriptorSupplier("GetAllCows"))
              .build();
        }
      }
    }
    return getGetAllCowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.wayofmilk.grpc.CowCreationRequest,
      sep3.wayofmilk.grpc.CowData> getAddCowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCow",
      requestType = sep3.wayofmilk.grpc.CowCreationRequest.class,
      responseType = sep3.wayofmilk.grpc.CowData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.wayofmilk.grpc.CowCreationRequest,
      sep3.wayofmilk.grpc.CowData> getAddCowMethod() {
    io.grpc.MethodDescriptor<sep3.wayofmilk.grpc.CowCreationRequest, sep3.wayofmilk.grpc.CowData> getAddCowMethod;
    if ((getAddCowMethod = CowServiceGrpc.getAddCowMethod) == null) {
      synchronized (CowServiceGrpc.class) {
        if ((getAddCowMethod = CowServiceGrpc.getAddCowMethod) == null) {
          CowServiceGrpc.getAddCowMethod = getAddCowMethod =
              io.grpc.MethodDescriptor.<sep3.wayofmilk.grpc.CowCreationRequest, sep3.wayofmilk.grpc.CowData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.wayofmilk.grpc.CowCreationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.wayofmilk.grpc.CowData.getDefaultInstance()))
              .setSchemaDescriptor(new CowServiceMethodDescriptorSupplier("AddCow"))
              .build();
        }
      }
    }
    return getAddCowMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CowServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CowServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CowServiceStub>() {
        @java.lang.Override
        public CowServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CowServiceStub(channel, callOptions);
        }
      };
    return CowServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CowServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CowServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CowServiceBlockingStub>() {
        @java.lang.Override
        public CowServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CowServiceBlockingStub(channel, callOptions);
        }
      };
    return CowServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CowServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CowServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CowServiceFutureStub>() {
        @java.lang.Override
        public CowServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CowServiceFutureStub(channel, callOptions);
        }
      };
    return CowServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The service T3 will implement and T2 will call
   * </pre>
   */
  public static abstract class CowServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllCows(sep3.wayofmilk.grpc.Empty request,
        io.grpc.stub.StreamObserver<sep3.wayofmilk.grpc.CowList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCowsMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc AddCow (CowCreationRequest) returns (CowIdResponse); // for the next feature
     * </pre>
     */
    public void addCow(sep3.wayofmilk.grpc.CowCreationRequest request,
        io.grpc.stub.StreamObserver<sep3.wayofmilk.grpc.CowData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCowMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllCowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.wayofmilk.grpc.Empty,
                sep3.wayofmilk.grpc.CowList>(
                  this, METHODID_GET_ALL_COWS)))
          .addMethod(
            getAddCowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.wayofmilk.grpc.CowCreationRequest,
                sep3.wayofmilk.grpc.CowData>(
                  this, METHODID_ADD_COW)))
          .build();
    }
  }

  /**
   * <pre>
   * The service T3 will implement and T2 will call
   * </pre>
   */
  public static final class CowServiceStub extends io.grpc.stub.AbstractAsyncStub<CowServiceStub> {
    private CowServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CowServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CowServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllCows(sep3.wayofmilk.grpc.Empty request,
        io.grpc.stub.StreamObserver<sep3.wayofmilk.grpc.CowList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc AddCow (CowCreationRequest) returns (CowIdResponse); // for the next feature
     * </pre>
     */
    public void addCow(sep3.wayofmilk.grpc.CowCreationRequest request,
        io.grpc.stub.StreamObserver<sep3.wayofmilk.grpc.CowData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCowMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service T3 will implement and T2 will call
   * </pre>
   */
  public static final class CowServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CowServiceBlockingStub> {
    private CowServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CowServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CowServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.wayofmilk.grpc.CowList getAllCows(sep3.wayofmilk.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCowsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * rpc AddCow (CowCreationRequest) returns (CowIdResponse); // for the next feature
     * </pre>
     */
    public sep3.wayofmilk.grpc.CowData addCow(sep3.wayofmilk.grpc.CowCreationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCowMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service T3 will implement and T2 will call
   * </pre>
   */
  public static final class CowServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CowServiceFutureStub> {
    private CowServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CowServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CowServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.wayofmilk.grpc.CowList> getAllCows(
        sep3.wayofmilk.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCowsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * rpc AddCow (CowCreationRequest) returns (CowIdResponse); // for the next feature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.wayofmilk.grpc.CowData> addCow(
        sep3.wayofmilk.grpc.CowCreationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_COWS = 0;
  private static final int METHODID_ADD_COW = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CowServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CowServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_COWS:
          serviceImpl.getAllCows((sep3.wayofmilk.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<sep3.wayofmilk.grpc.CowList>) responseObserver);
          break;
        case METHODID_ADD_COW:
          serviceImpl.addCow((sep3.wayofmilk.grpc.CowCreationRequest) request,
              (io.grpc.stub.StreamObserver<sep3.wayofmilk.grpc.CowData>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CowServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CowServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.wayofmilk.grpc.CowServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CowService");
    }
  }

  private static final class CowServiceFileDescriptorSupplier
      extends CowServiceBaseDescriptorSupplier {
    CowServiceFileDescriptorSupplier() {}
  }

  private static final class CowServiceMethodDescriptorSupplier
      extends CowServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CowServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CowServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CowServiceFileDescriptorSupplier())
              .addMethod(getGetAllCowsMethod())
              .addMethod(getAddCowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
