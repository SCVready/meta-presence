LICENSE="CLOSED"
LIC_FILES_CHKSUM=""

SRC_URI[md5sum] = "335dcb8802192a173604170959a40abc"
SRC_URI[sha256sum] = "5194a49e86b40ffc57055f73d833f87e39dce6fce934683e7d0d5bbb8eff3b8c"

inherit pypi setuptools3

DEPEND_${PN} += " python3-cffi python3-cryptography"

PYPI_PACKAGE = "python-augeas"
