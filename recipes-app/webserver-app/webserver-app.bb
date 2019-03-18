DESCRIPTION = "Web server for kinectalarm"
LICENSE = "GPLv2"

inherit update-rc.d

INITSCRIPT_NAME = "gunicorn"
INITSCRIPT_PARAMS = "defaults 92 20"

SRC_URI += " \
	    file://LICENSE \
            file://flask_app.py \
            file://gunicorn.init \
            file://gunicorn-volatile.conf \
            file://gunicorn_conf.py \
           "

S = "${WORKDIR}"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"

do_install (){

	install -d ${D}${base_prefix}/home/root/flask_app
	install -m 0755 ${WORKDIR}/flask_app.py ${D}${base_prefix}/home/root/flask_app/flask_app.py

	# Gunicorn Config file on /etc/gunicorn/gunicorn_conf.py

	install -d ${D}${sysconfdir}/gunicorn
	install -m 0644 ${WORKDIR}/gunicorn_conf.py ${D}${sysconfdir}/gunicorn/gunicorn_conf.py

	# Install init script
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/gunicorn.init ${D}${sysconfdir}/init.d/gunicorn
	sed -i 's,/usr/sbin/,${sbindir}/,g' ${D}${sysconfdir}/init.d/gunicorn
	sed -i 's,/etc/,${sysconfdir}/,g'  ${D}${sysconfdir}/init.d/gunicorn

	# /etc/default/volatiles/gunicorn-volatile.conf for populate-volatile.sh

	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0644 ${WORKDIR}/gunicorn-volatile.conf ${D}${sysconfdir}/default/volatiles/99_gunicorn
}

FILES_${PN} += "${base_prefix}/home/root/flask_app/flask_app.py"
