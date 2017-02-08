#include <jni.h>
#include <time.h>
#include <string>
#include <sstream>
#include <gmpxx.h>
#include <cybozu/crypto.hpp>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL Java_com_herumi_mcladt_MainActivity_mclTest(JNIEnv *env, jobject thiz, jint x)
	try
{
	__android_log_print(ANDROID_LOG_INFO, "native", "native code is running");
	std::ostringstream os;
	{
		std::string a = cybozu::crypto::Hash::digest(cybozu::crypto::Hash::N_SHA256, "abc", 3);
		os << "mcl a[0]=" << (int)a[0];
	}

	mpz_class v("1234567890123");
	v *= v;
	os << "v=" << v;
	jstring jstr = env->NewStringUTF(os.str().c_str());
	__android_log_print(ANDROID_LOG_INFO, "native", "finished");
	return jstr;
} catch (std::exception& e) {
	jstring jstr = env->NewStringUTF(e.what());
	return jstr;
}
