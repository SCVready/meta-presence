SUMMARY = "Socket.IO integration for Flask applications."

DESCRIPTION = "Flask-SocketIO gives Flask applications access to low latency \
bi-directional communications between the clients and the server. The client-side \
application can use any of the SocketIO official clients libraries in Javascript, \
C++, Java and Swift, or any compatible client to establish a permanent connection \
to the server."

HOMEPAGE = "https://flask-socketio.readthedocs.io/en/latest/"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=38cc21254909604298ce763a6e4440a0"

SRC_URI[md5sum] = "298965a43f6534e8a5b24d1ba1fc4186"
SRC_URI[sha256sum] = "8d8f9f104db5ddff1b06ba322d8e158881d590144199c993fe26cf53218c7edd"

inherit pypi setuptools3

PYPI_PACKAGE = "Flask-SocketIO"

RDEPENDS_${PN}_class-target = "${PYTHON_PN}-flask"
