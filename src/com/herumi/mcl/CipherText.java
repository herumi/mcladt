/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.herumi.mcl;

public class CipherText {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected CipherText(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CipherText obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ElgamalJNI.delete_CipherText(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public String toStr() {
    return ElgamalJNI.CipherText_toStr(swigCPtr, this);
  }

  public String toString() {
    return ElgamalJNI.CipherText_toString(swigCPtr, this);
  }

  public void fromStr(String str) {
    ElgamalJNI.CipherText_fromStr(swigCPtr, this, str);
  }

  public void add(CipherText c) {
    ElgamalJNI.CipherText_add(swigCPtr, this, CipherText.getCPtr(c), c);
  }

  public void mul(int m) {
    ElgamalJNI.CipherText_mul__SWIG_0(swigCPtr, this, m);
  }

  public void mul(String str) {
    ElgamalJNI.CipherText_mul__SWIG_1(swigCPtr, this, str);
  }

  public CipherText() {
    this(ElgamalJNI.new_CipherText(), true);
  }

}