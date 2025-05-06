package com.example.lokalinternassignment.domain.helperFunction

import com.example.lokalinternassignment.data.offline.room.EachJob
import com.example.lokalinternassignment.domain.models.apiModels.Job

fun Job.toEachJob(): EachJob {
    return EachJob(
        title = this.title,
        salary = this.primary_details.Salary,
        place = this.primary_details.Place,
        whatsapp_no = this.whatsapp_no,
        image_url = this.creatives.firstOrNull()?.image_url ?: "",
        company_name = this.company_name,
        experience = this.primary_details.Experience,
        job_hours = this.job_hours
    )
}
