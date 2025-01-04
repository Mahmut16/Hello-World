#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_google_android_helloworld_MainActivity_stringFromJNI(JNIEnv* env, jobject) {
    return env->NewStringUTF("Hello from C++");
}