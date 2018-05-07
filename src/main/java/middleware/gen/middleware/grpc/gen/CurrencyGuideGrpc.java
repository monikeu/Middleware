package middleware.grpc.gen;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: src/currency.proto")
public final class CurrencyGuideGrpc {

  private CurrencyGuideGrpc() {}

  public static final String SERVICE_NAME = "routeguide.CurrencyGuide";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<middleware.grpc.gen.Currency,
      middleware.grpc.gen.Price> METHOD_GET_RATES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "routeguide.CurrencyGuide", "getRates"),
          io.grpc.protobuf.ProtoUtils.marshaller(middleware.grpc.gen.Currency.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(middleware.grpc.gen.Price.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurrencyGuideStub newStub(io.grpc.Channel channel) {
    return new CurrencyGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurrencyGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CurrencyGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static CurrencyGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CurrencyGuideFutureStub(channel);
  }

  /**
   */
  public static abstract class CurrencyGuideImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<middleware.grpc.gen.Currency> getRates(
        io.grpc.stub.StreamObserver<middleware.grpc.gen.Price> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_RATES, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_RATES,
            asyncBidiStreamingCall(
              new MethodHandlers<
                middleware.grpc.gen.Currency,
                middleware.grpc.gen.Price>(
                  this, METHODID_GET_RATES)))
          .build();
    }
  }

  /**
   */
  public static final class CurrencyGuideStub extends io.grpc.stub.AbstractStub<CurrencyGuideStub> {
    private CurrencyGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyGuideStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<middleware.grpc.gen.Currency> getRates(
        io.grpc.stub.StreamObserver<middleware.grpc.gen.Price> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_RATES, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CurrencyGuideBlockingStub extends io.grpc.stub.AbstractStub<CurrencyGuideBlockingStub> {
    private CurrencyGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyGuideBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class CurrencyGuideFutureStub extends io.grpc.stub.AbstractStub<CurrencyGuideFutureStub> {
    private CurrencyGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyGuideFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_RATES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CurrencyGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurrencyGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RATES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getRates(
              (io.grpc.stub.StreamObserver<middleware.grpc.gen.Price>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CurrencyGuideDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return middleware.grpc.gen.CurrencyDataProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CurrencyGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurrencyGuideDescriptorSupplier())
              .addMethod(METHOD_GET_RATES)
              .build();
        }
      }
    }
    return result;
  }
}
