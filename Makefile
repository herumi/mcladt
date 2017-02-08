PASS=djnadt
key.keystore:
	keytool -genkey -v -keystore key.keystore -alias djnadt -keyalg RSA -keysize 1024 -validity 10000 -storepass $(PASS)

bin/MainActivity-unsigned.apk: jni/mcladt.cpp
	echo make release apk
	ndk-build
	ant release

bin/MainActivity.apk: key.keystore bin/MainActivity-unsigned.apk
	jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore key.keystore bin/MainActivity-release-unsigned.apk djnadt -signedjar bin/MainActivity.apk -storepass $(PASS)

install: bin/MainActivity.apk
	adb uninstall com.example.djnadt
	adb install bin/MainActivity.apk
