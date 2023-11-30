package com.example.data.di

import com.example.data.repository.DriverRepositoryImpl
import com.example.domain.repository.DriverRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<DriverRepository> { DriverRepositoryImpl(get(),get(),get(), get(), get(), get()) }
}