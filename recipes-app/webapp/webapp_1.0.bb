require webapp.inc

DESCRIPTION = "Web server for kinectalarm"
LICENSE = "GPLv2"

SRC_URI = "git://github.com/SCVready/webapp;tag=v${PV}"

SRC_URI += " \
            file://gunicorn.init \
            file://gunicorn-volatile.conf \
            file://gunicorn_conf.py \
            file://password \
           "

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
