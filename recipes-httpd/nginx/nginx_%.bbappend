FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " file://nginx.conf \
             file://proxy_params \
             file://webserver \
            "

do_install_append() {
	install -m 0644 ${WORKDIR}/proxy_params ${D}${sysconfdir}/nginx/proxy_params
	install -m 0644 ${WORKDIR}/webserver ${D}${sysconfdir}/nginx/sites-enabled/webserver
}
