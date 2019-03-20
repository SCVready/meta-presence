SUMMARY = "This project implements Python based Engine.IO client and server that can \
run standalone or integrated with a variety of Python web frameworks and applications."

DESCRIPTION = "Engine.IO is a lightweight transport protocol that enables real-time \
bidirectional event-based communication between clients (typically, though not always\
, web browsers) and a server. The official implementations of the client and server \
components are written in JavaScript. This package provides Python implementations \
of both, each with standard and asyncio variants."

HOMEPAGE = "https://python-engineio.readthedocs.io/en/latest/intro.html"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=42d0a9e728978f0eeb759c3be91536b8"

SRC_URI[md5sum] = "011a61f1ee84755043cf862c8cc24f21"
SRC_URI[sha256sum] = "b2756ce53076163eb24f59c1d1a903ac72f071ad4fb7b3ef6dab1b1b9ae9a44f"

inherit pypi setuptools3

PYPI_PACKAGE = "python-engineio"
