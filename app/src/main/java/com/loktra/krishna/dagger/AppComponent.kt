package com.loktra.krishna.dagger

import com.loktra.krishna.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface AppComponent  {
    fun inject(target: MainActivity)
}