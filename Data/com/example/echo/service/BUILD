java_library(
    name = "lib",
    srcs = [
        "EchoRpcService.java",
    ],
    visibility = ["//com/example/echo:__subpackages__"],
    deps = [
        "@io_grpc_grpc_java//core",
        "@io_grpc_grpc_java//stub",
        "//proto:echo_java_proto",
        "//proto:echo_proto",
        "//proto:lib",
    ],
)
