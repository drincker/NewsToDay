package com.whatrushka.impl.appconfig.models

import androidx.datastore.core.Serializer
import com.whatrushka.api.appconfig.models.AppConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object AppConfigSerializer : Serializer<AppConfig> {
    override val defaultValue:  AppConfig
        get() = AppConfig()

    override suspend fun readFrom(input: InputStream):  AppConfig =
        try {
            Json.decodeFromString(
                deserializer = AppConfig.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: Exception) {
            println(e.stackTrace)
            defaultValue
        }

    override suspend fun writeTo(t: AppConfig, output: OutputStream) =
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = AppConfig.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }

}