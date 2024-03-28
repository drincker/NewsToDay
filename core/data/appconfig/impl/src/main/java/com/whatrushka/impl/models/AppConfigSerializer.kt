package com.whatrushka.impl.models

import androidx.datastore.core.Serializer
import com.whatrushka.api.models.AppConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object AppConfigSerializer : Serializer<AppConfig> {
    override val defaultValue: AppConfig
        get() = AppConfig()

    override suspend fun readFrom(input: InputStream): com.whatrushka.api.models.AppConfig =
        try {
            Json.decodeFromString(
                deserializer = com.whatrushka.api.models.AppConfig.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: Exception) {
            println(e.stackTrace)
            defaultValue
        }

    override suspend fun writeTo(t: com.whatrushka.api.models.AppConfig, output: OutputStream) =
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = com.whatrushka.api.models.AppConfig.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }

}