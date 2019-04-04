FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://omx_fix_buffer.patch \
            file://omx_printf_lib.patch \
            file://omx_zero_copy.patch \
            "

PACKAGECONFIG_append = " omx-rpi"

PACKAGECONFIG[omx] = "--enable-omx,--disable-omx,libomxil,libomxil"
PACKAGECONFIG[omx-rpi] = "--enable-omx-rpi,--disable-omx-rpi,libomxil,libomxil"

RDEPENDS_${PN}_append = " userland"
