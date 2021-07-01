# boot setup recipe
DESCRIPTION = "Expands root fs on the first boot"
LICENSE = "GPLv2"

S = "${WORKDIR}/"

RDEPENDS_${PN} = "e2fsprogs-resize2fs parted bash"

SCRIPTFILE="resizerootfs"

SRC_URI = "file://LICENSE \
           file://${SCRIPTFILE} \
           file://state"

inherit update-rc.d

INITSCRIPT_NAME = "${SCRIPTFILE}"
INITSCRIPT_PARAMS = "defaults 99 20"

do_install () {
    install -m 0755 -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/${SCRIPTFILE} ${D}${sysconfdir}/init.d/${SCRIPTFILE}
    install -m 0755 -d ${D}${sysconfdir}/${SCRIPTFILE}
    install -m 0755 ${WORKDIR}/state ${D}${sysconfdir}/${SCRIPTFILE}/state
}

LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"
