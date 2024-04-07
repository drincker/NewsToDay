package com.whatrushka.impl.appbookmarks.models


import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import androidx.datastore.core.Serializer
import com.whatrushka.api.appbookmarks.models.Articles


@Suppress("BlockingMethodInNonBlockingContext")
class ArticleSerializer : Serializer<Articles>{
    override val defaultValue: Articles
        get() = Articles()

    override suspend fun readFrom(input: InputStream): Articles {
        return try {
            Json.decodeFromString(
                deserializer = Articles.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: Articles, output: OutputStream) {
        output.write(
             Json.encodeToString(
                serializer = Articles.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }

}



