DESCRIPTION = "NO-IP DUC"
LICENSE = "GPLv2"

inherit update-rc.d

SRC_URI = "file://noip-duc-linux_${PV}.tar.gz"

SRC_URI += "file://domain_via_inputoptions.patch"
SRC_URI += "file://kill_all_instance_on_K_eq_0.patch"
SRC_URI += "file://retvalue_on_error.patch"
SRC_URI += "file://noip.init"

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

    install -d ${D}${sysconfdir}/noip
}

do_install_append () {
    # Install init script
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/noip.init ${D}${sysconfdir}/init.d/noip
	sed -i 's,/usr/sbin/,${sbindir}/,g' ${D}${sysconfdir}/init.d/noip
	sed -i 's,/etc/,${sysconfdir}/,g'  ${D}${sysconfdir}/init.d/noip
}

INITSCRIPT_NAME = "noip"
INITSCRIPT_PARAMS = "defaults 90 20"

FILES_${PN} += "${sysconfdir}/noip2"