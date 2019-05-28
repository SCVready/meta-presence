FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://sshd_config"


INITSCRIPT_PARAMS_${PN}-sshd = "stop 20 0 1 6 ."
