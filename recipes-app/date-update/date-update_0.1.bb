DESCRIPTION = "date-update"

LICENSE="CLOSED"
LIC_FILES_CHKSUM=""

inherit update-rc.d

SRC_URI += "file://date-update.init"

do_install_append () {
    # Install init script
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/date-update.init ${D}${sysconfdir}/init.d/date-update
	sed -i 's,/usr/sbin/,${sbindir}/,g' ${D}${sysconfdir}/init.d/date-update
	sed -i 's,/etc/,${sysconfdir}/,g'  ${D}${sysconfdir}/init.d/date-update
}

INITSCRIPT_NAME = "date-update"
INITSCRIPT_PARAMS = "defaults 90 20"

RDEPENDS_${PN} += "htpdate bash"
