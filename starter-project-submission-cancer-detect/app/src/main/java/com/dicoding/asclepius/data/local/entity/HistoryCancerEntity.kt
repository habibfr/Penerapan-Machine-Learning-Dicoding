package com.dicoding.asclepius.data.local.entity
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "history_cancer")
class HistoryCancerEntity(
    @ColumnInfo("id")
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

    @ColumnInfo("img")
    val imagePath: String? = null,

    @ColumnInfo("label")
    val label: String? = null,

    @ColumnInfo("score")
    val score: Float? = 0f,

    @ColumnInfo(name = "date")
    var date: String? = null
) : Parcelable