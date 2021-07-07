SUMMARY = "Certbot is a fully-featured, extensible client for the Let’s Encrypt CA \
(or any other CA that speaks the ACME protocol) that can automate the tasks of \
obtaining certificates and configuring webservers to use them."

DESCRIPTION = "Certbot is an easy-to-use client that fetches a certificate from \
Let’s Encrypt—an open certificate authority launched by the EFF, Mozilla, and \
others—and deploys it to a web server."

HOMEPAGE = "https://certbot.eff.org/"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=76bc61270993bdcec50035bc9e60f8d5"

SRC_URI[md5sum] = "8a9db62bd49f3dcc0fa9623367a14f7b"

SRC_URI[sha256sum] = "9afe611f99a78b8898941b8ad7bdcf7f3c2b6e0fce27125268f7c713e64b34ee"

inherit pypi setuptools3

PYPI_PACKAGE = "certbot-nginx"
