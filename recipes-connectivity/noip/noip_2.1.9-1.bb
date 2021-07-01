DESCRIPTION = "NO-IP DUC"
LICENSE = "GPLv2"

SRC_URI = "file://noip-duc-linux_${PV}.tar.gz"

SRC_URI += "file://domain_via_inputoptions.patch"

LIC_FILES_CHKSUM = "file://COPYING;md5=7975d4f2e1ca1e9df4dcfd94c6e1ae48"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

INSANE_SKIP_${PN} = "file-rdeps"

do_compile () {
    ${CC} ${CFLAGS} ${LDFLAGS} noip2.c -o noip2
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/noip-${PV}/noip2 ${D}${bindir}/
}

FILES_${PN} += "${sysconfdir}/noip2"