DESCRIPTION = "Email sender"
LICENSE = "GPLv2"

inherit update-rc.d

INITSCRIPT_NAME = "emailsender"
INITSCRIPT_PARAMS = "defaults 90 20"

SRC_URI = "git:///home/scvready/workspace/github/emailsender/;branch=master;protocol=file"
SRCREV = "${AUTOREV}"

SRC_URI += " \
            file://emailsender.init \
            file://emailsender-volatile.conf \
           "

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"


do_install () {
	
	# WebApp files installation

	install -d ${D}${base_prefix}/home/root/emailsender
	install -m 0755 ${WORKDIR}/git/emailsender.py ${D}${base_prefix}/home/root/emailsender/emailsender.py
	install -m 0755 ${WORKDIR}/git/email_client.py ${D}${base_prefix}/home/root/emailsender/email_client.py
	install -m 0755 ${WORKDIR}/git/redis_db.py ${D}${base_prefix}/home/root/emailsender/redis_db.py
	install -m 0755 ${WORKDIR}/git/sqlite_db.py ${D}${base_prefix}/home/root/emailsender/sqlite_db.py

	# Install init script
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/emailsender.init ${D}${sysconfdir}/init.d/emailsender

	# /etc/default/volatiles/emailsender-volatile.conf for populate-volatile.sh

	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0644 ${WORKDIR}/emailsender-volatile.conf ${D}${sysconfdir}/default/volatiles/99_emailsender

}

FILES_${PN} += "${base_prefix}/home/root/emailsender/*"
