DESCRIPTION = "Drivers and libraries for the Xbox Kinect device on Windows, Linux, and OS X"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL2;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "libusb1 freeglut libxi libxmu"

SRC_URI = "https://github.com/OpenKinect/libfreenect/archive/v${PV}.tar.gz;downloadfilename=${P}.tar.gz"
SRC_URI[md5sum] = "342aa819d930c1d6594cd8b193b2f0b4"
SRC_URI[sha256sum] = "5f22c9a0260efd5a31d8e6465bb06b2b389f61b8f7714e0b42b7b20314e5ef59"

inherit cmake

#force libs always into /usr/lib, even when compiling on 64bit arch
EXTRA_OECMAKE += " -DLIB_SUFFIX=''"

FILES_${PN} += "\
    ${libdir}/fakenect/libfakenect.so.* \
    ${datadir}/fwfetcher.py \
    "
FILES_${PN}-dev += "${libdir}/fakenect/libfakenect.so" 
FILES_${PN}-dbg += "${libdir}/fakenect/.debug"

RDEPENDS_${PN} += "bash"
