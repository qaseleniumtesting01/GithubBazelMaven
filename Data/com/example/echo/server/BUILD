java_library(
    name = "lib",
    srcs = [
        "EchoServer.java",
    ],
    visibility = ["//visibility:public"],
    runtime_deps = [
        "@maven//:io_opencensus_opencensus_contrib_agent",
    ],
    deps = [
        "@io_grpc_grpc_java//api",
        "@io_grpc_grpc_java//netty",
        "@maven//:com_google_api_grpc_proto_google_common_protos",
        "@maven//:com_google_guava_guava",
        "@maven//:com_typesafe_config",
        "@maven//:io_opencensus_opencensus_api",
        "@maven//:io_opencensus_opencensus_contrib_grpc_metrics",
        "@maven//:io_opencensus_opencensus_impl",
        "@maven//:io_opencensus_opencensus_exporter_stats_stackdriver",
        "@maven//:io_opencensus_opencensus_exporter_trace_stackdriver",
        "//com/example/echo/service:lib",
    ],
)
