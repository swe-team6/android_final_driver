package com.example.vms_swe.di

import com.example.domain.use_cases.GetAllDriverUseCase
import org.koin.dsl.module

val useCaseModule = module{
    factory { GetAllDriverUseCase(get()) }
}