DESCRIPTION = "A simple, jQuery free Snackbar (Toast) alert"
LICENSE = "MIT"

HOMEPAGE = "http://michaelmickelson.com/js-snackbar"

SRC_URI = "git://github.com/mickelsonmichael/js-snackbar"
SRCREV = "${AUTOREV}"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b519b74b19189b3fcffdb2f72c4f992e"

S = "${WORKDIR}/git/"

# Don' own parent directories of this package. To avoid conflict in /var/www/localhost/html:
DIRFILES = "1" 

do_install () {

	# Static files installation
	install -d ${D}${base_prefix}/var/www/localhost/html/css
	install -d ${D}${base_prefix}/var/www/localhost/html/js

	install -m 0755 ${WORKDIR}/git/css/js-snackbar.min.css ${D}${base_prefix}/var/www/localhost/html/css/js-snackbar.min.css
	install -m 0755 ${WORKDIR}/git/js/js-snackbar.min.js ${D}${base_prefix}/var/www/localhost/html/js/js-snackbar.min.js
}

FILES_${PN} += "${base_prefix}/var/www/localhost/html/*"
