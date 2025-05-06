package com.example.lokalinternassignment.data.offline.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "each_job")
data class EachJob (
    @PrimaryKey val jid : Int,
    @ColumnInfo (name = "title") val title : String? = null,
    @ColumnInfo (name = "salary") val salary : String? = null,
    @ColumnInfo (name = "place") val place : String? = null,
    @ColumnInfo (name = "whatsapp_no") val whatsapp_no : String? = null,

    // for entry of second page in details
    @ColumnInfo (name = "image_url") val image_url : String? = null,
    @ColumnInfo (name = "company_name") val company_name : String? = null,
    @ColumnInfo (name = "experience") val experience : String? = null,    // from job.primarydetails in the api
    @ColumnInfo (name = "job_hours") val job_hours : String? = null,

)