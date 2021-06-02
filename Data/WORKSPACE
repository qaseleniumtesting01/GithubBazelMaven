load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

skylib_version = "0.8.0"

http_archive(
    name = "bazel_skylib",
    sha256 = "2ef429f5d7ce7111263289644d233707dba35e39696377ebab8b0bc701f7818e",
    type = "tar.gz",
    url = "https://github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib.{}.tar.gz".format(skylib_version, skylib_version),
)

load("@bazel_skylib//lib:versions.bzl", "versions")

BAZEL_VERSION = "0.27.0"

versions.check(minimum_bazel_version = BAZEL_VERSION)

RULES_JVM_EXTERNAL_TAG = "2.7"
RULES_JVM_EXTERNAL_SHA = "f04b1466a00a2845106801e0c5cec96841f49ea4e7d1df88dc8e4bf31523df74"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

# =========================
#  Protobuf Building
# =========================

http_archive(
    name = "com_google_protobuf",
    sha256 = "8eb5ca331ab8ca0da2baea7fc0607d86c46c80845deca57109a5d637ccb93bb4",
    strip_prefix = "protobuf-3.9.0",
    urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.9.0.zip"],
)

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

http_archive(
    name = "io_grpc_grpc_java",
    sha256 = "9618a6f4ec0f2bdb77d9b6e01865af9796f370e63e1352210798bacfc99ccdac",
    strip_prefix = "grpc-java-1.23.0",
    urls = ["https://github.com/grpc/grpc-java/archive/v1.23.0.tar.gz"],
)

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

# =========================
#  Versions
# =========================

OPENCENSUS_VERSION = "0.23.0"

# =========================
#  Dependencies
# =========================

maven_install(
    # WARNING
    # We pin artifacts, which makes builds fast but does add an extra complication.
    # Once you've added a dep here you _must_ run the following on the command line:
    #
    # > bazel run @unpinned_maven//:pin
    artifacts = [
        "com.google.guava:guava:28.0-jre",
        "io.opencensus:opencensus-api:" + OPENCENSUS_VERSION,
        "io.opencensus:opencensus-contrib-agent:" + OPENCENSUS_VERSION,
        "io.opencensus:opencensus-contrib-grpc-metrics:" + OPENCENSUS_VERSION,
        "io.opencensus:opencensus-impl:" + OPENCENSUS_VERSION,
        "io.opencensus:opencensus-exporter-stats-stackdriver:" + OPENCENSUS_VERSION,
        "io.opencensus:opencensus-exporter-trace-stackdriver:" + OPENCENSUS_VERSION,
    ],
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
        "https://nexus.bedatadriven.com/content/groups/public/",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()
