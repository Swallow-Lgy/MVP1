package com.example.loagin.view.view;

public interface IView<T> {
    void success(T data);
    void fail(String msg);
}
