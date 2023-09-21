package com.example.androidbase.presentation.ui.example

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Parcelize
@Serializable
data class Resource(
    val id: Int,
    val title: String,
    val description: String,
    val file_type: String,
    val liked: String,
) : Parcelable


object UUIDSerializer : KSerializer<Boolean> {
    override val descriptor = PrimitiveSerialDescriptor("liked", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Boolean {
        return true
    }

    override fun serialize(encoder: Encoder, value: Boolean) {
        encoder.encodeBoolean(value)
    }
}

@Serializer(forClass = Boolean::class)
object IntToBooleanSerializer : KSerializer<Boolean> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Boolean", PrimitiveKind.BOOLEAN)

    override fun serialize(encoder: Encoder, value: Boolean) {
        encoder.encodeInt(if (value) 1 else 0)
    }

    override fun deserialize(decoder: Decoder): Boolean {
        return decoder.decodeInt() != 0
    }
}


