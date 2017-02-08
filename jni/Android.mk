LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
include ../openssl-android/Android.mk

include $(CLEAR_VARS)
GMP_WITH_CPLUSPLUS := yes
include jni/gmp/Android.mk
LOCAL_PATH := jni

include $(CLEAR_VARS)
LOCAL_MODULE := mcladt
LOCAL_SRC_FILES := mcladt.cpp
LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../openssl-android/include $(addsuffix /include,$(addprefix $(LOCAL_PATH)/../../../,mcl cybozulib))
LOCAL_CPPFLAGS += -O3 -DNDEBUG -fexceptions -frtti -fPIC
LOCAL_LDLIBS := -llog -latomic
LOCAL_SHARED_LIBRARIES := gmp gmpxx
LOCAL_STATIC_LIBRARIES := crypto ssl
include $(BUILD_SHARED_LIBRARY)
