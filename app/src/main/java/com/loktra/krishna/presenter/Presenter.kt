package com.loktra.krishna.presenter

interface Presenter<V> {

    fun attachView(view: V)

    fun detachView()

}
