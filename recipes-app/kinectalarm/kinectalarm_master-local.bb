DESCRIPTION = "Home surveillance with Kinect deph camera"
LICENSE = "GPLv2"

DEFAULT_PREFERENCE = "10"

inherit cmake update-rc.d

SRC_URI = "git:///home/scvready/workspace/github/kinectalarm/;branch=master;protocol=file"
SRCREV = "${AUTOREV}"

SRC_URI += " \
           file://kinectalarm.init \
           file://kinectalarm-volatile.conf \
           file://kinectalarm.conf \
           "

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"

DEPENDS = "libfreenect libxml2 ffmpeg freeimage hiredis libevent openssl"

do_install_append () {
	
	# Config file on /etc/kinectalarm/kinectalarm.conf

	install -d ${D}${sysconfdir}/kinectalarm
	install -m 0644 ${WORKDIR}/kinectalarm.conf ${D}${sysconfdir}/kinectalarm/kinectalarm.conf

	# Detection folder on /var/detections

	install -d ${D}${localstatedir}/detections

	# Install init script
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/kinectalarm.init ${D}${sysconfdir}/init.d/kinectalarm
	sed -i 's,/usr/sbin/,${sbindir}/,g' ${D}${sysconfdir}/init.d/kinectalarm
	sed -i 's,/etc/,${sysconfdir}/,g'  ${D}${sysconfdir}/init.d/kinectalarm

	# /etc/default/volatiles/kinectalarm-volatile.conf for populate-volatile.sh

	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0644 ${WORKDIR}/kinectalarm-volatile.conf ${D}${sysconfdir}/default/volatiles/99_kinectalarm
}

# Populate folder on temp directories

pkg_postinst_${PN} () {
    if [ -z "$D" ]; then
        if type systemd-tmpfiles >/dev/null; then
            systemd-tmpfiles --create
        elif [ -e ${sysconfdir}/init.d/populate-volatile.sh ]; then
            ${sysconfdir}/init.d/populate-volatile.sh update
        fi
    fi
}

INITSCRIPT_NAME = "kinectalarm"
INITSCRIPT_PARAMS = "defaults 90 20"

RDEPENDS_${PN} += "libstdc++ openssl libevent hiredis"
