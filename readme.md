
# pairing library mcl for Android

This repository is a sample of [mcl](https://github.com/herumi/mcl) for Android.

# Test environment

* Nexus 7(2012)

# Download

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

```
work/
  /mcl
  /cybozulib
  /adt/
      /gmp-android
      /openssl-android
      /mcladt

```


# build
Install Java JDK and [Apache Ant](http://ant.apache.org/).
Set `ANDROID_HOME` and apend `%ANDROID_HOME%\ndk-bundle`, Java and ant to the `PATH` as the followings:
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

# Java sample code
At first, call once
```
System.loadLibrary("gnustl_shared");
System.loadLibrary("gmp");
System.loadLibrary("gmpxx");
System.loadLibrary("mcl_bn256");
```
and use `Bn256.*` functions.
See [JNI for mcl](https://github.com/herumi/mcl/blob/master/java/java.md).

`BLSsignature()` in
[MainActivity.java](src/com/herumi/mcladt/MainActivity.java) is a BLS signature sample.

## C++ sample
At first, call once
```
System.loadLibrary("gnustl_shared");
System.loadLibrary("gmp");
System.loadLibrary("gmpxx");
System.loadLibrary("mcladt");
```
`bn256_sample()` in [jni/mcl/mcladt.cpp](jni/mcladt.cpp) is a pairing sample.
