LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
OPENSSL_LINK_STATIC := 1
include ../openssl-android/Android.mk

include $(CLEAR_VARS)
#GMP_LINK_STATIC := 1
include ../gmp-android/Android.mk

LOCAL_PATH := jni

include $(CLEAR_VARS)
LOCAL_MODULE := mcladt
LOCAL_SRC_FILES := mcladt.cpp ../../../mcl/src/fp.cpp
LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../openssl-android/include $(LOCAL_PATH)/../../gmp-android/include $(addsuffix /include,$(addprefix $(LOCAL_PATH)/../../../,mcl cybozulib))
LOCAL_CPPFLAGS += -O3 -DNDEBUG -fexceptions -frtti -fPIC
LOCAL_LDLIBS := -llog -latomic -Wl,--no-warn-shared-textrel
LOCAL_SHARED_LIBRARIES := gmpxx gmp
LOCAL_STATIC_LIBRARIES := crypto
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := mcl_bn256
LOCAL_SRC_FILES := ../../../mcl/src/fp.cpp ../../../mcl/java/bn256_wrap.cxx
LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../openssl-android/include $(LOCAL_PATH)/../../gmp-android/include $(addsuffix /include,$(addprefix $(LOCAL_PATH)/../../../,mcl cybozulib))
LOCAL_CPPFLAGS += -O3 -DNDEBUG -fexceptions -frtti -fPIC
LOCAL_LDLIBS := -llog -latomic -Wl,--no-warn-shared-textrel
LOCAL_SHARED_LIBRARIES := gmpxx gmp
LOCAL_STATIC_LIBRARIES := crypto
include $(BUILD_SHARED_LIBRARY)
