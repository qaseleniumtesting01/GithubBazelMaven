package com.example.echo.server;

import com.example.echo.service.EchoRpcService;
import com.google.common.collect.ImmutableMap;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.opencensus.contrib.grpc.metrics.RpcViews;
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceConfiguration;
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceExporter;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.config.TraceConfig;
import io.opencensus.trace.samplers.Samplers;

import java.io.IOException;

public class EchoServer {
  public static void main(String[] args) throws IOException, InterruptedException {
    // Register all the gRPC views and enable stats
    RpcViews.registerAllGrpcViews();

    TraceConfig traceConfig = Tracing.getTraceConfig();
    traceConfig.updateActiveTraceParams(
        traceConfig.getActiveTraceParams()
                   .toBuilder()
                   .setSampler(Samplers.probabilitySampler(0.1))
                   .build());

    // Create the Stackdriver trace exporter
    StackdriverTraceExporter.createAndRegister(
        StackdriverTraceConfiguration
            .builder()
            .setFixedAttributes(new ImmutableMap.Builder<String, AttributeValue>()
                                    .put("service", AttributeValue.stringAttributeValue("echo"))
                                    .build())
            .build());

    EchoRpcService echoRpcService = new EchoRpcService();

    final Server server = NettyServerBuilder
        .forPort(8080)
        .addService(echoRpcService)
        .build();
    server.start();
    server.awaitTermination();
  }
}
