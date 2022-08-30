cmake_minimum_required(VERSION 3.1.0)
project(qtacceleratorUI VERSION 1.0.0 LANGUAGES CXX)
set(TARGET_NAME "qtacceleratorUI")

set(NAMESPACE "WPEFramework")

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_AUTOUIC ON)
set(CMAKE_AUTORCC ON)
set(CMAKE_AUTOMOC ON)

find_package(PkgConfig)
find_package(${NAMESPACE}WebSocket REQUIRED)
find_package(${NAMESPACE}Plugins REQUIRED)
find_package( ${NAMESPACE}SecurityUtil REQUIRED)



#set(CMAKE_PREFIX_PATH "/home/fkv900/tinyrtk-2808/build-mediaclient-mediabox/tmp/work/armv7ahf-neon-rdk-linux-gnueabi/qtreferenceapp/1.0-r0/recipe-sysroot/usr/lib/cmake/")
#set(OE_QMAKE_PATH_EXTERNAL_HOST_BINS "/home/fkv900/tinyrtk-2808/build-mediaclient-mediabox/tmp/work/armv7ahf-neon-rdk-linux-gnueabi/qtbase/5.12.3+gitAUTOINC+b527725766-r0/recipe-sysroot-native/usr/bin/")


list(APPEND CMAKE_PREFIX_PATH "/home/fkv900/tinyrtk-2808/build-mediaclient-mediabox/tmp/work/armv7ahf-neon-rdk-linux-gnueabi/qtbase/5.12.3+gitAUTOINC+b527725766-r0/recipe-sysroot-native/usr/lib/cmake")
list(APPEND OE_QMAKE_PATH_EXTERNAL_HOST_BINS "/home/fkv900/tinyrtk-2808/build-mediaclient-mediabox/tmp/work/armv7ahf-neon-rdk-linux-gnueabi/qtbase/5.12.3+gitAUTOINC+b527725766-r0/recipe-sysroot-native/usr/bin/")

message(" CMAKE_PREFIX_PATH : ${CMAKE_PREFIX_PATH}")
message(" HOST_BINS : ${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}")


find_package(Qt5Concurrent REQUIRED)
find_package(Qt5Gui REQUIRED)
find_package(Qt5Core REQUIRED)
find_package(Qt5Widgets REQUIRED)

#include_directories(${Qt5Core_INCLUDE_DIRS})
#add_definitions(${Qt5Core_DEFINITIONS})

set(CMAKE_CXX_FLAGS " ${CMAKE_CXX_FLAGS} -Wall -Wextra -Wpedantic -std=gnu++14")

set ( SOURCES
	main.cpp
	mainwindow.cpp
)

set ( MOC_HEADERS
	mainwindow.h
)

set ( UI_HEADERS
	mainwindow.ui
)

set ( RESOURCES
	resources.qrc
	)

set ( RESOURCES_APPLOGIC
	helpers/serviceconnector.cpp
	helpers/serviceconnector.h
	)

add_executable( ${TARGET_NAME} ${SOURCES} ${MOC_HEADERS} ${RESOURCES} ${UI_HEADERS} ${RESOURCES_APPLOGIC} )

target_link_libraries(${TARGET_NAME}
	    ${NAMESPACE}WebSocket::${NAMESPACE}WebSocket
	    ${NAMESPACE}Plugins::${NAMESPACE}Plugins
	    ${NAMESPACE}SecurityUtil
	    ${Qt5Widgets_LIBRARIES}
	    Qt5::Core
	    )

    target_include_directories(${TARGET_NAME} PRIVATE
            ${WPEFRAMEWORKWEBSOCKET_INCLUDE_DIRS})

install(TARGETS ${TARGET_NAME} DESTINATION bin)
