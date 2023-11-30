package com.example.data.di

import com.example.data.network.mapper.CarMapper
import com.example.data.network.mapper.ChatMapper
import com.example.data.network.mapper.ChatUserMapper
import com.example.data.network.mapper.DriverMapper
import com.example.data.network.mapper.LoginMapper
import com.example.data.network.mapper.MessageMapper
import com.example.data.network.mapper.RouteMapper
import com.example.data.network.mapper.UserMapper
import com.example.domain.model.ChatUser
import org.koin.dsl.module

val mapperModule = module {
    factory { CarMapper() }
    factory { UserMapper() }
    factory { DriverMapper(get(), get()) }
    factory { RouteMapper() }
    factory { ChatUserMapper() }
    factory { MessageMapper() }
    factory { ChatMapper(get(), get()) }
    factory { LoginMapper() }

}