SUMMARY = "This is a test qtapp for native UI testing."
DESCRIPTION = "qtapp for testing."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a88ffe979bbdfb67bc2a6b179d6038c"

SRC_URI = "git://github.com/kvfasil/qtacceleratorUI.git;protocol=git;branch=main"
#SRC_URI[sha256sum] = "a69cbb6f00fc372be216fdae6798a3a76314d0cf82137f3067c36638916c0122"

#SRCREV = "fe26e0be7ce28e46e29b66c8b201a4de05edc9fb"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS += " qtbase qtwayland wayland "


do_install_append () {
	install -d ${D}${bindir}
	install -m 0775 qtacceleratorUI ${D}${bindir}/qtreferenceapp
}

FILES_${PN} = "${bindir}/qtreferenceapp"

inherit qmake5


