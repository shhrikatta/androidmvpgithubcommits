package com.loktra.krishna.dagger

import com.loktra.krishna.presenter.MainPresenter
import com.loktra.krishna.presenter.Presenter
import com.loktra.krishna.view.MainMvpView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideMainpagePresenter(): Presenter<MainMvpView> = MainPresenter()
}