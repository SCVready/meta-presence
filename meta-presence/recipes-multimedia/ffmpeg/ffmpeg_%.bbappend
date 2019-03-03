FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://omx.patch"

PACKAGECONFIG_append = " omx-rpi"

PACKAGECONFIG[omx] = "--enable-omx,--disable-omx,libomxil"
PACKAGECONFIG[omx-rpi] = "--enable-omx-rpi,--disable-omx-rpi,libomxil"

RDEPENDS_${PN}_append = " userland"
