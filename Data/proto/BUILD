package(default_visibility = ["//visibility:public"])

load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")

proto_library(
    name = "echo_proto",
    srcs = ["echo.proto"],
)

java_proto_library(
    name = "echo_java_proto",
    deps = [
        ":echo_proto",
    ],
)

java_grpc_library(
    name = "lib",
    srcs = [":echo_proto"],
    deps = [
        ":echo_java_proto",
    ],
)
