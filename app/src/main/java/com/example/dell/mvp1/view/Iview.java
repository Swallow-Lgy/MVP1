package com.example.dell.mvp1.view;

public interface Iview<T> {
    void success(T data);
    void fail(String msg);
}
