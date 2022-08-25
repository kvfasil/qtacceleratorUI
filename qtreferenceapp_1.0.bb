SUMMARY = "This is a test qtapp for native UI testing."
DESCRIPTION = "qtapp for testing."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a88ffe979bbdfb67bc2a6b179d6038c"

SRC_URI = "git://github.com/kvfasil/qtacceleratorUI.git;protocol=git;branch=main"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS += " qtbase qtwayland wayland "

inherit autotools pkgconfig cmake

FILES_${PN} = "${bindir}/*"
