DESCRIPTION = "Web server for kinectalarm"
LICENSE = "GPLv2"

inherit update-rc.d

INITSCRIPT_NAME = "gunicorn"
INITSCRIPT_PARAMS = "defaults 92 20"

SRC_URI = "git:///home/scvready/workspace/github/webapp/;branch=master;protocol=file"
SRCREV = "${AUTOREV}"

SRC_URI += " \
            file://gunicorn.init \
            file://gunicorn-volatile.conf \
            file://gunicorn_conf.py \
           "

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

# Don' own parent directories of this package. To avoid conflict in /var/www/localhost/html
DIRFILES = "1" 

do_install () {
	
	# WebApp files installation

	install -d ${D}${base_prefix}/home/root/webapp
	install -m 0755 ${WORKDIR}/git/webapp.py ${D}${base_prefix}/home/root/webapp/webapp.py

	install -d ${D}${base_prefix}/home/root/webapp/templates
	for file in ${WORKDIR}/git/templates/*;do
	    install -m 755 "$file" ${D}${base_prefix}/home/root/webapp/templates/
	done

	install -d ${D}${base_prefix}/var/www/localhost/html
	cp -R ${WORKDIR}/git/static/. ${D}${base_prefix}/var/www/localhost/html/

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


FILES_${PN} += "${base_prefix}/home/root/webapp/webapp.py"

FILES_${PN} += "${base_prefix}/home/root/webapp/templates/base.html"
FILES_${PN} += "${base_prefix}/home/root/webapp/templates/error.html"
FILES_${PN} += "${base_prefix}/home/root/webapp/templates/liveview.html"
FILES_${PN} += "${base_prefix}/home/root/webapp/templates/login.html"
FILES_${PN} += "${base_prefix}/home/root/webapp/templates/main.html"

RDEPENDS_${PN} += "python3-flask python3-flask-login python3-flask-socketio gunicorn python-gevent"

