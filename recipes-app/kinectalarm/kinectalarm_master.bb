require kinectalarm.inc

DESCRIPTION = "Home surveillance with Kinect deph camera"
LICENSE = "GPLv2"

SRC_URI = "git://github.com/SCVready/kinectalarm"
SRCREV = "${AUTOREV}"

SRC_URI += " \
           file://kinectalarm.init \
           file://kinectalarm-volatile.conf \
           file://kinectalarm.conf \
           "

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"
