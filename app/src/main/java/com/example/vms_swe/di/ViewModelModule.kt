package com.example.vms_swe.di

import com.example.vms_swe.auth.AuthPageViewModel
import com.example.vms_swe.chat.ChatPageViewModel
import com.example.vms_swe.main.TestBackViewModule
import com.example.vms_swe.profile.ProfilePageViewModel
import com.example.vms_swe.task.TaskPageViewModel
import com.example.vms_swe.task.TaskStatusChangePageViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { TestBackViewModule(get()) }
    factory { ProfilePageViewModel(get()) }
    factory { TaskPageViewModel(get()) }
    factory { TaskStatusChangePageViewModel(get()) }
    factory { ChatPageViewModel(get()) }
    factory { AuthPageViewModel(get()) }
}