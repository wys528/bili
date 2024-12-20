package com.example.bili.data

import com.example.bili.R
import com.example.bili.model.UpList

class DataSender {
    fun onCreateData():List<UpList>{
        return listOf(UpList("up1", R.drawable.img),
            UpList("up2",R.drawable.img_1),
            UpList("up3",R.drawable.img_2),
            UpList("up4",R.drawable.img_3),
            UpList("up5",R.drawable.img_4),
            UpList("up6",R.drawable.img_5),
            UpList("up7",R.drawable.img_6)
        )
    }
}