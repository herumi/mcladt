
# mcl test for Android

```
 mkdir work
 cd work
 git clone git://github.com/herumi/mcl
 git clone git://github.com/herumi/cybozulib
 md adt
 cd adt
 git clone git://github.com/herumi/gmp-android
 git clone git://github.com/herumi/openssl-android
 git clone git://github.com/herumi/mcladt
```

# build
Install Java JDK and [Apache Ant](http://ant.apache.org/).
Set `ANDROID_HOME` and apend `%ANDROID_HOME%\ndk-bundle`, Java and ant to the `PATH` such as
```

```
rem for windows
set ANDROID_HOME=<android>
set ANDROID_NDK_HOME=%ANDROID_HOME%\ndk-bundle
set PATH=%PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools;%ANDROID_NDK_HOME%\toolchains\arm-linux-androideabi-4.9\prebuilt\windows-x86_64\bin;%ANDROID_NDK_HOME%;<Java-jdk>\bin;<Ant>\bin;
```

```
ndk-build
ant debug
adb install bin/MainActivity-debug.apk
```
