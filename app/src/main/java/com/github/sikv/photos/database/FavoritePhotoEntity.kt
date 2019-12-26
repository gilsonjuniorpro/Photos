package com.github.sikv.photos.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.sikv.photos.model.Photo
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "FavoritePhoto")
@Parcelize
class FavoritePhotoEntity(
        @PrimaryKey
        var id: String,
        var url: String,
        var photographer: String,
        var originalSource: String
) : Photo() {

    companion object {
        fun fromPhoto(photo: Photo): FavoritePhotoEntity {
            return FavoritePhotoEntity(
                    photo.getPhotoId(),
                    photo.getSmallUrl(),
                    photo.getPhotographerName(),
                    photo.getSource()
            )
        }
    }

    override fun getPhotoId(): String {
        return id
    }

    override fun getSmallUrl(): String {
        return url
    }

    override fun getPhotographerName(): String {
        return photographer
    }

    override fun getSource(): String {
        return originalSource
    }

    override fun isLocalPhoto(): Boolean {
        return true
    }
}