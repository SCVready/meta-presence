DESCRIPTION = "Init script to generate x509 certificate"
LICENSE = "GPLv2"

inherit update-rc.d

SRC_URI += " \
            file://LICENSE \
            file://webapp-keygen.init \
           "

S = "${WORKDIR}/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"

do_install_append () {

	# Install init script
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/webapp-keygen.init ${D}${sysconfdir}/init.d/webapp-keygen
}

INITSCRIPT_NAME = "webapp-keygen"
INITSCRIPT_PARAMS = "defaults 89 20"

RDEPENDS_${PN} += "openssl-bin"
