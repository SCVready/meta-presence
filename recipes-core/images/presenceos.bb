SUMMARY = "PresenceOS image"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

LOCALE_UTF8_ONLY="1"

IMAGE_INSTALL_append+="openssh"
IMAGE_INSTALL_append+="glibc-utils localedef"
IMAGE_INSTALL_append+="kinectalarm"
IMAGE_INSTALL_append+="nginx"
IMAGE_INSTALL_append+="webapp"
IMAGE_INSTALL_append+="gen-cert"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

