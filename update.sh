#!/bin/sh

ndk-build
ant debug
adb uninstall com.example.djnadt
adb install bin/MainActivity-debug.apk
