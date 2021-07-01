DESCRIPTION = "Init script to generate x509 certificate"
LICENSE = "GPLv2"

inherit update-rc.d

SRC_URI += " \
            file://LICENSE \
            file://gen-cert.init \
           "

S = "${WORKDIR}/"

DEPENDS = "openssl-native"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"

do_install_append () {

	# Install init script
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/gen-cert.init ${D}${sysconfdir}/init.d/gen-cert

	# Generate dh params
	install -d ${D}${sysconfdir}/gunicorn
	openssl dhparam -out ${WORKDIR}/dh.pem 1024
	install -m 0755 ${WORKDIR}/dh.pem ${D}${sysconfdir}/gunicorn/dh.pem

}

INITSCRIPT_NAME = "gen-cert"
INITSCRIPT_PARAMS = "defaults 91 20"

RDEPENDS_${PN} += "openssl-bin bash"
