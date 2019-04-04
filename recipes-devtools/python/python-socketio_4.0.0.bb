SUMMARY = "This projects implements Socket.IO clients and servers that can run standalone \
or integrated with a variety of Python web frameworks."

DESCRIPTION = "Socket.IO is a transport protocol that enables real-time bidirectional \
event-based communication between clients (typically, though not always, web browsers) \
and a server. The official implementations of the client and server components are \
written in JavaScript. This package provides Python implementations of both, each with \
standard and asyncio variants."

HOMEPAGE = "https://python-socketio.readthedocs.io/en/latest/intro.html#what-is-socket-io"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=42d0a9e728978f0eeb759c3be91536b8"

SRC_URI[md5sum] = "0b57da61a9464d2e0dc9a8d0164d86d2"
SRC_URI[sha256sum] = "64feb0817f1bf7e3e7fc05f6f65e28d76146d8061cb7de25b63502717f80e908"

inherit pypi setuptools

PYPI_PACKAGE = "python-socketio"
