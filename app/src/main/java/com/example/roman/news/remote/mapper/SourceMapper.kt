package com.example.roman.news.remote.mapper

import android.util.Log
import com.example.roman.news.data.model.Source
import com.example.roman.news.remote.model.SourceRemoteEntity
import javax.inject.Inject

class SourceMapper @Inject constructor(): Mapper<SourceRemoteEntity,Source>{

    override fun map(remote: SourceRemoteEntity) : Source {
        val s = Source(remote.name)
        Log.i("ss", s.name)
        return s
    }
}