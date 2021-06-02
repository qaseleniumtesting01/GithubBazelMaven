package com.example.echo.service;

import io.grpc.stub.StreamObserver;

public class EchoRpcService extends EchoGrpc.EchoImplBase {
  @Override
  public void echo(
      final EchoRequest request,
      final StreamObserver<EchoResponse> responseObserver
  ) {
    try {
      final EchoResponse echoResponse = EchoResponse.newBuilder()
                                                    .setMsg(request.getMsg())
                                                    .build();
      responseObserver.onNext(echoResponse);
    } finally {
      responseObserver.onCompleted();
    }
  }
}
