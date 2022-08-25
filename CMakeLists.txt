cmake_minimum_required(VERSION 3.1.0)
project(qtacceleratorUI VERSION 1.0.0 LANGUAGES CXX)
set(TARGET_NAME "qtacceleratorUI")

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_AUTOUIC ON)
set(CMAKE_AUTORCC ON)
set(CMAKE_AUTOMOC ON)

find_package(Qt5 COMPONENTS Core REQUIRED)
find_package(Qt5 COMPONENTS Widgets REQUIRED)
find_package(Qt5 COMPONENTS Concurrent REQUIRED)
find_package(Qt5 COMPONENTS Gui REQUIRED)

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

QT5_WRAP_UI( UI_HEADERS ${UIS} )

add_executable( ${TARGET_NAME} ${SOURCES} ${MOC_HEADERS} ${RESOURCES} ${UI_HEADERS} )

target_link_libraries(${TARGET_NAME} Qt5::Widgets Qt5::Core)
