DESCRIPTION = "Home surveillance with Kinect deph camera"
LICENSE = "GPLv2"

DEFAULT_PREFERENCE = "0"

SRC_URI = "https://github.com/SCVready/kinectalarm/archive/v0.1.tar.gz"
SRC_URI[md5sum] = "a65227f0b0f8488d12fb394c73a87e8d"
SRC_URI[sha256sum] = "f10b375355c1162b4fb36b9172f14ef3dca7c0d8bca5a454750ecfbc4d37f96e"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"

DEPENDS = "libfreenect libxml2 ffmpeg freeimage"

inherit cmake
