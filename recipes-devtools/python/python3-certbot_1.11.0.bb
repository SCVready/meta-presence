SUMMARY = "Certbot is a fully-featured, extensible client for the Let’s Encrypt CA \
(or any other CA that speaks the ACME protocol) that can automate the tasks of \
obtaining certificates and configuring webservers to use them."

DESCRIPTION = "Certbot is an easy-to-use client that fetches a certificate from \
Let’s Encrypt—an open certificate authority launched by the EFF, Mozilla, and \
others—and deploys it to a web server."

HOMEPAGE = "https://certbot.eff.org/"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=16542115f15152bdc6d80c5b5d208e70"

SRC_URI[md5sum] = "4b7641fa2f02460f8f98c88f10704ecf"
SRC_URI[sha256sum] = "6b0ce04e55379aff0a47f873fa05c084538ad0f4a9b79f33108dbb0a7a668b43"

inherit pypi setuptools3

PYPI_PACKAGE = "certbot"

RDEPENDS_${PN} += " \
    python3-certbot             \
    python3-certbot-nginx       \
    python3-setuptools          \
    python3-zope.interface      \
    python3-zope.component      \
    python3-pytz                \
    python3-cffi                \
    python3-chardet             \
    python3-certifi             \
    python3-cryptography        \
    python3-idna                \
    python3-configargparse      \
    python3-configobj           \
    python3-distro              \
    python3-enum34              \
    python3-funcsigs            \
    python3-ipaddress           \
    python3-josepy              \
    python3-mock                \
    python3-parsedatetime       \
    python3-pyopenssl           \
    python3-pyrfc3339           \
    python3-pycparser           \
    python3-requests-toolbelt   \
    python3-six                 \
    python3-urllib3             \
    python3-zope.deferredimport \
    python3-zope.deprecation    \
    python3-zope.event          \
    python3-zope.hookable       \
    python3-zope.proxy          \
    python3-acme                \
    python3-requests            \
    python3-fcntl               \
    python3-pyparsing           \
"