DESCRIPTION = "Let's encript"

LICENSE="CLOSED"
LIC_FILES_CHKSUM=""

inherit update-rc.d

SRC_URI += "file://letsencript.init"

do_install_append () {
    # Install init script
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/letsencript.init ${D}${sysconfdir}/init.d/letsencript
	sed -i 's,/usr/sbin/,${sbindir}/,g' ${D}${sysconfdir}/init.d/letsencript
	sed -i 's,/etc/,${sysconfdir}/,g'  ${D}${sysconfdir}/init.d/letsencript
}

INITSCRIPT_NAME = "letsencript"
INITSCRIPT_PARAMS = "defaults 90 20"

RDEPENDS_${PN} += "python3-certbot python3-certbot-nginx bash"