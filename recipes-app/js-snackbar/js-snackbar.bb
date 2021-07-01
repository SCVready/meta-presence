DESCRIPTION = "A simple, jQuery free Snackbar (Toast) alert"
LICENSE = "MIT"

HOMEPAGE = "http://michaelmickelson.com/js-snackbar"

SRC_URI = "git://github.com/mickelsonmichael/js-snackbar.git;protocol=git;branch=master"
SRCREV = "dc0dbb1407eba1ded2f656df0038de60b9c48338"

SRC_URI += "file://customization.patch \
            "

LIC_FILES_CHKSUM = "file://LICENSE;md5=b519b74b19189b3fcffdb2f72c4f992e"

S = "${WORKDIR}/git/"



# Don' own parent directories of this package. To avoid conflict in /var/www/localhost/html:
DIRFILES = "0" 

do_install () {

	# Static files installation
	install -d ${D}${base_prefix}${localstatedir}/www/localhost/html/css
	install -d ${D}${base_prefix}${localstatedir}/www/localhost/html/js

	install -m 0755 ${WORKDIR}/git/css/js-snackbar.css	${D}${base_prefix}${localstatedir}/www/localhost/html/css/js-snackbar.css
	install -m 0755 ${WORKDIR}/git/js/js-snackbar.js	${D}${base_prefix}${localstatedir}/www/localhost/html/js/js-snackbar.js
}

FILES_${PN} += "${base_prefix}${localstatedir}/www/localhost/html/css/js-snackbar.css ${base_prefix}${localstatedir}/www/localhost/html/js/js-snackbar.js"
