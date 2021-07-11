SUMMARY = "PresenceOS image"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

LOCALE_UTF8_ONLY="1"

PV="0.1"

IMAGE_INSTALL_append+="openssh"
IMAGE_INSTALL_append+="glibc-utils localedef"
IMAGE_INSTALL_append+="kinectalarm"
IMAGE_INSTALL_append+="nginx"
IMAGE_INSTALL_append+="webapp"
IMAGE_INSTALL_append+="emailsender"
IMAGE_INSTALL_append+="gen-cert"
IMAGE_INSTALL_append+="webapp-keygen"
IMAGE_INSTALL_append+="resizerootfs"
IMAGE_INSTALL_append+="noip"
IMAGE_INSTALL_append+="letsencript"
IMAGE_INSTALL_append+="date-update"

IMAGE_INSTALL_append+="redis"
IMAGE_INSTALL_append+="python-redis"
IMAGE_INSTALL_append+="hiredis"
IMAGE_INSTALL_append+="libevent"
IMAGE_INSTALL_append+="sqlite3"
IMAGE_INSTALL_append+="python-pysqlite"

IMAGE_INSTALL_append+="rsync"
IMAGE_INSTALL_append+="zip"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

