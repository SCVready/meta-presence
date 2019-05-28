
require emailsender.inc

DESCRIPTION = "Email sender"
LICENSE = "GPLv2"

SRC_URI = "git://github.com/SCVready/emailsender;tag=v${PV}"

SRC_URI += " \
            file://emailsender.init \
            file://emailsender-volatile.conf \
           "

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
