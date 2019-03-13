SUMMARY = "FreeImage is an Open Source library project for developers who would like to support popular graphics image formats like PNG, BMP, JPEG, TIFF and others as needed by today's multimedia applications."

SRC_URI = "http://downloads.sourceforge.net/freeimage/FreeImage3180.zip"
SRC_URI[md5sum] = "f8ba138a3be233a3eed9c456e42e2578"
SRC_URI[sha256sum] = "f41379682f9ada94ea7b34fe86bf9ee00935a3147be41b6569c9605a53e438fd"

SRC_URI += "file://Makefile_gnu.patch"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://license-fi.txt;md5=8e1438cab62c8f655288588dc43daaf6 \
    file://license-gplv2.txt;md5=1fbed70be9d970d3da399f33dae9cc51 \
    file://license-gplv3.txt;md5=b5c176c43d7fb06bf6dd56e79c490f5b \
"

S = "${WORKDIR}/FreeImage/"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
    sed -i -e /^CC/d \
           -e /^CXX\ /d \
           -e /^AR/d \
           -e /^INCDIR\ /d \
           -e /^INSTALLDIR\ /d \
           -e s:'-o root -g root'::g \
           -e /ldconfig/d \
    ${S}/Makefile.gnu
}

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    oe_runmake INSTALLDIR="${D}${libdir}" INCDIR="${D}${includedir}" install
}

INSANE_SKIP_${PN} = "already-stripped dev-so"

FILES_${PN} += "${libdir}"
FILES_SOLIBSDEV = "{libdir}/lib${BP}${SOLIBSDEV}"
