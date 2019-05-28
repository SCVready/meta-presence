
inherit update-rc.d

INITSCRIPT_NAME = "gunicorn"
INITSCRIPT_PARAMS = "defaults 91 20"

# Don' own parent directories of this package. To avoid conflict in /var/www/localhost/html:
DIRFILES = "1" 

do_install () {
	
	# WebApp files installation

	install -d ${D}${base_prefix}/home/root/webapp
	install -d ${D}${base_prefix}/home/root/webapp/main
	install -m 0755 ${WORKDIR}/git/__init__.py ${D}${base_prefix}/home/root/webapp/__init__.py
	cp -R ${WORKDIR}/git/main/. ${D}${base_prefix}/home/root/webapp/main

	install -d ${D}${base_prefix}/home/root/webapp/templates
	for file in ${WORKDIR}/git/templates/*;do
	    install -m 755 "$file" ${D}${base_prefix}/home/root/webapp/templates/
	done

	# Static files installation

	install -d ${D}${localstatedir}/www/localhost/html
	install -d ${D}${localstatedir}/www/localhost/html/css
	install -d ${D}${localstatedir}/www/localhost/html/js

	cp -R ${WORKDIR}/git/static/. ${D}${base_prefix}${localstatedir}/www/localhost/html/

	# Gunicorn Config file on /etc/gunicorn/gunicorn_conf.py

	install -d ${D}${sysconfdir}/gunicorn
	install -m 0644 ${WORKDIR}/gunicorn_conf.py ${D}${sysconfdir}/gunicorn/gunicorn_conf.py

	# Webapp passhash file installation
	install -m 0644 ${WORKDIR}/password ${D}${sysconfdir}/gunicorn/password

	# Install init script
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/gunicorn.init ${D}${sysconfdir}/init.d/gunicorn
	sed -i 's,/usr/sbin/,${sbindir}/,g' ${D}${sysconfdir}/init.d/gunicorn
	sed -i 's,/etc/,${sysconfdir}/,g'  ${D}${sysconfdir}/init.d/gunicorn

	# /etc/default/volatiles/gunicorn-volatile.conf for populate-volatile.sh

	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0644 ${WORKDIR}/gunicorn-volatile.conf ${D}${sysconfdir}/default/volatiles/99_gunicorn
}


FILES_${PN} += "${base_prefix}/home/root/webapp/*"
FILES_${PN} += "${base_prefix}/home/root/webapp/main/*"
FILES_${PN} += "${base_prefix}/home/root/webapp/templates/*"

RDEPENDS_${PN} += "python-flask python-flask-login python-flask-socketio python-gunicorn python-eventlet js-snackbar python-psutil"

