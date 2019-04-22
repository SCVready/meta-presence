SUMMARY = "This projects implements Socket.IO clients and servers that can run standalone \
or integrated with a variety of Python web frameworks."

DESCRIPTION = "Socket.IO is a transport protocol that enables real-time bidirectional \
event-based communication between clients (typically, though not always, web browsers) \
and a server. The official implementations of the client and server components are \
written in JavaScript. This package provides Python implementations of both, each with \
standard and asyncio variants."

HOMEPAGE = "https://python-socketio.readthedocs.io/en/latest/intro.html#what-is-socket-io"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=5aa2f1d4ea55d60497aa8c3debf29ab2"

SRC_URI[md5sum] = "e095bf3358175489a956949c1b4de9ff"
SRC_URI[sha256sum] = "7eaef32968290c9121f7c35b973e2cc302ffb076d018c9068d2f5ca8b2d85fb0"

inherit pypi setuptools3

PYPI_PACKAGE = "gevent-websocket"
